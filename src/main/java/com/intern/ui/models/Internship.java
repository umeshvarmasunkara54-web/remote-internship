package com.intern.ui.models;

public class Internship {
    private static long counter = 1;
    private final long id;
    private String title;
    private String mentor;
    private String duration;

    public Internship() {
        this.id = counter++;
    }

    public Internship(String title, String mentor, String duration) {
        this.id = counter++;
        this.title = title;
        this.mentor = mentor;
        this.duration = duration;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMentor() {
        return mentor;
    }

    public void setMentor(String mentor) {
        this.mentor = mentor;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return String.format("%s — %s (%s)", title, mentor, duration);
    }
}
