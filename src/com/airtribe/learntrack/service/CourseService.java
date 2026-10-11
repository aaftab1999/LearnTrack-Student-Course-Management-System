package com.airtribe.learntrack.service;

import java.util.List;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.CourseRepository;

public class CourseService {
    private CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public void addCourse(Course course) {
        courseRepository.addCourse(course);
        System.out.println("SERVICE -> New Course added with Id : " + course.getId());
    }

    public void deactivateCourseById(int deactivateCourse) throws EntityNotFoundException {
        List<Course> courses = courseRepository.listCourses();

        for (Course course : courses) {
            if (course.getId() == deactivateCourse) {
                course.setActive(false);
                break;
            }
        }
        throw new EntityNotFoundException(
                "Deactivation failed - The requested Course Id doesn't exist :" + deactivateCourse);
    }

    public void activateCourseById(int activateCourse) throws EntityNotFoundException {
        List<Course> courses = courseRepository.listCourses();

        for (Course course : courses) {
            if (course.getId() == activateCourse) {
                course.setActive(true);
                break;
            }
        }
        throw new EntityNotFoundException(
                "Deactivation failed - The requested Course Id doesn't exist :" + activateCourse);
    }

    public void updateCourse(Course updateCourse) throws EntityNotFoundException {
        List<Course> courses = courseRepository.listCourses();

        for (Course course : courses) {
            if (course.getId() == updateCourse.getId()) {
                course.setCourseName(updateCourse.getCourseName());
                course.setDescription(updateCourse.getDescription());
                course.setActive(updateCourse.isActive());
                course.setDurationInWeeks(updateCourse.getDurationInWeeks());
                break;
            }
        }

        throw new EntityNotFoundException(
                "Update failed - The requested Course doesn't exist :" + updateCourse.toString());

    }

    public List<Course> listCourses() {
        List<Course> courses = courseRepository.listCourses();
        // List<Course> activeCourses = new ArrayList<>();

        // for (Course course : courses) {
        // if (course.isActive()) {
        // activeCourses.add(course);
        // }
        // }
        return courses;
    }

    public Course searchById(int id) throws EntityNotFoundException {
        List<Course> courses = courseRepository.listCourses();
        for (Course course : courses) {
            if (course.getId() == id) {
                System.out.println("SERVICE -> Course found by Id " + id);
                System.out.println("Course : " + course);
                return course;
            }
        }
        throw new EntityNotFoundException("Entity not found for Id :" + id);
    }
}
