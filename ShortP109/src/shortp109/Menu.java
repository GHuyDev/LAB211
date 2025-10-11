package shortp109;

import java.util.Scanner;

public class Menu {
    private final Scanner sc;
    public Menu(Scanner sc) { this.sc = sc; }

    public String mainChoice() {
        System.out.println();
        System.out.println("*** Course Management ***");
        System.out.println("1. Add online course/ offline course");
        System.out.println("2. Update course");
        System.out.println("3. Delete course");
        System.out.println("4. Print all / online course / offline course");
        System.out.println("5. Search information base on course name");
        System.out.println("6. Exit");
        System.out.print("You choose: ");
        return sc.nextLine().trim();
    }
}
