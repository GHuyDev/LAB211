/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package long23;

import java.util.Scanner;

public final class Validator {
    private Validator() {}

    public static String nonEmpty(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            if (!s.isEmpty()) return s;
            System.out.println("Không được để trống.");
        }
    }

    public static int positiveInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            try {
                int v = Integer.parseInt(s);
                if (v > 0) return v;
                System.out.println("Phải là số nguyên > 0.");
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên.");
            }
        }
    }

    public static double positiveDouble(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            try {
                double v = Double.parseDouble(s);
                if (v > 0) return v;
                System.out.println("Phải là số > 0.");
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số.");
            }
        }
    }

    public static boolean yesNo(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            if (s.equalsIgnoreCase("Y")) return true;
            if (s.equalsIgnoreCase("N")) return false;
            System.out.println("Chỉ nhập Y hoặc N.");
        }
    }

    /** Chọn 1..size, trả về index 0-based */
    public static int pickIndex(Scanner sc, String prompt, int size) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            try {
                int v = Integer.parseInt(s);
                if (v >= 1 && v <= size) return v - 1;
                System.out.printf("Chọn số từ 1 đến %d.%n", size);
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên.");
            }
        }
    }
}

