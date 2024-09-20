package com.demollm.alura.models.bean;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Intent {
    @Id
    @Nonnull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nonnull
    private String intentCod;

    @Nonnull
    private String reason;

    public Intent() {
    }

    public Intent(String intentCod, String reason) {
        this.intentCod = intentCod;
        this.reason = reason;
    }

    public Intent(Long id, String intentCod, String reason) {
        this.id = id;
        this.intentCod = intentCod;
        this.reason = reason;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIntentCod() {
        return intentCod;
    }

    public void setIntentCod(String intentCod) {
        this.intentCod = intentCod;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "Intent [id=" + id + ", intentCod=" + intentCod + ", reason=" + reason + "]";
    }

}
