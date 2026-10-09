package com.airtribe.learntrack.entity;

/**
 * Student
 */
public class Student extends Person {

    private String batch;
    private boolean active;

    public Student(int id, String firstName, String lastName, String email, String batch, boolean active) {
        super(id, firstName, lastName, email);
        this.batch = batch;
        this.active = active;
    }

    public Student(int id, String firstName, String lastName, String batch, boolean active) {
        super(id, firstName, lastName);
        this.batch = batch;
        this.active = active;
    }

    @Override
    public String getDisplayName() {
        return "Student - First Name : " + getFirstName() + " Last Name : " + getLastName();
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Student [batch=" + batch + ", active=" + active + ", Id=" + getId() + ", Batch=" + getBatch()
                + ", First Name=" + getFirstName() + ", is active=" + isActive() + ", last name="
                + getLastName() + ", email=" + getEmail() + "]";
    }

}