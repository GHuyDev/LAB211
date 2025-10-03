package short105;

import java.util.Scanner;

public class Teacher extends Person{
    private int yearInProfession;
    private String contractType;
    private double salary;
    
    public Teacher(){
        super();
        this.yearInProfession = 0;
        this.contractType = "";
        this.salary = 0;
    }
    
    @Override
    public void inputAll(){
        super.inputAll();
        
        Scanner scanner = new Scanner(System.in);
        
        while (true){//kiểm tra năm công tác
            System.out.print("Year in the profession: ");
            yearInProfession = scanner.nextInt();
            if (Validator.isValidYearInProfession(yearInProfession, 2025 - yearOfBirth)) break;
            System.out.println("Data input is invalid.");
        }
        
        while (true){//kiểm tra loại hợp đồng
            System.out.print("Contract type: ");
            contractType = scanner.next();
            scanner.nextLine();
            if (contractType.equals("Long") || contractType.equals("Short")) break;
            System.out.println("Data input is invalid.");
        }
        
        while (true){//kiểm tra hệ số lương
            System.out.print("Salary coefficient: ");
            salary = scanner.nextDouble();
            scanner.nextLine();
            if (salary >= 0) break;
            System.out.println("Data input is invalid.");
        }
    }
    
    public int getYearInProfession() {
        return yearInProfession;
    }
    
    @Override
    public String toString() {
        return super.toString() + String.format(" - %d - %s - %.2f", yearInProfession, contractType, salary);
    }
}
