package management.student;

import java.util.List;

public class TestStudent {

    public static void main(String[] args) {
        StudentManagement sm = new StudentManagement();

        while (true) {
            System.out.println();
            System.out.println("WELCOME TO STUDENT MANAGEMENT");
            System.out.println("1. Create");
            System.out.println("2. Find and Sort");
            System.out.println("3. Update/Delete");
            System.out.println("4. Report");
            System.out.println("5. Exit");
            int choice = Validator.getMenuChoice(1, 5);

            switch (choice) {
                case 1://tạo ít nhất 3 student, >3 thì hỏi Y/N cho từng student tiếp theo
                    do {
                        Student s = inputStudent();
                        if (!sm.addStudent(s)) {
                            System.out.println("This student record already exists (ID+Name+Semester+Course). Please re-enter.");
                            continue; // không tăng số lượng nếu trùng
                        }
                        System.out.println("Added: " + s);
                        if (sm.size() >= 3) {
                            // Hỏi tiếp tục khi đã >=3
                            if (!Validator.getYesNo("Do you want to continue (Y/N)? ")) {
                                break;
                            }
                        }
                    } while (true);
                    break;

                case 2: // Find & Sort by name
                    String key = Validator.getNonEmpty("Enter name (or part of name) to search: ");
                    List<Student> found = sm.findStudent(key);
                    List<Student> sorted = sm.sortStudent(found);
                    if (sorted.isEmpty()) {
                        System.out.println("No student matched.");
                    } else {
                        System.out.println("Search results (sorted by name):");
                        // Chỉ hiển thị: Name, Semester, Course theo đúng yêu cầu
                        for (Student st : sorted) {
                            System.out.println(st.getName() + " | " + st.getSemester() + " | " + st.getCourse());
                        }
                    }
                    break;

                case 3:

                case 4:
                    sm.reportStudent();
                    break;

                case 5:
                    System.out.println("Bye!");
                    return;
            }
        }
    }
}
