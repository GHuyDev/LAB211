package short51;

public class Main {

    public static void main(String[] args) {
        Validator validator = new Validator();
        BMICalculator bmiCalc = new BMICalculator(validator);

        while (true) {
            System.out.println("========= Calculator Program =========");
            System.out.println("1. Normal Calculator");
            System.out.println("2. BMI Calculator");
            System.out.println("3. Exit");

            int choice = validator.getInt("Please choose one option: ", 1, 3);

            switch (choice) {
                case 1:
                    normalCalculator(validator);
                    break;
                case 2:
                    bmiCalc.calculateBMI();
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    return;
            }
        }
    }

    private static void normalCalculator(Validator validator) {
        System.out.println("----- Normal Calculator -----");
        double num1 = validator.getDouble("Enter a number: ");
        Calculation calculation = new Calculation(num1);

        while (true) {
            String op = validator.getOperator("Enter an operator: ");
            if (op.equals("=")) {
                System.out.println("Result is: " + calculation.getMemory());
                break;
            }

            double num2;
            if (op.equals("/")) num2 = validator.getDoubleForDivide("Enter a number: ");
            else  num2 = validator.getDouble("Enter a number: ");

            calculation.calculate(op, num2);
            System.out.println("Memory is: " + calculation.getMemory());
        }
    }
}
