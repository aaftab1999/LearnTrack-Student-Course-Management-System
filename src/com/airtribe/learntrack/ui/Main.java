package com.airtribe.learntrack.ui;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.StudentRepository;
import com.airtribe.learntrack.service.StudentService;
import com.airtribe.learntrack.util.IdGenerator;

public class Main {
    public static void main(String[] args) {
        StudentRepository repository = new StudentRepository();
        StudentService service = new StudentService(repository);
        Student student = new Student(IdGenerator.getNextStudentId(), "Aftab", "Mandal", "B23", true);
        Student student2 = new Student(IdGenerator.getNextStudentId(), "Vijay", "Salgaonkar", "B23", true);
        service.addStudent(student);
        service.addStudent(student2);
        student.setBatch("B24");
        try {
            service.updateStudent(student);
        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(service.listStudents());
        try {
            System.out.println(service.searchById(3));
        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();
        System.out.println();
        try {
            service.deactivateStudent(student2);
        } catch (EntityNotFoundException e) {
            System.err.println(e.getMessage());
        }

        System.out.println(service.listStudents());

    }
}
