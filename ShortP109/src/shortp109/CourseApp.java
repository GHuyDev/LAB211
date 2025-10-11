package shortp109;

import java.time.LocalDate;
import java.util.*;

public class CourseApp {
    private final Scanner sc = new Scanner(System.in);
    private final Menu menu = new Menu(sc);
    private final CourseRepository repo = new CourseRepository();

    public static void main(String[] args) { new CourseApp().run(); }

    private void run() {
        while (true) {
            String choice = menu.mainChoice();
            switch (choice) {
                case "1" -> addCourse();
                case "2" -> updateCourse();
                case "3" -> deleteCourse();
                case "4" -> printCourses();
                case "5" -> searchByName();
                case "6" -> { System.out.println("BYE AND SEE YOU NEXT TIME"); return; }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    // =============== ADD ===============
    private void addCourse() {
        System.out.println();
        System.out.println("*** Add new course ***");
        while (true) {
            System.out.print("Online (O) or Offline (F): ");
            String type = sc.nextLine().trim();
            if (type.equalsIgnoreCase("O") || type.equalsIgnoreCase("Online")) {
                createOnline();
                return;
            } else if (type.equalsIgnoreCase("F") || type.equalsIgnoreCase("Offline")) {
                createOffline();
                return;
            } else {
                System.out.println("Data input is  invalid");
            }
        }
    }

    private void createOnline() {
        System.out.println("Create new online course");
        OnlineCourse c = new OnlineCourse();

        // Base: ID
        String id;
        while (true) {
            System.out.print("Course ID: ");
            id = sc.nextLine().trim();
            if (!Validator.notEmpty(id)) { System.out.println("Data input is  invalid"); continue; }
            if (repo.existsId(id)) { System.out.println("Data input is  invalid, ID must be unique"); continue; }
            c.setCourseId(id);
            break;
        }

        // Base: Name
        while (true) {
            System.out.print("Course name: ");
            String name = sc.nextLine().trim();
            if (!Validator.notEmpty(name)) { System.out.println("Data input is  invalid"); continue; }
            if (repo.existsName(name)) { System.out.println("Data input is  invalid, course name must be unique"); continue; }
            c.setCourseName(name);
            break;
        }

        // Base: Credits
        while (true) {
            System.out.print("Credits: ");
            String s = sc.nextLine();
            Integer cr = Validator.parsePositiveInt(s);
            if (cr == null) { System.out.println("Data input is  invalid"); continue; }
            c.setCredits(cr);
            break;
        }

        // Online: Platform (not empty)
        while (true) {
            System.out.print("Platform: ");
            String p = sc.nextLine().trim();
            if (!Validator.notEmpty(p)) { System.out.println("Data input is  invalid"); continue; }
            c.setPlatform(p);
            break;
        }

        // Online: Instructors 
        System.out.print("Instructors: ");
        c.setInstructors(sc.nextLine().trim());

        // Online: Note (not empty)
        while (true) {
            System.out.print("Note: ");
            String n = sc.nextLine().trim();
            if (!Validator.notEmpty(n)) { System.out.println("Data input is  invalid"); continue; }
            c.setNote(n);
            break;
        }

        repo.put(c);
    }

    private void createOffline() {
        System.out.println("Create new offline course");
        OfflineCourse c = new OfflineCourse();

        // Base: ID
        while (true) {
            System.out.print("Course ID: ");
            String id = sc.nextLine().trim();
            if (!Validator.notEmpty(id)) { System.out.println("Data input is  invalid"); continue; }
            if (repo.existsId(id)) { System.out.println("Data input is  invalid, ID must be unique"); continue; }
            c.setCourseId(id);
            break;
        }

        // Base: Name
        while (true) {
            System.out.print("Course name: ");
            String name = sc.nextLine().trim();
            if (!Validator.notEmpty(name)) { System.out.println("Data input is  invalid"); continue; }
            if (repo.existsName(name)) { System.out.println("Data input is  invalid, course name must be unique"); continue; }
            c.setCourseName(name);
            break;
        }

        // Base: Credits
        while (true) {
            System.out.print("Credits: ");
            String s = sc.nextLine();
            Integer cr = Validator.parsePositiveInt(s);
            if (cr == null) { System.out.println("Data input is  invalid"); continue; }
            c.setCredits(cr);
            break;
        }

        // Offline: Begin (future)
        LocalDate begin;
        while (true) {
            System.out.print("Begin: ");
            String s = sc.nextLine();
            begin = Validator.parseDate(s);
            if (begin == null || !Validator.isFuture(begin)) {
                System.out.println("Data input is  invalid");
                continue;
            }
            c.setBegin(begin);
            break;
        }

        // Offline: End
        while (true) {
            System.out.print("End: ");
            String s = sc.nextLine();
            LocalDate end = Validator.parseDate(s);
            if (end == null || !Validator.isFuture(end) || !end.isAfter(begin)) {
                System.out.println("Data input is  invalid, end must be after begin");
                continue;
            }
            c.setEnd(end);
            break;
        }

        // Offline: Campus (not empty)
        while (true) {
            System.out.print("Campus: ");
            String campus = sc.nextLine().trim();
            if (!Validator.notEmpty(campus)) { System.out.println("Data input is  invalid"); continue; }
            c.setCampus(campus);
            break;
        }

        repo.put(c);
    }

    // update
    private void updateCourse() {
        System.out.println();
        System.out.println("*** Update course ***");

        Course c = findByIdFlow();
        if (c == null) return;

        printDetail(c);
        System.out.println("*** Updating ***");
        System.out.println("Note: Enter empty if you don't want to change it.");

        // ID (unique) — allow empty to skip
        System.out.print("Course ID: ");
        String newId = sc.nextLine().trim();
        if (!newId.isEmpty()) {
            if (!Validator.notEmpty(newId)) { System.out.println("Data input is  invalid"); return; }
            if (!newId.equalsIgnoreCase(c.getCourseId()) && repo.existsId(newId)) {
                System.out.println("Data input is  invalid, ID must be unique"); return;
            }
            // move key in repo
            repo.remove(c.getCourseId());
            c.setCourseId(newId);
            repo.put(c);
        }

        // Name (unique)
        System.out.print("Course name: ");
        String newName = sc.nextLine().trim();
        if (!newName.isEmpty()) {
            if (!Validator.notEmpty(newName)) { System.out.println("Data input is  invalid"); return; }
            if (!newName.equalsIgnoreCase(c.getCourseName()) && repo.existsName(newName)) {
                System.out.println("Data input is  invalid, course name must be unique"); return;
            }
            c.setCourseName(newName);
        }

        // Credits (>0)
        System.out.print("Credits: ");
        String creditsStr = sc.nextLine().trim();
        if (!creditsStr.isEmpty()) {
            Integer cr = Validator.parsePositiveInt(creditsStr);
            if (cr == null) { System.out.println("Data input is  invalid"); return; }
            c.setCredits(cr);
        }

        if (c instanceof OnlineCourse oc) {
            System.out.print("Platform: ");
            String p = sc.nextLine().trim();
            if (!p.isEmpty()) {
                if (!Validator.notEmpty(p)) { System.out.println("Data input is  invalid"); return; }
                oc.setPlatform(p);
            }
            System.out.print("Instructors: ");
            String ins = sc.nextLine().trim();
            if (!ins.isEmpty()) oc.setInstructors(ins);

            System.out.print("Note: ");
            String n = sc.nextLine().trim();
            if (!n.isEmpty()) {
                if (!Validator.notEmpty(n)) { System.out.println("Data input is  invalid"); return; }
                oc.setNote(n);
            }
        } else if (c instanceof OfflineCourse of) {
            // Begin
            System.out.print("Begin: ");
            String b = sc.nextLine().trim();
            LocalDate newBegin = b.isEmpty() ? of.getBegin() : Validator.parseDate(b);
            if (!b.isEmpty() && (newBegin == null || !Validator.isFuture(newBegin))) {
                System.out.println("Data input is  invalid"); return;
            }

            // End
            System.out.print("End: ");
            String e = sc.nextLine().trim();
            LocalDate newEnd = e.isEmpty() ? of.getEnd() : Validator.parseDate(e);
            if (!e.isEmpty() && (newEnd == null || !Validator.isFuture(newEnd) || !newEnd.isAfter(newBegin))) {
                System.out.println("Data input is  invalid, end must be after begin"); return;
            }

            if (!b.isEmpty()) of.setBegin(newBegin);
            if (!e.isEmpty()) of.setEnd(newEnd);

            // Campus
            System.out.print("Campus: ");
            String campus = sc.nextLine().trim();
            if (!campus.isEmpty()) {
                if (!Validator.notEmpty(campus)) { System.out.println("Data input is  invalid"); return; }
                of.setCampus(campus);
            }
        }

        System.out.println("Updated successfully");
    }

    // delete
    private void deleteCourse() {
        System.out.println();
        System.out.println("*** Delete course ***");

        Course c = findByIdFlow();
        if (c == null) return;

        repo.remove(c.getCourseId());
        System.out.println("Information deleted successfully.");
    }

    // print
    private void printCourses() {
        System.out.println();
        System.out.println("*** Print course ***");
        System.out.print("Do you want to print all (A), online course (O) or offline course (F): ");
        String opt = sc.nextLine().trim();

        if (opt.equalsIgnoreCase("A")) {
            if (repo.isEmpty()) { System.out.println("No information to view"); return; }
            System.out.println("Course ID-Course name-Credits");
            for (Course c : repo.all()) System.out.println(c.baseLine());
        } else if (opt.equalsIgnoreCase("O")) {
            List<OnlineCourse> list = repo.allOnline();
            if (list.isEmpty()) { System.out.println("No information to view"); return; }
            System.out.println("Course ID-Course name-Credits-Platform-Instructors-Note");
            for (OnlineCourse oc : list) System.out.println(oc.line());
        } else if (opt.equalsIgnoreCase("F")) {
            List<OfflineCourse> list = repo.allOffline();
            if (list.isEmpty()) { System.out.println("No information to view"); return; }
            System.out.println("Course ID-Course name-Credits-Begin-End-Campus");
            for (OfflineCourse of : list) System.out.println(of.line());
        } else {
            System.out.println("Data input is  invalid");
        }
    }

    // SEARCH (by course name, case-insensitive contains)
    private void searchByName() {
        System.out.println();
        System.out.println("*** Searching ***");
        while (true) {
            System.out.print("Course name: ");
            String kw = sc.nextLine().trim();
            if (!Validator.notEmpty(kw)) { System.out.println("Data input is  invalid"); continue; }

            List<Course> found = repo.findByNameContains(kw);
            if (found.isEmpty()) {
                System.out.print("No data found, do you want to find again? (Y/N): ");
                String ans = sc.nextLine().trim();
                if (ans.equalsIgnoreCase("Y")) continue;
                else return;
            }
            for (Course c : found) {
                printDetail(c);
            }
            return;
        }
    }

    //find by ID with retry (for Update/Delete)
    private Course findByIdFlow() {
        while (true) {
            System.out.print("Course ID: ");
            String id = sc.nextLine().trim();
            Course c = repo.get(id);
            if (c == null) {
                System.out.print("No data found, do you want to find again? (Y/N): ");
                String ans = sc.nextLine().trim();
                if (ans.equalsIgnoreCase("Y")) continue;
                return null;
            }
            return c;
        }
    }

    private void printDetail(Course c) {
        System.out.println("*** Search results ***");
        System.out.println("Course ID: " + c.getCourseId());
        System.out.println("Course name: " + c.getCourseName());
        System.out.println("Credits: " + c.getCredits());
        if (c instanceof OnlineCourse oc) {
            System.out.println("Platform: " + oc.getPlatform());
            System.out.println("Instructors: " + oc.getInstructors());
            System.out.println("Note: " + oc.getNote());
        } else if (c instanceof OfflineCourse of) {
            System.out.println("Begin: " + Validator.DATE_FMT.format(of.getBegin()));
            System.out.println("End: " + Validator.DATE_FMT.format(of.getEnd()));
            System.out.println("Campus: " + of.getCampus());
        }
    }
}
