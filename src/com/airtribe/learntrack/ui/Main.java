package com.airtribe.learntrack.ui;

import java.util.Scanner;

import com.airtribe.learntrack.constants.MenuOptions;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.StudentRepository;
import com.airtribe.learntrack.service.StudentService;
import com.airtribe.learntrack.util.IdGenerator;
import com.airtribe.learntrack.util.InputValidator;

public class Main {
    public static void main(String[] args) {

        MenuOptions.getMenu();

        Scanner sc = new Scanner(System.in);
        StudentRepository studentRepository = new StudentRepository();

        while (true) {

            int input = InputValidator.readInt(sc,
                    "Choose options from the above \n(Please type desired serial number.)\nNo. : ");
            if (input == 1) {
                Student student = new Student(IdGenerator.getNextStudentId(),
                        InputValidator.readString(sc, "First name : "), InputValidator.readString(sc, "Last name : "),
                        InputValidator.readString(sc, "Email : ", true), InputValidator.readString(sc, "Batch : "), true);
                studentRepository.addStudent(student);
            } else if (input == 2) {
                System.out.println(studentRepository.listStudents());
            } else if (input == 12) {
                break;
            }

        }
        sc.close();
    }
}
