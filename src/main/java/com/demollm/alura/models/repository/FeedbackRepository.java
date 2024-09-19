package com.demollm.alura.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demollm.alura.models.bean.Feedback;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

}
