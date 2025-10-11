package com.mycompany.shortp107;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class ReservationApp {

    private final ReservationRepository repo = new ReservationRepository();
    private final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        new ReservationApp().run();
    }

    private void run() {
        while (true) {
            System.out.println();
            System.out.println("*** Reservation Management ***");
            System.out.println("1. Create new reservation");
            System.out.println("2. Update reservation");
            System.out.println("3. Delete reservation");
            System.out.println("4. Print Flight Information");
            System.out.println("5. Print all");
            System.out.println("6. Exit");
            System.out.print("You choose: ");
            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1" ->
                    createReservation();
                case "2" ->
                    updateReservation();
                case "3" ->
                    deleteReservation();
                case "4" ->
                    printFlightInfo();
                case "5" ->
                    printAll();
                case "6" -> {
                    System.out.println("BYE AND SEE YOU NEXT TIME");
                    return;
                }
                default ->
                    System.out.println("Invalid choice.");
            }
        }
    }

    // =============== CREATE ===============
    private void createReservation() {
        System.out.println();
        System.out.println("*** Create new reservation ***");

        String id = promptIdUnique();
        String name = promptName();
        String phone = promptPhone();
        String room = promptRoom();
        LocalDate bookingDate = promptBookingDate();

        FlightInformation fi = null;
        boolean needPickup = promptYesNo("Need airport pick up? (Y/N): ");
        if (needPickup) {
            String flight = promptNonEmpty("Flight: ");
            String seat = promptNonEmpty("Seat: ");
            LocalDateTime pickup = promptPickupTime(bookingDate);
            fi = new FlightInformation(flight, seat, pickup);
        }

        Reservation r = new Reservation(id, name, phone, room, bookingDate, fi);
        repo.put(r);
        System.out.println("Information saved successfully.");
    }

    // =============== UPDATE ===============
    private void updateReservation() {
        System.out.println();
        System.out.println("*** Update reservation ***");

        String id = findExistingIdFlow();
        if (id == null) {
            return;
        }

        Reservation r = repo.get(id);
        printOneLine(r);
        System.out.println("If you do not want to change the information, just press enter to skip.");

        // Name
        System.out.print("Name: ");
        String name = sc.nextLine();
        if (!name.isBlank()) {
            if (!Validator.isValidName(name)) {
                error();
                return;
            }
            r.setCustomerName(name.trim());
        }

        // Phone
        System.out.print("Phone: ");
        String phone = sc.nextLine();
        if (!phone.isBlank()) {
            if (!Validator.isDigits(phone, 10)) {
                error();
                return;
            }
            r.setPhoneNumber(phone.trim());
        }

        // Room
        System.out.print("RoomNumbers: ");
        String room = sc.nextLine();
        if (!room.isBlank()) {
            if (!Validator.isDigits(room, 4)) {
                error();
                return;
            }
            r.setRoomNumber(room.trim());
        }

        // BookingDate
        System.out.print("BookingDate: ");
        String bdStr = sc.nextLine();
        if (!bdStr.isBlank()) {
            LocalDate bd = Validator.parseFutureDate(bdStr);
            if (bd == null) {
                error();
                return;
            }
            r.setBookingDate(bd);
            // Nếu có flight info, kiểm tra lại hợp lệ với bookingDate mới
            if (r.getFlightInformation() != null
                    && !Validator.isPickupValid(r.getFlightInformation().getTimePickUp(), bd)) {
                r.setFlightInformation(null);
            }
        }

        // Airport pickup?
        System.out.print("Need airport pick up?");
        String yn = sc.nextLine().trim();
        if (!yn.isBlank()) {
            if (Validator.isYes(yn)) {
                String flight = promptNonEmpty("Flight: ");
                String seat = promptNonEmpty("Seat: ");
                LocalDateTime pickup = promptPickupTime(r.getBookingDate());
                r.setFlightInformation(new FlightInformation(flight, seat, pickup));
            } else if (Validator.isNo(yn)) {
                r.setFlightInformation(null);
            } else {
                error();
                return;
            }
        }

        printOneLine(r);
        System.out.println("Information saved successfully.");
    }

    // =============== DELETE ===============
    private void deleteReservation() {
        System.out.println();
        System.out.println("*** Delete reservation ***");

        String id = findExistingIdFlow();
        if (id == null) {
            return;
        }

        Reservation r = repo.get(id);
        printOneLine(r);

        if (promptYesNo("Are you sure you want to delete this information? (Y/N): ")) {
            repo.remove(id);
            System.out.println("Information deleted successfully.");
        }
    }

    // =============== PRINTS ===============
    private void printAll() {
        System.out.println();
        System.out.println("*** Reservation Information ***");
        if (repo.isEmpty()) {
            System.out.println("No information to view");
            return;
        }
        printHeaderAll();
        for (Reservation r : repo.values()) {
            printOneLine(r);
        }
    }

    private void printFlightInfo() {
        System.out.println();
        System.out.println("*** Flight Information ***");

        List<Reservation> list = new ArrayList<>();
        for (Reservation r : repo.values()) {
            if (r.getFlightInformation() != null) {
                list.add(r);
            }
        }
        if (list.isEmpty()) {
            System.out.println("No information to view");
            return;
        }

        list.sort(Comparator.comparing(o -> o.getFlightInformation().getTimePickUp()));

        System.out.println("ID - Name - Phone - Flight - Seat - TimePickUp");
        for (Reservation r : list) {
            FlightInformation fi = r.getFlightInformation();
            System.out.printf("%s - %s - %s - %s - %s - %s%n",
                    r.getBookingID(),
                    r.getCustomerName(),
                    r.getPhoneNumber(),
                    fi.getFlightNumber(),
                    fi.getSeatNumber(),
                    Validator.DT_FMT.format(fi.getTimePickUp()));
        }
    }

    // =============== FIND FLOW ===============
    private String findExistingIdFlow() {
        while (true) {
            System.out.print("ID: ");
            String id = sc.nextLine().trim();
            if (!repo.existsId(id)) {
                System.out.println("No information found");
                if (!promptYesNo("You want to find again? (Y/N): ")) {
                    return null;
                }
            } else {
                return id;
            }
        }
    }

    // =============== PROMPTS (dùng Validator) ===============
    private String promptIdUnique() {
        while (true) {
            System.out.print("ID: ");
            String id = sc.nextLine().trim();
            if (!Validator.isDigits(id, 6) || repo.existsId(id)) {
                error();
                continue;
            }
            return id;
        }
    }

    private String promptName() {
        while (true) {
            System.out.print("Name: ");
            String name = sc.nextLine().trim();
            if (Validator.isValidName(name)) {
                return name;
            }
            error();
        }
    }

    private String promptPhone() {
        while (true) {
            System.out.print("Phone: ");
            String phone = sc.nextLine().trim();
            if (Validator.isDigits(phone, 10)) {
                return phone;
            }
            error();
        }
    }

    private String promptRoom() {
        while (true) {
            System.out.print("RoomNumbers: ");
            String raw = sc.nextLine().trim();
            String normalized = normalizeRoom(raw);
            if (normalized != null) {
                return normalized;  // ví dụ "2" -> "0002"
            }
            error();
        }
    }
         // Nhận 1–4 chữ số và pad về 4 chữ số (trả null nếu không hợp lệ)//
    private String normalizeRoom(String s) {
        if (s == null) {
            return null;
        }
        String digits = s.replaceAll("\\D", "");   // loại bỏ ký tự không phải số
        if (digits.length() >= 1 && digits.length() <= 4) {
            return String.format("%4s", digits).replace(' ', '0'); // pad trái bằng '0'
        }
        return null;
    }

    private LocalDate promptBookingDate() {
        while (true) {
            System.out.print("BookingDate: ");
            String s = sc.nextLine().trim();
            LocalDate d = Validator.parseFutureDate(s);
            if (d != null) {
                return d;
            }
            error();
        }
    }

    private boolean promptYesNo(String label) {
        while (true) {
            System.out.print(label);
            String s = sc.nextLine().trim();
            if (Validator.isYes(s)) {
                return true;
            }
            if (Validator.isNo(s)) {
                return false;
            }
            error();
        }
    }

    private String promptNonEmpty(String label) {
        while (true) {
            System.out.print(label);
            String s = sc.nextLine().trim();
            if (!s.isBlank()) {
                return s;
            }
            error();
        }
    }

    private LocalDate promptDate(String label) {
        while (true) {
            System.out.print(label);
            String s = sc.nextLine().trim();
            LocalDate d = Validator.parseFutureDate(s);
            if (d != null) {
                return d;
            }
            error();
        }
    }

    private LocalDateTime promptPickupTime(LocalDate bookingDate) {
        while (true) {
            System.out.print("TimePickUp: ");
            String s = sc.nextLine().trim();
            LocalDateTime dt = Validator.parsePickup(s);
            if (dt != null && Validator.isPickupValid(dt, bookingDate)) {
                return dt;
            }
            error();
        }
    }

    // =============== Output helpers ===============
    private void printHeaderAll() {
        System.out.println("ID - Name - Phone - RoomNumbers - BookingDate - Flight - Seat - TimePickUp");
    }

    private void printOneLine(Reservation r) {
        String flight = "", seat = "", tpu = "";
        if (r.getFlightInformation() != null) {
            flight = r.getFlightInformation().getFlightNumber();
            seat = r.getFlightInformation().getSeatNumber();
            tpu = Validator.DT_FMT.format(r.getFlightInformation().getTimePickUp());
        }
        System.out.printf("%s - %s - %s - %s - %s - %s - %s - %s%n",
                r.getBookingID(),
                r.getCustomerName(),
                r.getPhoneNumber(),
                r.getRoomNumber(),
                Validator.DATE_FMT.format(r.getBookingDate()),
                flight, seat, tpu);
    }

    private void error() {
        System.out.println("Data input is  invalid");
    } // lưu ý 2 khoảng trắng theo đề
}
