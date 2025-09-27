package short06;

import java.util.Random;

public class BinarySearch {
    private int[] array;
    
    public BinarySearch(int[] sortedArray) {
        this.array = sortedArray;
    }

    public int[] generateArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(10);
        }
        return arr;
    }
    public int search(int x) {
        int l = 0, r = array.length - 1;
        while (l <= r) {
            int m = (l + r) >>> 1;
            if (array[m] == x) return m;
            if (array[m] < x) l = m + 1; else r = m - 1;
        }
        return -1;
    }
    
    public void displaySort() {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) System.out.print(", ");
        }
        System.out.println("]");

    }
}