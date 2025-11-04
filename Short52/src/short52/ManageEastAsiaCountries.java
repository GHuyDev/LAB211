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
import java.util.Collections;
import java.util.Comparator;

public class ManageEastAsiaCountries {
    private ArrayList<EastAsiaCountries> countryList;

    public ManageEastAsiaCountries() {
        countryList = new ArrayList<>();
    }
    
    // addCountryInformation: Add information for a country
    public void addCountryInformation(EastAsiaCountries country) throws Exception {
        if (country.getTotalArea() <= 0) {
            throw new Exception("Total area must be greater than 0.");
        }
        countryList.add(country);

        if (countryList.size() >= 11) {
            System.out.println("The list already contains 11 countries.");
        }
    }

    // getRecentlyEnteredInformation : Display information of countries
    public ArrayList<EastAsiaCountries> getRecentlyEnteredInformation() throws Exception {
        if (countryList.isEmpty()) {
            throw new Exception("No country information has been entered yet.");
        }
        return countryList;
    }
    
    // display a list of countries
    public void displayCountryList(ArrayList<EastAsiaCountries> list) {
        if (list.isEmpty()) {
            System.out.println("No countries to display.");
            return;
        }
        EastAsiaCountries.printHeader();
        for (EastAsiaCountries country : list) {
            country.display();
        }
    }

    //searchInformationByName: Search information of countries
    public EastAsiaCountries[] searchInformationByName(String name) {
        ArrayList<EastAsiaCountries> searchResult = new ArrayList<>();
        // Case-insensitive search
        for (EastAsiaCountries country : countryList) {
            if (country.getCountryName().toLowerCase().contains(name.toLowerCase())) {
                searchResult.add(country);
            }
        }
        return searchResult.toArray(new EastAsiaCountries[0]);
    }

    
    // sortInformationByAscendingOrder : Displays the names of countries by name ascending
    public ArrayList<EastAsiaCountries> sortInformationByAscendingOrder() {
        // Create a copy to sort, avoiding modification of the original list
        ArrayList<EastAsiaCountries> sortedList = new ArrayList<>(countryList);
        
        // Sort using Comparator based on countryName
        Collections.sort(sortedList, new Comparator<EastAsiaCountries>() {
            @Override
            public int compare(EastAsiaCountries c1, EastAsiaCountries c2) {
                return c1.getCountryName().compareTo(c2.getCountryName());
            }
        });
        
        return sortedList;
    }
}