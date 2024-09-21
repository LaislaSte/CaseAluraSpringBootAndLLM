package com.demollm.alura.interfaces;

import dev.langchain4j.service.UserMessage;

public interface AssistantResponse {
    @UserMessage("""
                    Você atuará como um assistent virtual. Com base na classe recebida, analise os valores dos parametros e escreva uma breve resposta para o feedback do usuário. \n seja educado, simples e evite palavras ofensivas.
                    classe:
                    {{it}}
            """)
    String getAssistantResponse(String insight);
}
