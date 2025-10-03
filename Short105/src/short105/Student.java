package short105;

import java.util.Scanner;

public class Student extends Person{
    private int yearOfAdmission;
    private int entrance;
    
    public Student(){
        super();
        this.yearOfAdmission = 0;
        this.entrance = 0;
    }
    
    @Override
    public void inputAll(){
        super.inputAll();  //super. là gọi tất cả phương thức của lớp cha  //super là gọi constructor
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.print("Year of admission: ");
            yearOfAdmission = scanner.nextInt();
            if (Validator.isValidAdmissionYear(yearOfBirth, yearOfAdmission)) break;
            System.out.println("Data input is invalid.");
        }
        
        while (true) {
            System.out.print("Entrance English score: ");
            entrance = scanner.nextInt();
            if (Validator.isValidEnglishScore(entrance)) break;
            System.out.println("Data input is invalid.");
        }
    }
    
    public int getYearOfAdmission() {
        return yearOfAdmission;
    }
    
     @Override
    public String toString() {
        return super.toString() + String.format(" - %d - %d", yearOfAdmission, entrance);
    }
}
