/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package short52;

/**
 *
 * @author Huyb
 */

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final ManageEastAsiaCountries MANAGER = new ManageEastAsiaCountries();
    private static final int MAX_COUNTRIES = 11; // Limit for input

    public static void main(String[] args) {
        int choice;
        do {
            displayMenu();
            choice = getUserChoice();
            performFunction(choice);
        } while (choice != 5);
    }
    
    private static void displayMenu() {
        System.out.println("*** MENU ***");
        System.out.println("1. Input the information of " + MAX_COUNTRIES + " countries in East Asia");
        System.out.println("2. Display the information of country you've just input");
        System.out.println("3. Search the information of country by user-entered name");
        System.out.println("4. Display the information of countries sorted name in ascending order");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }
    
    private static int getUserChoice() {
        try {
            int choice = SCANNER.nextInt();
            SCANNER.nextLine(); // Consume newline
            return choice;
        } catch (InputMismatchException e) {
            System.err.println("Invalid input. Please enter a number between 1 and 5.");
            SCANNER.nextLine();
            return 0;
        }
    }

    private static void performFunction(int choice) {
        try {
            switch (choice) {
                case 1:
                    inputCountryInformation();
                    break;
                case 2:
                    displayRecentlyEnteredInformation();
                    break;
                case 3:
                    searchCountryByName();
                    break;
                case 4:
                    sortAndDisplayCountries();
                    break;
                case 5:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    if (choice != 0) {
                       System.out.println("Invalid choice. Please select an option from 1 to 5.");
                    }
                    break;
            }
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    private static void inputCountryInformation() {
        if (MANAGER.getCountryList().size() >= MAX_COUNTRIES) {
             System.out.println("Maximum number of countries (" + MAX_COUNTRIES + ") already input.");
             return;
        }
        
        System.out.println("--- Input Country Information ---");
        System.out.print("Enter code of country: ");
        String code = SCANNER.nextLine().trim();

        System.out.print("Enter name of country: ");
        String name = SCANNER.nextLine().trim();

        float area = -1;
        boolean validArea = false;
        while (!validArea) {
            System.out.print("Enter total Area: ");
            try {
                area = SCANNER.nextFloat();
                SCANNER.nextLine();
                if (area <= 0) {
                    System.err.println("Total area must be greater than 0. Please re-enter.");
                } else {
                    validArea = true;
                }
            } catch (InputMismatchException e) {
                System.err.println("Invalid area format. Please enter a number.");
                SCANNER.nextLine();
            }
        }
        
        System.out.print("Enter terrain of country: ");
        String terrain = SCANNER.nextLine().trim();

        EastAsiaCountries country = new EastAsiaCountries(code, name, area, terrain);
        try {
            MANAGER.addCountryInformation(country);
            System.out.println("Country information added successfully!");
        } catch (Exception e) {
            System.err.println("Failed to add country: " + e.getMessage());
        }
    }

    private static void displayRecentlyEnteredInformation() throws Exception {
        System.out.println("--- Recently Entered Country Information ---");
        ArrayList<EastAsiaCountries> list = MANAGER.getRecentlyEnteredInformation();
        MANAGER.displayCountryList(list);
    }
    
    private static void searchCountryByName() {
        System.out.print("Enter the name you want to search for: ");
        String searchName = SCANNER.nextLine().trim();

        EastAsiaCountries[] results = MANAGER.searchInformationByName(searchName);
        
        if (results.length == 0) {
            System.out.println("No country found with name containing: " + searchName);
        } else {
            System.out.println("--- Search Results ---");
            EastAsiaCountries.printHeader();
            for (EastAsiaCountries country : results) {
                country.display();
            }
        }
    }

    private static void sortAndDisplayCountries() {
        System.out.println("--- Countries Sorted by Name (Ascending) ---");
        ArrayList<EastAsiaCountries> sortedList = MANAGER.sortInformationByAscendingOrder();
        MANAGER.displayCountryList(sortedList);
    }
}
