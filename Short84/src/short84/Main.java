package short84;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("*** LARGE NUMBER CALCULATOR ***");
        System.out.print("Enter first large number: ");
        LargeNumber num1 = new LargeNumber(sc.nextLine());

        System.out.print("Enter second large number: ");
        LargeNumber num2 = new LargeNumber(sc.nextLine());

        LargeNumber sum = num1.add(num2);
        
        LargeNumber product = num1.multiply(num2);

        System.out.println("\n--- Result ---");
        System.out.println("Sum     : " + sum);
        System.out.println("Product : " + product);
    }
}