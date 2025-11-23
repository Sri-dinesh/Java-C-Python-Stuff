import java.util.*;

public class Week10b {
    public static void main(String[] args) {

        int[] numbers = { 32, 21, 3242, 51, 13, 42, 54, 19, 34, 543, 729 };
        System.out.println("Original Array " + Arrays.toString(numbers));

        Arrays.sort(numbers);
        System.out.println("I'm kinda dumb - don't know any sorting algorithmss !! - so using in-built methodss !!");
        System.out.println("Sorted using inbuilt method - skills issuess " + Arrays.toString(numbers));

        System.out.println();
        String[] filledArray = new String[10];

        Arrays.fill(filledArray, "Skills Issuesss");

        System.out.println("Filledd Arrayyy: " + Arrays.toString(filledArray));
        System.out.println();

        int searchValue = 19;

        int searchIndex = Arrays.binarySearch(numbers, searchValue);

        if (searchIndex >= 0) {
            System.out.println("Found the culpirt at: -->" + searchIndex);
        } else {
            System.out.println("Bad luck - didn't find the culprit in the array");
        }

        System.out.println();
        int[] arr1 = { 2, 4, 6, 1, 7 };
        int[] arr2 = { 9, 2, 1, 5, 7 };
        int[] arr3 = { 4, 8, 6, 2, 3 };

        if (Arrays.equals(arr1, arr2)) {
            System.out.println("OK I agree both arrays are actually equallll !!!");
            System.out.println("So I conclude that array 1 and 2 are equalll !! ");
        } else {
            System.out.println("Y the hell do u think both arrays will be equall ??!!!");
        }
        System.out.println();
        if (Arrays.equals(arr3, arr1)) {
            System.out.println("OK I agree both arrays are actually equallll !!!");
            System.out.println("So I conclude that array 3 and 1 are equalll !! ");
        } else {
            System.out.println("Y the hell do u think both arrays will be equall ??!!!");
        }

    }
}