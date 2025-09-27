package short06;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Validator {
    private static Scanner sc = new Scanner(System.in);
    
    public static int getPositiveIntegerInput(String message) {
        int number = -1;
        while (number <= 0) {
            try {
                System.out.print(message);
                number = sc.nextInt();
                if (number <= 0) {
                    System.out.println("Please enter a positive integer greater than 0.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.next(); // clear buffer
            }
        }
        return number;
    }

    public static int getIntegerInput(String message) {
        while (true) {
            try {
                System.out.print(message);
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.next(); // clear buffer
            }
        }
    }
}
