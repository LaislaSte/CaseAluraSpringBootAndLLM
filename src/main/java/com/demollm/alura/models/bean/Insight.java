
package com.demollm.alura.models.bean;

import java.util.List;

import jakarta.annotation.Nonnull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

/**
 * Insight
 */
@Entity
public class Insight {

    // String text;
    // Int id;
    // Int idFeedback;
    // String: sentiment; (POS OU NEG)
    // Intent: intent;
    // String intentCod
    // String reason

    @Id
    @Nonnull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nonnull
    private String sentiment;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "feedback_id", referencedColumnName = "id") // This means Foreign key will be created only in the
                                                                   // Insight table i.e. extra column 'feedback_id' will
                                                                   // be
                                                                   // created in the Insight table
    private Feedback feedback;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "intent_id", referencedColumnName = "id")
    private List<Intent> intent;

    public Insight() {
    }

    public Insight(Long id, Feedback feedback, String sentiment, List<Intent> intent) {
        this.id = id;
        this.feedback = feedback;
        this.sentiment = sentiment;
        this.intent = intent;
    }

    public Insight(Long id, String sentiment, List<Intent> intent) {
        this.id = id;
        this.sentiment = sentiment;
        this.intent = intent;
    }

    public Insight(String sentiment, Feedback feedback, List<Intent> intent) {
        this.sentiment = sentiment;
        this.feedback = feedback;
        this.intent = intent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSentiment() {
        return sentiment;
    }

    public void setSentiment(String sentiment) {
        this.sentiment = sentiment;
    }

    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }

    public List<Intent> getIntent() {
        return intent;
    }

    public void setIntent(List<Intent> intent) {
        this.intent = intent;
    }

    @Override
    public String toString() {
        return "Insight [id=" + id + ", sentiment=" + sentiment + ", feedback=" + feedback + ", intent=" + intent + "]";
    }

}