package short01;

import java.util.Scanner;

public class Validator {
    
    public static int getPositiveIntegerInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        int input = -1;
        
        while (input <= 0) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                if (input <= 0) {
                    System.out.println("Please enter a positive integer.");
                }
            } else {
                System.out.println("Invalid input! Please enter a valid positive integer.");
                scanner.next();
            }
        }
        return input;
    }
}
