package com.airtribe.learntrack.constants;

public class MenuOptions {
    public static void getMenu() {
        System.out.println("""
                1. Add new student.
                2. List all students.
                3. Search student by Id.
                4. Deactivate student by Id.
                5. Add new Course.
                6. View all courses.
                7. Activate course.
                8. Deactivate course.
                9. Enroll a student in a course.
                10. View enrollments for a student.
                11. Mark enrollment as completed/cancelled.
                12. Close
                """);
    }
}
