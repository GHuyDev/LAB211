package short83;

import java.util.Scanner;

public class Validator {
    private static final Scanner sc = new Scanner(System.in);

    public static int getInt(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number! Try again.");
            }
        }
    }

    public static int getMenuChoice(int min, int max) {
        while (true) {
            int choice = getInt("Enter your choice: ");
            if (choice >= min && choice <= max) {
                return choice;
            }
            System.out.println("Please choose between " + min + " and " + max);
        }
    }
}

