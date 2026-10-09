package com.airtribe.learntrack.repository;

import java.util.ArrayList;
import java.util.List;

import com.airtribe.learntrack.entity.Course;

public class CourseRepository {
    private List<Course> courses = new ArrayList<>();

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void addStudent(List<Course> courses) {
        this.courses.addAll(courses);
    }

    public List<Course> listCourses() {
        List<Course> listCourses = new ArrayList<>();
        listCourses.addAll(courses);
        return listCourses;
    }
}
