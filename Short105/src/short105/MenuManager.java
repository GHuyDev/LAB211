package short105;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class MenuManager {
    private Scanner scanner = new Scanner(System.in);
    private List<Teacher> teachers;
    private List<Student> students;

    public MenuManager(List<Teacher> teachers, List<Student> students) {
        this.teachers = teachers;
        this.students = students;
    }
    
    public void showMenu(){
        while(true){
            System.out.println("***Information Management ***");
            System.out.println("1.Teacher");
            System.out.println("2.Student");
            System.out.println("3.Person");
            System.out.println("4.Exit");
            System.out.print("You choose: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch(choice){
                case 1:
                    manageTeachers();
                    break;
                case 2:
                    manageStudents();
                    break;
                case 3:
                    managePerson();
                    break;
                case 4:
                    System.out.println("BYE AND SEE YOU NEXT TIME");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again");
                    
            }
        }
    }
    
    private void manageTeachers(){
        while(true){
            System.out.println("***Teacher Managementt ***");
            System.out.println("1. Input");
            System.out.println("2. Print");
            System.out.println("3. Exit");
            System.out.print("You choose: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            if (choice == 1) {
                Teacher t = new Teacher();
                t.inputAll();
                teachers.add(t);
            } else if (choice == 2) {
                if (teachers.isEmpty()) System.out.println("No teacher data available.");
                else {
                    teachers.sort(Comparator.comparingInt(Teacher::getYearInProfession).reversed());
                    int i = 1;
                    System.out.println("# - ID - Fullname - Phone - Year of Birth - Major - YearInProfession - Contract - Salary");
                    for (Teacher t : teachers) System.out.println(i++ + " - " + t);
                }
            } else if (choice == 3) break;
        }
    }
    
    private void manageStudents() {
        while (true) {
            System.out.println("\n*** Student Management ***");
            System.out.println("1. Input");
            System.out.println("2. Print");
            System.out.println("3. Exit");
            System.out.print("You choose: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                Student s = new Student();
                s.inputAll();
                students.add(s);
            } else if (choice == 2) {
                if (students.isEmpty()) {
                    System.out.println("No student data available.");
                } else {
                    students.sort(Comparator.comparingInt(Student::getYearOfAdmission));
                    int i = 1;
                    System.out.println("# - ID - Fullname - Phone - Year of Birth - Major - YearOfAdmission - EntranceScore");
                    for (Student s : students) System.out.println(i++ + " - " + s);
                }
            } else if (choice == 3) break;
        }
    }

    private void managePerson(){
       while (true) {
            System.out.println("\n*** Student Management ***");
            System.out.println("1. Search");
            System.out.println("2. Print All");
            System.out.println("3. Exit");
            System.out.print("You choose: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            if(choice == 1) searchPerson();
            else if(choice == 2) printAll();
            else if(choice == 3) break;
       } 
    }
    
    private void searchPerson() {
        System.out.print("Enter name to search: ");
        String name = scanner.nextLine();
        boolean found = false;

        for (Teacher t : teachers) {
            if (t.getFullName().equalsIgnoreCase(name)) {
                System.out.println("Teacher: " + t);
                found = true;
            }
        }

        for (Student s : students) {
            if (s.getFullName().equalsIgnoreCase(name)) {
                System.out.println("Student: " + s);
                found = true;
            }
        }

        if (!found) System.out.println("No person found with name: " + name);
    }

    private void printAll() {
        System.out.println("\n--- All Teachers ---");
        if (teachers.isEmpty()) System.out.println("No teacher data available.");
        else {
            int i = 1;
            for (Teacher t : teachers) System.out.println(i++ + " - " + t);
        }

        System.out.println("\n--- All Students ---");
        if (students.isEmpty()) System.out.println("No student data available.");
        else {
            int i = 1;
            for (Student s : students) System.out.println(i++ + " - " + s);
        }
    }
}
