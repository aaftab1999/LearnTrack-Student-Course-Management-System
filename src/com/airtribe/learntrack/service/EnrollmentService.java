package com.airtribe.learntrack.service;

import java.time.LocalDate;
import java.util.List;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.enums.EnrollmentStatus;
import com.airtribe.learntrack.repository.EnrollmentRepository;
import com.airtribe.learntrack.util.IdGenerator;

public class EnrollmentService {
    private EnrollmentRepository enrollmentRepository;

    public EnrollmentService(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    public void enroll(Student student, Course course) {
        Enrollment enrollment = new Enrollment(IdGenerator.getNextEnrollmentId(), student.getId(), course.getId(),
                LocalDate.now(), EnrollmentStatus.ACTIVE);

        enrollmentRepository.addEnrollment(enrollment);

    }

    public List<Enrollment> viewEnrollments() {
        return enrollmentRepository.listEnrollments();
    }

    public void completeEnrollment(Enrollment enrollmentCompleted) {

        List<Enrollment> enrollments = enrollmentRepository.listEnrollments();
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getId() == enrollmentCompleted.getId()) {
                enrollment.setEnrollmentStatus(EnrollmentStatus.COMPLETED);
                break;
            }
        }
    }

    public void cancelledEnrollment(Enrollment enrollmentCancelled) {

        List<Enrollment> enrollments = enrollmentRepository.listEnrollments();
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getId() == enrollmentCancelled.getId()) {
                enrollment.setEnrollmentStatus(EnrollmentStatus.CANCELLED);
                break;
            }
        }
    }

}
