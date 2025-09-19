package short51;

public class BMICalculator {
    private Validator validator;

    public BMICalculator(Validator validator) {
        this.validator = validator;
    }

    public void calculateBMI() {
        double weight = validator.getDouble("Enter Weight (kg): ");
        double heightCm = validator.getDouble("Enter Height (cm): ");
        double heightM = heightCm / 100.0;

        double bmi = weight / (heightM * heightM);
        System.out.printf("BMI Number: %.2f%n", bmi);

        if (bmi < 19) System.out.println("BMI Status: Under-standard");
        else if (bmi < 25) System.out.println("BMI Status: Standard");
        else if (bmi < 30) System.out.println("BMI Status: Overweight");
        else if (bmi < 40) System.out.println("BMI Status: Fat - should lose weight");
        else System.out.println("BMI Status: Very fat - should lose weight immediately");
    }
}
