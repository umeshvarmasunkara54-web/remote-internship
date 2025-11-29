package com.intern.ui.models;

public class Mentor {
    private static long counter = 1;
    private final long id;
    private String name;
    private String email;

    public Mentor() { this.id = counter++; }

    public Mentor(String name, String email) {
        this.id = counter++;
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
