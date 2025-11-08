import java.util.*;

public class ArrayManipulation {
    public static void main(String[] args) {
        int[] numbers = { 4, 2, 7, 1, 9, 5 };
        System.out.println("Original Array: " + Arrays.toString(numbers));
        Arrays.sort(numbers);
        System.out.println("Sorted Array: " + Arrays.toString(numbers));
        int[] filledArray = new int[5];
        Arrays.fill(filledArray, 10);
        System.out.println("Filled Array: " + Arrays.toString(filledArray));
        int searchElement = 7;
        int index = Arrays.binarySearch(numbers, searchElement);
        if (index >= 0) {
            System.out.println("Element " + searchElement + " found at index " + index);
        } else {
            System.out.println("Element " + searchElement + " not found in the array");
        }
        int[] arr1 = { 1, 2, 3, 4, 5 };
        int[] arr2 = { 1, 2, 3, 4, 5 };
        int[] arr3 = { 1, 2, 3, 4 };
        if (Arrays.equals(arr1, arr2)) {
            System.out.println("arr1 and arr2 are equal");
        } else {
            System.out.println("arr1 and arr2 are not equal");
        }
        if (Arrays.equals(arr1, arr3)) {
            System.out.println("arr1 and arr3 are equal");
        } else {
            System.out.println("arr1 and arr3 are not equal");
        }
    }
}