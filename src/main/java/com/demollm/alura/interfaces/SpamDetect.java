package com.demollm.alura.interfaces;

import com.demollm.alura.enums.Harmless;

import dev.langchain4j.service.UserMessage;

public interface SpamDetect {

    @UserMessage("""
                Analise se o texto sobre um aplicativo de saúde mental é inofensivo ou ofensivo \n
                texto: \n
                {{it}}
            """)
    Harmless detectOffenses(String text);

}
