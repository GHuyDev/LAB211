package short4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Validator {

    private static Scanner sc = new Scanner(System.in);

    public static int getPositiveInteger(String msg) {
        int n = -1;
        while (true) {
            try {
                System.out.print(msg);
                n = sc.nextInt();
                if (n > 0) return n;
                else System.out.println("Please enter a positive integer.");
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.nextLine();
            }
        }
    }
}

