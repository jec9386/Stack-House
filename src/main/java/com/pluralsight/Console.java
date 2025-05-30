package com.pluralsight;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class Console {
    private static Scanner scanner = new Scanner(System.in);

    // receive an int from user
    public static int promptForInt(String prompt) {
        boolean hasResult = false;//keep looping until valid result
        int result = -1;// filler #
        while (!hasResult) {
            try {
                System.out.print(prompt);
                result = scanner.nextInt();
                scanner.nextLine();
                hasResult = true;
            } catch (Exception e) {
                System.out.println("Invalid entry, please try again!");
                scanner.next();
            }
        }
        return result;
    }

    // receive String from user
    public static String promptForString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    // receive Double from user
    public static double promptForDouble(String prompt) {
        boolean hasResult = false;
        double result = -1;
        while (!hasResult) {
            try {
                System.out.print(prompt);
                result = scanner.nextDouble();
                scanner.nextLine();
                hasResult = true;
            } catch (Exception e) {
                System.out.println("Invalid entry, please try again!");
                scanner.next();
            }
        }
        return result;
    }

    // method for date prompt, validation, and conversion
    public static LocalDate promptForDate(String prompt) {
        LocalDate date = null;
        boolean valid = false;

        while (!valid) {
            System.out.print(prompt);
            String input = scanner.nextLine();

            try {
                date = LocalDate.parse(input);
                valid = true;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter the date in yyyy-MM-dd format.");
            }
        }
        return date;
    }

    // method for time prompt, validation, and conversion
    public static LocalTime promptForTime(String prompt) {
        LocalTime time = null;
        boolean valid = false;

        while (!valid) {
            System.out.print(prompt);
            String input = scanner.nextLine();

            try {
                time = LocalTime.parse(input);
                valid = true;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid time format. Please enter the time in HH:mm format (e.g., 14:30).");
            }
        }
        return time;
    }

    // NEW METHODS FOR DELI APP:

    // Prompt for menu choice with validation
    public static int promptForChoice(String prompt, int maxChoice) {
        int choice = -1;
        while (choice < 0 || choice > maxChoice) {
            choice = promptForInt(prompt);
            if (choice < 0 || choice > maxChoice) {
                System.out.println("Please enter a number between 0 and " + maxChoice);
            }
        }
        return choice;
    }

    // Prompt for yes/no answer
    public static boolean promptForYesNo(String prompt) {
        while (true) {
            String input = promptForString(prompt + " (y/n): ").trim().toLowerCase();
            if (input.equals("y") || input.equals("yes")) {
                return true;
            } else if (input.equals("n") || input.equals("no")) {
                return false;
            } else {
                System.out.println("Please enter 'y' for yes or 'n' for no.");
            }
        }
    }

    // Prompt for choice with option to skip (0 to skip)
    public static int promptForChoiceWithSkip(String prompt, int maxChoice) {
        int choice = -1;
        while (choice < 0 || choice > maxChoice) {
            choice = promptForInt(prompt);
            if (choice < 0 || choice > maxChoice) {
                System.out.println("Please enter a number between 0 and " + maxChoice + " (0 to skip)");
            }
        }
        return choice;
    }

}