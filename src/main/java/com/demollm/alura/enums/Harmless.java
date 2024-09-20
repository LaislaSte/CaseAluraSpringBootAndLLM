package com.demollm.alura.enums;

import dev.langchain4j.model.output.structured.Description;

public enum Harmless {
    @Description("OFFENSIVE - Comentário que contém palavras ofensivas, xingamentos ou preconceito")
    OFFENSIVE,

    @Description("HARMLESS - Comentário que contém um feedback, é inovensito ou fala do aplicativo")
    HARMLESS;
}
