package com.demollm.alura.models.bean;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Feedback {

    @Id
    @Nonnull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String user;

    @Nonnull
    private String text;

    @OneToOne
    private Insight insight;

    public Feedback(String user, String text, Insight insight) {
        this.user = user;
        this.text = text;
        this.insight = insight;
    }

    public Feedback(Long id, String user, String text, Insight insight) {
        this.id = id;
        this.user = user;
        this.text = text;
        this.insight = insight;
    }

    public Feedback(Long id, String user, String text) {
        this.id = id;
        this.user = user;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Insight getInsight() {
        return insight;
    }

    public void setInsight(Insight insight) {
        this.insight = insight;
    }

    @Override
    public String toString() {
        return "Feedback [id=" + id + ", user=" + user + ", text=" + text + ", insight=" + insight + "]";
    }

}
