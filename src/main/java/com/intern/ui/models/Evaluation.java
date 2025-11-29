package com.intern.ui.models;

public class Evaluation {
    private static long counter = 1;
    private final long id;
    private long internshipId;
    private int score;
    private String comments;

    public Evaluation() { this.id = counter++; }

    public Evaluation(long internshipId, int score, String comments) {
        this.id = counter++;
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
