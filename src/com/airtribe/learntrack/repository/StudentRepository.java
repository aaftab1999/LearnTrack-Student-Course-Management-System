package com.airtribe.learntrack.repository;

import java.util.ArrayList;
import java.util.List;

import com.airtribe.learntrack.entity.Student;

public class StudentRepository {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addStudent(List<Student> students) {
        this.students.addAll(students);
    }

    public List<Student> listStudents() {
        List<Student> listStudents = new ArrayList<>();
        listStudents.addAll(students);
        return listStudents;
    }
}
