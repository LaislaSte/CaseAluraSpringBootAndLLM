package com.demollm.alura.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demollm.alura.interfaces.AssistantResponse;
import com.demollm.alura.interfaces.InsightExtractor;
import com.demollm.alura.models.bean.Feedback;
import com.demollm.alura.models.bean.Insight;
import com.demollm.alura.models.bean.Intent;
import com.demollm.alura.models.dto.GetInsightDTO;
import com.demollm.alura.services.FeedbackService;
import com.demollm.alura.services.InsightService;
import com.demollm.alura.services.IntentService;

import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.service.AiServices;

@RestController
public class ChatModelController {

    @Autowired
    private IntentService intentService;

    @Autowired
    private InsightService insightService;

    @Autowired
    private FeedbackService feedbackService;

    private final ChatLanguageModel chatLanguageModel;

    public ChatModelController(ChatLanguageModel chaBuilder) {
        this.chatLanguageModel = chaBuilder;
    }

    @GetMapping("/")
    public String index() {
        return "Application is running";
    }

    @GetMapping("/testModel")
    public ResponseEntity<String> testModel() {
        String question = "Who painted the Mona Lisa?";
        return ResponseEntity.ok(chatLanguageModel.generate(UserMessage.from(question)).content().text());
    }

    @GetMapping("/prompt1")
    public ResponseEntity<Insight> getResponseP1(@RequestBody GetInsightDTO request) {

        InsightExtractor extractor = AiServices.create(InsightExtractor.class, chatLanguageModel);

        String text = request.feedback();

        Insight insight = extractor.extractInsightFrom(text);

        Feedback createdFeedback = feedbackService.create(insight.getFeedback());

        insight.setFeedback(createdFeedback);
        Intent intent;
        List<Intent> intents = new ArrayList<Intent>();
        for (Intent intentIdx : insight.getIntent()) {
            intent = new Intent(intentIdx.getIntentCod(), intentIdx.getReason());
            intents.add(intentService.create(intent));
        }

        insight.setIntent(intents);

        Insight createdInsight = insightService.create(insight);

        return new ResponseEntity<Insight>(createdInsight, HttpStatus.OK);
    }

    @GetMapping("/assistantResponseFor/{id}")
    public ResponseEntity<String> getAssisResp(@PathVariable("id") long id) {
        AssistantResponse extractor = AiServices.create(AssistantResponse.class, chatLanguageModel);

        Insight insight = insightService.findById(id);

        String assistantResponse = extractor.getAssistantResponse(insight.toString());
        return new ResponseEntity<String>(assistantResponse, HttpStatus.OK);
    }

}
