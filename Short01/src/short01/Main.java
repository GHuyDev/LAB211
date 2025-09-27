package short01;

public class Main {
    public static void main(String[] args) {
        int size = Validator.getPositiveIntegerInput("Enter number of array: ");
        
        BubbleSort sort = new BubbleSort(size);
        
        System.out.print("Unsorted array: ");
        sort.displaySort();
        
        sort.bubbleSort();
        
        System.out.print("Sorted array: ");
        sort.displaySort();
    }    
}
