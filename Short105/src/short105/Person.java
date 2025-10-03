package short105;

import java.util.Scanner;

public class Person {
    protected String id;
    protected String fullName;
    protected String phoneNumber;
    protected int yearOfBirth;
    protected String major;

    public Person(){
        this.id = "";
        this.fullName = "";
        this.phoneNumber = "";
        this.yearOfBirth = 0;
        this.major = "";
    }
    
    public void inputAll(){
         Scanner scanner = new Scanner(System.in);
         
         while(true){
             System.out.print("ID: ");
             id = scanner.nextLine();
             if(id.length() == 6 && Validator.isAllDigits(id)) break;
             System.out.println("Data input is invalid");
         }
         
         while(true){
             System.out.print("Fullname:");
             fullName = scanner.nextLine();
             if(Validator.isAlphabet(fullName)) break;
             System.out.println("Data input is invalid");
         }
         
         while(true){
             System.out.print("Phone number: ");
             phoneNumber = scanner.nextLine();
             if(Validator.isValidPhone(phoneNumber)) break;
             System.out.println("Data input is invalid");
         }
         
         while(true){
             System.out.print("Year of birth: ");
             yearOfBirth = scanner.nextInt();
             scanner.nextLine();
             if(Validator.isValidYear(yearOfBirth)) break;
             System.out.println("Data input is invalid");
         }
         
         while(true){
             System.out.print("Major: ");
             major = scanner.nextLine();
             if(Validator.isValidMajor(major)) break;
             System.out.println("Data input is invalid");
         }
    }
    
    public String getFullName() {
        return fullName;
    }
    
    @Override
    public String toString(){
        return String.format("%s - %s - %s - %d - %s", id, fullName, phoneNumber, yearOfBirth, major);
    }
}