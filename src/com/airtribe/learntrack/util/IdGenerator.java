package com.airtribe.learntrack.util;

public class IdGenerator {
    private static int studentIdCounter;
    private static int courseIdCounter;

    public static int getNextStudentId() {
        studentIdCounter = studentIdCounter + 1;
        return studentIdCounter;
    }

    public static int getNextCourseId() {
        courseIdCounter = courseIdCounter + 1;
        return courseIdCounter;
    }
}
