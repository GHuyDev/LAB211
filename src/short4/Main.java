package short4;

public class Main {
    public static void main(String[] args) {
        int size = Validator.getPositiveInteger("Enter number of array: ");

        QuickSort qs = new QuickSort(size);

        System.out.print("Unsorted array: ");
        qs.displaySort();

        qs.quickSort(0, size - 1);

        System.out.print("Sorted array: ");
        qs.displaySort();
    }
}

