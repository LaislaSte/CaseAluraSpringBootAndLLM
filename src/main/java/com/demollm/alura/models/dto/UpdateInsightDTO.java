package com.demollm.alura.models.dto;

import java.util.List;

import com.demollm.alura.models.bean.Feedback;
import com.demollm.alura.models.bean.Intent;

public record UpdateInsightDTO(
                Long id,
                Feedback feedback,
                String sentiment,
                List<Intent> intent) {

}
