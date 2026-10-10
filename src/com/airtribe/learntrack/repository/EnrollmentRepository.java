package com.airtribe.learntrack.repository;

import java.util.ArrayList;
import java.util.List;

import com.airtribe.learntrack.entity.Enrollment;

public class EnrollmentRepository {
    private List<Enrollment> enrollments = new ArrayList<>();

    public void addEnrollment(Enrollment enrollment) {
        enrollments.add(enrollment);
    }

    public void addStudent(List<Enrollment> enrollments) {
        this.enrollments.addAll(enrollments);
    }

    public List<Enrollment> listEnrollments() {
        List<Enrollment> listEnrollments = new ArrayList<>();
        listEnrollments.addAll(enrollments);
        return listEnrollments;
    }
}
