package com.airtribe.learntrack.entity;

public class Trainer extends Person {

    private String batch;
    private boolean active;

    public Trainer(int id, String firstName, String lastName, String email, String batch, boolean active) {
        super(id, firstName, lastName, email);
        this.batch = batch;
        this.active = active;
    }

    public Trainer(int id, String firstName, String lastName, String batch, boolean active) {
        super(id, firstName, lastName);
        this.batch = batch;
        this.active = active;
    }

    @Override
    public String getDisplayName() {
        return "Trainer - First Name : " + getFirstName() + " Last Name : " + getLastName();
    }

}
