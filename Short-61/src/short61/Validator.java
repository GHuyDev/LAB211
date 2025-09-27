
package short61;

import java.util.Scanner;

public class Validator {
    private static final Scanner sc = new Scanner(System.in);

    public static double getDouble(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number, try again!");
            }
        }
    }
}