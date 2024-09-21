package com.demollm.alura.interfaces;

import com.demollm.alura.models.bean.Insight;

import dev.langchain4j.service.UserMessage;

public interface InsightExtractor {
    @UserMessage("""
                Você está analisando um comentário de um usuário sobre um aplicativo de saúde mental. \n Extraia do texto informações como sentimento, se é NEGATIVO ou POSITIVO, e uma menção de alguma funcionalidade do aplicativo, complete o formato Insight com estas informações. \n A propriedade id sempre terá valor null. \n responda com português brasileiro. \n A propriedade intentCod é um códico em uppercase que define que tipo de funcionalidade do aplicativo que é mencionada e a propriedade reason o pedaço do texto que justifique esta intendCod. \n você pode colocar o nome que quiser na propriedade user do feedback \n \n
                texto: \n
                {{it}}
            """)
    Insight extractInsightFrom(String text);
}
