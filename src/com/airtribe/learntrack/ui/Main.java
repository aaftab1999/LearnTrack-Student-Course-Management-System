package com.airtribe.learntrack.ui;

import java.util.Scanner;

import com.airtribe.learntrack.constants.MenuOptions;
import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.CourseRepository;
import com.airtribe.learntrack.repository.EnrollmentRepository;
import com.airtribe.learntrack.repository.StudentRepository;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.service.StudentService;
import com.airtribe.learntrack.util.IdGenerator;
import com.airtribe.learntrack.util.InputValidator;

public class Main {
    public static void main(String[] args) {

        MenuOptions.getMenu();

        Scanner sc = new Scanner(System.in);
        StudentRepository studentRepository = new StudentRepository();
        StudentService studentService = new StudentService(studentRepository);

        CourseRepository courseRepository = new CourseRepository();
        CourseService courseService = new CourseService(courseRepository);

        EnrollmentRepository enrollmentRepository = new EnrollmentRepository();
        EnrollmentService enrollmentService = new EnrollmentService(enrollmentRepository, studentService,
                courseService);

        while (true) {

            int input = InputValidator.readInt(sc,
                    "Choose options from the above \n(Please type desired menu number.)\nNo. : ");
            if (input == 1) {
                Student student = new Student(IdGenerator.getNextStudentId(),
                        InputValidator.readString(sc, "First name : "), InputValidator.readString(sc, "Last name : "),
                        InputValidator.readString(sc, "Email : ", true), InputValidator.readString(sc, "Batch : "),
                        true);
                studentService.addStudent(student);
                MenuOptions.getMenu();
            } else if (input == 2) {
                System.out.println(studentService.listStudents());
            } else if (input == 3) {
                try {
                    studentService.searchById(InputValidator.readInt(sc, "Student Id : "));
                } catch (EntityNotFoundException e) {
                    System.out.println(e.getMessage());
                }

            } else if (input == 4) {
                try {
                    studentService.deactivateStudent(InputValidator.readInt(sc, "Student Id : "));
                } catch (EntityNotFoundException e) {
                    System.out.println(e.getMessage());
                }

            } else if (input == 5) {
                courseService.addCourse(
                        new Course(IdGenerator.getNextCourseId(), InputValidator.readString(sc, "Course Name : "),
                                InputValidator.readString(sc, "Course Description : "),
                                InputValidator.readString(sc, "Duration in Weeks : "), true));

            } else if (input == 6) {
                System.out.println(courseService.listCourses());

            } else if (input == 7) {
                try {
                    courseService.activateCourseById(InputValidator.readInt(sc, "Activate Course by Id : "));
                } catch (EntityNotFoundException e) {
                    System.out.println(e.getMessage());
                }

            } else if (input == 8) {
                try {
                    courseService.deactivateCourseById(InputValidator.readInt(sc, "Deactivate Course by Id : "));
                } catch (EntityNotFoundException e) {
                    System.out.println(e.getMessage());
                }

            } else if (input == 9) {
                try {
                    enrollmentService.enroll(InputValidator.readInt(sc, "Student Id for enrollment : "),
                            InputValidator.readInt(sc, "Course Id for enrollment : "));
                } catch (EntityNotFoundException e) {
                    System.out.println(e.getMessage());
                }

            } else if (input == 10) {
                System.out.println(enrollmentService.viewEnrollments());
            } else if (input == 11) {
                try {
                    enrollmentService.completeEnrollment(InputValidator.readInt(sc, "Enrollment Id :"));
                } catch (EntityNotFoundException e) {
                    System.out.println(e.getMessage());
                }

            } else if (input == 12) {
                break;
            }

        }
        sc.close();
    }
}
