package buble.sort;

import java.util.Random;
import java.util.Scanner;

public class BubleSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        do {
            System.out.println("Enter number of array : ");
            if (sc.hasNextInt()) {
                n = sc.nextInt();
                if (n <= 0) {
                    System.out.println("Input invalid, please enter a positive integer.");
                }
            } else {
                sc.nextLine(); // Clear the invalid input
                System.out.println("Input invalid, please enter a positive integer.");
                n = -1; // Set n to an invalid value to continue the loop
            }
        } while (n <= 0);
        int[] array = generateRandomArray(n);
        System.out.println("Array Unsorted: ");
        displayArray(array);
        BubbleSort(array);
        System.out.println("Array Sorted :");
        displayArray(array);
        sc.close();
    }

    public static int[] generateRandomArray(int maxValue) {

        int[] array = new int[maxValue];
        for (int i = 0; i < maxValue; i++) {
            array[i] = new Random().nextInt(maxValue);
        }
        return array;
    }

    public static void displayArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]\n");
    }

    public static void BubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
