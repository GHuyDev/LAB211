package short06;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int n = Validator.getPositiveIntegerInput("Enter number of array: ");
        
        BinarySearch bs = new BinarySearch(new int[n]);
        
        int[] arr = bs.generateArray(n);
        
        bs = new BinarySearch(arr);
        
        int x = Validator.getIntegerInput("Enter search value: ");
        
        Arrays.sort(arr);
        
        System.out.print("Sorted array: ");
        bs.displaySort();
        
        int index = bs.search(x);
        if (index != -1) {
            System.out.println("Found " + x + " at index: " + index);
        } else {
            System.out.println(x + " not found in array.");
        }

    }
}
