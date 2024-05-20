package edu.wctc.Helper;

import java.util.Scanner;

public class Helper {

    public static int getInt(boolean restrictValues, int intMin, int intMax, String prompt, String errorMsg) {
        Scanner scanner = new Scanner(System.in);
        int userInt = 0;
        boolean repSuccess;
        do {
            System.out.print(prompt);
            String userString = scanner.nextLine();
            repSuccess = false;
            try {
                userInt = Integer.parseInt(userString);
                if (!restrictValues || (userInt >= intMin && userInt <= intMax)) {
                    repSuccess = true;
                }
            } catch (NumberFormatException e) {
                System.out.println(errorMsg);
            }
        } while (!repSuccess);
        return userInt;
    }

    public static double getDouble(boolean restrictValues, double doubleMin, double doubleMax, String prompt, String errorMsg) {
        Scanner scanner = new Scanner(System.in);
        double userDouble = 0.0;
        boolean repSuccess;
        do {
            System.out.print(prompt);
            String userString = scanner.nextLine();
            repSuccess = false;
            try {
                userDouble = Double.parseDouble(userString);
                if (!restrictValues || (userDouble >= doubleMin && userDouble <= doubleMax)) {
                    repSuccess = true;
                }
            } catch (NumberFormatException e) {
                System.out.println(errorMsg);
            }
        } while (!repSuccess);
        return userDouble;
    }

    public static char getChar(boolean restrictValues, char[] possibleAnswers, String prompt, String errorMsg) {
        Scanner scanner = new Scanner(System.in);
        char userChar = '\0';
        boolean repSuccess;
        do {
            System.out.print(prompt);
            String userString = scanner.nextLine();
            repSuccess = false;
            if (userString.length() == 1) {
                userChar = userString.charAt(0);
                if (!restrictValues) {
                    repSuccess = true;
                } else {
                    for (char i : possibleAnswers) {
                        if (userChar == i) {
                            repSuccess = true;
                            break;
                        }
                    }
                }
            }
            if (!repSuccess) {
                System.out.println(errorMsg);
            }
        } while (!repSuccess);
        return userChar;
    }

    public static String getString(String prompt, String errorMsg) {
        Scanner scanner = new Scanner(System.in);
        String userString = "";
        boolean repSuccess;
        do {
            System.out.print(prompt);
            userString = scanner.nextLine();
            repSuccess = !userString.isEmpty();
            if (!repSuccess) {
                System.out.println(errorMsg);
            }
        } while (!repSuccess);
        return userString;
    }

}
