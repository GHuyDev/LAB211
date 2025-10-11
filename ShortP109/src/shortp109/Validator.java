package shortp109;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public final class Validator {
    private Validator(){}

    // Accept 1/2-digit day/month as in sample (3/9/2024). 
    public static final DateTimeFormatter DATE_FMT = DateTimeFormatter.ofPattern("d/M/yyyy");

    public static boolean notEmpty(String s) { return s != null && !s.trim().isEmpty(); }

    public static Integer parsePositiveInt(String s) {
        try {
            int v = Integer.parseInt(s.trim());
            return v > 0 ? v : null;
        } catch (Exception e) { return null; }
    }

    public static LocalDate parseDate(String s) {
        try { return LocalDate.parse(s.trim(), DATE_FMT); }
        catch (DateTimeParseException e) { return null; }
    }

    public static boolean isFuture(LocalDate d) { return d != null && d.isAfter(LocalDate.now()); }
}
