package com.intern.ui.models;

import java.util.concurrent.atomic.AtomicLong;

public class Task {
    private static final AtomicLong COUNTER = new AtomicLong(0);
    private final long id;
    private String description;
    private boolean completed;

    public Task() {
        this.id = COUNTER.incrementAndGet();
    }

    public Task(String description) {
        this.id = COUNTER.incrementAndGet();
        this.description = description;
        this.completed = false;
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return description + (completed ? " (Done)" : " (Pending)");
    }
}
