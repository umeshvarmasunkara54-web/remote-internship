package com.intern.ui.models;

import java.util.concurrent.atomic.AtomicLong;

public class Internship {
    private static final AtomicLong COUNTER = new AtomicLong(0);
    private final long id;
    private String title;
    private String mentor;
    private String duration;

    public Internship() {
        this.id = COUNTER.incrementAndGet();
    }

    public Internship(String title, String mentor, String duration) {
        this.id = COUNTER.incrementAndGet();
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
