package com.demollm.alura.interfaces;

import com.demollm.alura.models.bean.Insight;

import dev.langchain4j.service.UserMessage;

public interface InsightExtractor {
    @UserMessage("""
                Extraia do texto informações como sentimento negativo ou positivo, menção de funcionalidade do aplicativo, e complete o formato Insight. A propriedade id sempre terá valor null. Os valores das propriedades estão como português brasileiro. A propriedade intentCod define que tipo de funcionalidade é mencionada na Intent e a propriedade reason o pedaço do texto que justifique a intendCod \n
                texto: \n
                {{it}}
            """)
    Insight extractInsightFrom(String text);
}
