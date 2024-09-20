package com.demollm.alura.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demollm.alura.models.bean.Insight;
import com.demollm.alura.models.dto.UpdateInsightDTO;
import com.demollm.alura.models.repository.InsightRepository;

@Service
public class InsightService {
    @Autowired
    private InsightRepository insightRepository;

    public List<Insight> list() {
        return insightRepository.findAll();
    }

    public Insight findById(long id) {
        return insightRepository.findById(id).orElse(null);
    }

    public Insight create(Insight insight) {
        Insight savedItem = insightRepository.save(insight);
        return savedItem;

    }

    public Insight deleteById(long id) {
        Insight item = insightRepository.findById(id).orElse(null);
        if (item != null) {
            insightRepository.deleteById(id);
            return item;
        } else {
            return null;
        }
    }

    public Insight update(Long id, UpdateInsightDTO updateInsightDTO) {
        Insight item = insightRepository.findById(updateInsightDTO.id()).orElse(null);
        if (item != null) {
            item.setFeedback(updateInsightDTO.feedback());
            item.setSentiment(updateInsightDTO.sentiment());
            item.setIntent(updateInsightDTO.intent());
            insightRepository.save(item);
        }

        return item;
    }
}
