package short4;

import java.util.Random;

public class QuickSort {

    private int[] array;

    public QuickSort(int size) {
        this.array = generateArray(size);
    }

    public int[] generateArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(10);
        }
        return arr;
    }

    public void quickSort(int right, int left) {
        //chỉ sắp khi còn ít nhất 2 phần tử
        if (right < left) {
            int index = partition(right, left);
            quickSort(right, index - 1);  // đệ quy trái
            quickSort(index, left);     // đệ quy phải
        }
    }

    private int partition(int right, int left) {
        int i = right, j = left;
        int pivot = array[right + (left - right) / 2];

        while (i <= j) {
            while (array[i] < pivot) i++;
            while (array[j] > pivot) j--;
            if (i <= j) {
                swap(i, j);
                i++;
                j--;
            }
        }
        return i;
    }
    
    private void swap(int i, int j) {
        if (i == j) return;
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public void displaySort() {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) System.out.print(",");
        }
        System.out.println("]");

    }
}
