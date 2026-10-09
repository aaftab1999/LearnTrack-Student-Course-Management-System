package com.airtribe.learntrack.service;

import java.util.List;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.StudentRepository;

public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void addStudent(Student student) {
        studentRepository.addStudent(student);
    }

    public void deactivateStudent(Student deactivateStudent) throws EntityNotFoundException {
        List<Student> students = studentRepository.listStudents();

        for (Student student : students) {
            if (student.getId() == deactivateStudent.getId()) {
                student.setActive(false);
                break;
            }
        }
        throw new EntityNotFoundException(
                "Deactivation failed - The requested Student doesn't exist :" + deactivateStudent.toString());
    }

    public void updateStudent(Student updateStudent) throws EntityNotFoundException {
        List<Student> students = studentRepository.listStudents();

        for (Student student : students) {
            if (student.getId() == updateStudent.getId()) {
                student.setFirstName(updateStudent.getFirstName());
                student.setLastName(updateStudent.getLastName());
                student.setActive(updateStudent.isActive());
                student.setEmail(updateStudent.getEmail());
                student.setBatch(updateStudent.getBatch());
                break;
            }
        }

        throw new EntityNotFoundException(
                "Update failed - The requested Student doesn't exist :" + updateStudent.toString());

    }

    public List<Student> listStudents() {
        List<Student> students = studentRepository.listStudents();
        // List<Student> activeStudents = new ArrayList<>();

        // for (Student student : students) {
        // if (student.isActive()) {
        // activeStudents.add(student);
        // }
        // }
        return students;
    }

    public Student searchById(int id) throws EntityNotFoundException {
        List<Student> students = studentRepository.listStudents();
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        throw new EntityNotFoundException("Entity not found for Id -" + id);
    }
}
