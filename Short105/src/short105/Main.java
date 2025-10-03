package short105;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Teacher> teachers = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        
        MenuManager menu = new MenuManager(teachers, students);
        menu.showMenu();
    }
}
