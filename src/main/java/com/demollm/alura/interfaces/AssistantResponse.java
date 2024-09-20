package com.demollm.alura.interfaces;

import dev.langchain4j.service.UserMessage;

public interface AssistantResponse {
    @UserMessage("""
            Com base na classe recebida no formato de Insight, escreva uma breve
            resposta de um assistente virtual para o feedback do usuário
            Insight format:
            {{it}}
            """)
    String getAssistantResponse(String insight);
}
