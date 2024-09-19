package com.demollm.alura.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demollm.alura.models.bean.Feedback;
import com.demollm.alura.models.dto.CreateFeedbackDTO;
import com.demollm.alura.models.dto.UpdateFeedbackDTO;
import com.demollm.alura.models.repository.FeedbackRepository;

@Service
public class FeedbackService {
    @Autowired
    private FeedbackRepository feedbackRepository;

    public List<Feedback> list() {
        return feedbackRepository.findAll();
    }

    public Feedback findById(long id) {
        return feedbackRepository.findById(id).orElse(null);
    }

    public Feedback create(CreateFeedbackDTO createFeedbackDTO) {
        Feedback item = new Feedback(createFeedbackDTO.id(), createFeedbackDTO.user(), createFeedbackDTO.text());
        Feedback savedItem = feedbackRepository.save(item);
        return savedItem;

    }

    public Feedback deleteById(long id) {
        Feedback item = feedbackRepository.findById(id).orElse(null);
        if (item != null) {
            feedbackRepository.deleteById(id);
            return item;
        } else {
            return null;
        }
    }

    public Feedback update(Long id, UpdateFeedbackDTO updateFeedbackDTO) {
        Feedback item = feedbackRepository.findById(id).orElse(null);
        if (item != null) {
            item.setText(updateFeedbackDTO.text());
            item.setUser(updateFeedbackDTO.user());
            feedbackRepository.save(item);
        }

        return item;
    }
}
