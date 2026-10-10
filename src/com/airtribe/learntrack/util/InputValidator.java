package com.airtribe.learntrack.util;

import java.util.Scanner;

public class InputValidator {

    public static int readInt(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Error: Expected a valid integer. Please try again.");
            }
        }
    }

    public static String readString(Scanner scanner, String message) {
        return readString(scanner, message, false);
    }

    public static String readString(Scanner scanner, String message, boolean optional) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            } else if (optional) {
                return "";

            }
            System.out.println("Error: input cannot be empty. Please try again.");
        }

    }

}
