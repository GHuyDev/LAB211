package short105;

public class Validator {

    // Validate if the input is all digits
    public static boolean isAllDigits(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    // Validate if the input is alphabetic and contains spaces
    public static boolean isAlphabet(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isAlphabetic(c) && c != ' ') {
                return false;
            }
        }
        return true;
    }

    // Validate phone number (10 digits)
    public static boolean isValidPhone(String phoneNumber) {
        return phoneNumber.length() == 10 && isAllDigits(phoneNumber);
    }

    // Validate if year is valid (less than the current year)
    public static boolean isValidYear(int year) {
        return year < 2025;
    }

    // Validate that the year of admission is between birth year and current year
    public static boolean isValidAdmissionYear(int yearOfBirth, int yearOfAdmission) {
        return yearOfAdmission >= yearOfBirth && yearOfAdmission <= 2023;
    }

    // Validate entrance English score (0 to 100)
    public static boolean isValidEnglishScore(int score) {
        return score >= 0 && score <= 100;
    }

    // Validate if year in profession is within a reasonable range
    public static boolean isValidYearInProfession(int yearInProfession, int age) {
        return yearInProfession >= 0 && yearInProfession < age;
    }

    // Validate if the major length is within 30 characters
    public static boolean isValidMajor(String major) {
        return major.length() <= 30;
    }
}
