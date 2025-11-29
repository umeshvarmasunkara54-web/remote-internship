package com.intern.ui.models;

import java.util.concurrent.atomic.AtomicLong;

public class Student {
    private static final AtomicLong COUNTER = new AtomicLong(0);
    private final long id;
    private String name;
    private String email;

    public Student() { this.id = COUNTER.incrementAndGet(); }

    public Student(String name, String email) {
        this.id = COUNTER.incrementAndGet();
        this.name = name;
        this.email = email;
    }

    public long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }

    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() { return name + " <" + email + ">"; }
}
