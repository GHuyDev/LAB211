package short01;

import java.util.Random;

public class BubbleSort {

    private int[] array;

    public BubbleSort(int size) {
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

    public void bubbleSort() {
        for (int i = 0; i < array.length-1; i++) {
            boolean check = false;
            for (int j = 0; j < array.length-i-1; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j + 1] = temp;
                    check = true;
                }
            }
            if(!check) break;
        }
    }

    public void displaySort() {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");

    }
}
