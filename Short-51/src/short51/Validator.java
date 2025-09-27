package short51;

import java.util.Scanner;

public class Validator {
    private static final Scanner sc = new Scanner(System.in);

    // kiểm tra số
    public static Double getDouble(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                String input = sc.nextLine().trim();
                return Double.parseDouble(input);
            } catch (NumberFormatException | NullPointerException e) {
                System.out.println("Invalid number, try again.");
            }
        }
    }

    // kiểm tra toán tử
    public static String getOperator(String msg) {
        while (true) {
            System.out.print(msg);
            String op = sc.nextLine().trim();
            if (op.matches("[+\\-*/^=]")) {
                return op;
            } else {
                System.out.println("Please input (+, -, *, /, ^, =)");
            }
        }
    }
    
    //kiểm tra số nguyên
        public int getInt(String msg, int min, int max) {
        while (true) {
            try {
                System.out.print(msg);
                int val = Integer.parseInt(sc.nextLine().trim());
                if (val >= min && val <= max) {
                    return val;
                }
                System.out.println("Please enter a number between " + min + " and " + max);
            } catch (NumberFormatException e) {
                System.out.println("Invalid integer, try again.");
            }
        }
    }
    // kiểm tra nhập số, với toán tử chia thì không cho phép nhập 0
    public static double getDoubleForDivide(String msg) {
        while (true) {
            double num = getDouble(msg);
            if (num == 0) {
                System.out.println("Cannot divide by zero! Enter again.");
            } else {
                return num;
            }
        }
    }
}
