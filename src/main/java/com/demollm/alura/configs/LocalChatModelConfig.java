package com.demollm.alura.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.ollama.OllamaChatModel;

@Configuration
@Profile("local")
public class LocalChatModelConfig {
    @Bean
    ChatLanguageModel ollamaAIChatLanguageModel() {
        return OllamaChatModel.builder()
                .baseUrl("http://localhost:11434/")
                .modelName("phi3.5")
                .logRequests(true)
                .logResponses(true)
                .build();
    }
}