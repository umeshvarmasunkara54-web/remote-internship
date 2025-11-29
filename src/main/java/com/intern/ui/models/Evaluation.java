package com.intern.ui.models;

import java.util.concurrent.atomic.AtomicLong;

public class Evaluation {
    private static final AtomicLong COUNTER = new AtomicLong(0);
    private final long id;
    private long internshipId;
    private int score;
    private String comments;

    public Evaluation() { this.id = COUNTER.incrementAndGet(); }

    public Evaluation(long internshipId, int score, String comments) {
        this.id = COUNTER.incrementAndGet();
        this.internshipId = internshipId;
        this.score = score;
        this.comments = comments;
    }

    public long getId() { return id; }
    public long getInternshipId() { return internshipId; }
    public int getScore() { return score; }
    public String getComments() { return comments; }

    public void setInternshipId(long internshipId) { this.internshipId = internshipId; }
    public void setScore(int score) { this.score = score; }
    public void setComments(String comments) { this.comments = comments; }

    @Override
    public String toString() { return "Internship#" + internshipId + " — Score: " + score + " — " + comments; }
}
