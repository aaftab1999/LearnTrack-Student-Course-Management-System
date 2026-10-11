package com.airtribe.learntrack.service;

import java.time.LocalDate;
import java.util.List;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.enums.EnrollmentStatus;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.EnrollmentRepository;
import com.airtribe.learntrack.util.IdGenerator;

public class EnrollmentService {
    private EnrollmentRepository enrollmentRepository;
    private StudentService studentService;
    private CourseService courseService;

    public EnrollmentService(EnrollmentRepository enrollmentRepository, StudentService studentService,
            CourseService courseService) {
        this.enrollmentRepository = enrollmentRepository;
        this.courseService = courseService;
        this.studentService = studentService;
    }

    public void enroll(int studentId, int courseId) throws EntityNotFoundException {
        Enrollment enrollment = new Enrollment(IdGenerator.getNextEnrollmentId(), studentId, courseId,
                LocalDate.now(), EnrollmentStatus.ACTIVE);

        // Will throw exception If student or course not found
        studentService.searchById(studentId);
        courseService.searchById(courseId);
        enrollmentRepository.addEnrollment(enrollment);

        System.out.println(
                "SERVICE -> Enrollment for student with Id : " + studentId + " done in course with Id : " + courseId);

    }

    public List<Enrollment> viewEnrollments() {
        return enrollmentRepository.listEnrollments();
    }

    public void completeEnrollment(int enrollmentCompleted) throws EntityNotFoundException {

        List<Enrollment> enrollments = enrollmentRepository.listEnrollments();
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getId() == enrollmentCompleted) {
                enrollment.setEnrollmentStatus(EnrollmentStatus.COMPLETED);
                System.out.println("Enrollment with Id : " + enrollmentCompleted + " marked as COMPLETED");
                return;
            }
        }
        throw new EntityNotFoundException("Enrollment Entity not found for Id :" + enrollmentCompleted);
    }

    public void cancelledEnrollment(int enrollmentCancelled) throws EntityNotFoundException {

        List<Enrollment> enrollments = enrollmentRepository.listEnrollments();
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getId() == enrollmentCancelled) {
                enrollment.setEnrollmentStatus(EnrollmentStatus.CANCELLED);
                System.out.println("Enrollment with Id : " + enrollmentCancelled + " marked as CANCELLED");
                return;
            }
        }
        throw new EntityNotFoundException("Enrollment Entity not found for Id :" + enrollmentCancelled);
    }

}
