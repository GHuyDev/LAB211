package com.mycompany.shortp107;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public final class Validator {
    private Validator() {}

    // Định dạng ngày/giờ
    public static final DateTimeFormatter DATE_FMT =
            DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static final DateTimeFormatter DT_FMT   =
            DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mma", Locale.ENGLISH);

    //
    public static boolean isDigits(String s, int exactLen) {
        return s != null && s.matches("\\d{" + exactLen + "}");
    }

    public static boolean isValidName(String s) {
        // Chỉ chữ (mọi locale) và khoảng trắng, không để trống
        return s != null && !s.isBlank() && s.matches("[\\p{L} ]+");
    }

    public static boolean isYes(String s) {
        return s != null && (s.equalsIgnoreCase("Y") || s.equalsIgnoreCase("YES"));
    }
    public static boolean isNo(String s) {
        return s != null && (s.equalsIgnoreCase("N") || s.equalsIgnoreCase("NO"));
    }

    // --------- Parsing with rules ---------
    // Parse BookingDate dạng dd/MM/yyyy và bắt buộc > hôm nay */
    public static LocalDate parseFutureDate(String s) {
        try {
            LocalDate d = LocalDate.parse(s, DATE_FMT);
            return d.isAfter(LocalDate.now()) ? d : null;
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    // Parse TimePickUp dạng dd/MM/yyyy hh:mma (ví dụ 21/12/2025 10:00AM) */
    public static LocalDateTime parsePickup(String s) {
        try {
            return LocalDateTime.parse(s.toUpperCase(Locale.ENGLISH), DT_FMT);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    /** TimePickUp phải SAU hiện tại và TRƯỚC bookingDate (tối đa đến 23:59:59 của bookingDate) */
    public static boolean isPickupValid(LocalDateTime pickup, LocalDate bookingDate) {
        if (pickup == null || bookingDate == null) return false;
        LocalDateTime now = LocalDateTime.now();
        if (!pickup.isAfter(now)) return false;
        LocalDateTime latest = bookingDate.atTime(23, 59, 59);
        return pickup.isBefore(latest);
    }
}
