package com.demollm.alura.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demollm.alura.models.bean.Intent;
import com.demollm.alura.models.dto.UpdateIntentDTO;
import com.demollm.alura.models.repository.IntentRepository;

@Service
public class IntentService {
    @Autowired
    private IntentRepository intentRepository;

    public List<Intent> list() {
        return intentRepository.findAll();
    }

    public Intent findById(long id) {
        return intentRepository.findById(id).orElse(null);
    }

    public Intent create(Intent intent) {
        Intent savedItem = intentRepository.save(intent);
        return savedItem;

    }

    public Intent deleteById(long id) {
        Intent item = intentRepository.findById(id).orElse(null);
        if (item != null) {
            intentRepository.deleteById(id);
            return item;
        } else {
            return null;
        }
    }

    public Intent update(Long id, UpdateIntentDTO updateIntentDTO) {
        Intent item = intentRepository.findById(updateIntentDTO.id()).orElse(null);
        if (item != null) {
            item.setIntentCod(updateIntentDTO.intentCod());
            item.setReason(updateIntentDTO.reason());
            intentRepository.save(item);
        }

        return item;
    }
}
