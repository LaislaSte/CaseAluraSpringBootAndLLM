package com.demollm.alura.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.chat.ChatLanguageModel;

@RestController
@RequestMapping(path = "/test")
public class ChatModelController {

    private final ChatLanguageModel chatLanguageModel;

    public ChatModelController(ChatLanguageModel chaBuilder) {
        this.chatLanguageModel = chaBuilder;
    }

    private static final String prompt1 = """
            Você é um assistente de um aplicativo sobre saúde mental que me ajudará a analisar se a frase de um usuário tem um tom negativo ou positivo \n
            Identifique no texto possível feedback sobre alguma funcionalidade do aplicativo e coloque uma tag que resuma esta funcionalidade mencionada
            format: \n
            {
            "sentiment": "POSITIVO" or "NEGATIVO",
            "requested_features": [
                {
                "code": "EDITAR_PERFIL",
                "reason": ...
                },
                {
                "code": "VISUALIZAR_TRILHA",
                "reason": ...
                }
            ]

            }
            frase: \n
            "Gosto muito de usar o Alumind! Está me ajudando bastante em relação a alguns problemas que tenho. Só queria que houvesse uma forma mais fácil de eu mesmo realizar a edição do meu perfil dentro da minha conta" \n
            resposta: \n
                """;

    @GetMapping("/test")
    public ResponseEntity<String> testModel() {
        String question = "Who painted the Mona Lisa?";
        return ResponseEntity.ok(chatLanguageModel.generate(UserMessage.from(question)).content().text());
    }

}
