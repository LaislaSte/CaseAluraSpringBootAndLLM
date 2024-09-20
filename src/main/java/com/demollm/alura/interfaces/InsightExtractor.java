package com.demollm.alura.interfaces;

import com.demollm.alura.models.bean.Insight;

import dev.langchain4j.service.UserMessage;

public interface InsightExtractor {
    @UserMessage("Extract information to complete the Insight format from {{it}}")
    Insight extractInsightFrom(String text);
}
