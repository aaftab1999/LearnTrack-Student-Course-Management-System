package com.airtribe.learntrack.service;

import java.util.List;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.CourseRepository;

public class CourseService {
    private CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public void addCourse(Course course) {
        courseRepository.addCourse(course);
    }

    public void deactivateCourse(Course deactivateCourse) throws EntityNotFoundException {
        List<Course> courses = courseRepository.listCourses();

        for (Course course : courses) {
            if (course.getId() == deactivateCourse.getId()) {
                course.setActive(false);
                break;
            }
        }
        throw new EntityNotFoundException(
                "Deactivation failed - The requested Course doesn't exist :" + deactivateCourse.toString());
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
}
