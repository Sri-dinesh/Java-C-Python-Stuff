import java.util.*;

public class City {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter no.of cities");
        int n = sc.nextInt();

        String s[] = new String[n];

        System.out.println("-------------------");
        System.out.println("Enter city names");
        for (int i = 0; i < n; i++) {
            s[i] = sc.next();
        }

        System.out.println("-------------------");
        System.out.println("Before Sorting: ");
        for (int j = 0; j < n; j++) {
            System.out.println(s[j]);
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                String temp;
                if (s[i].compareTo(s[j]) > 0) {
                    temp = s[i];
                    s[i] = s[j];
                    s[j] = temp;
                }
            }
        }

        System.out.println("-------------------");
        System.out.println("After Sorting: ");
        for (int i = 0; i < n; i++) {
            System.out.println(s[i]);
        }
        sc.close();
    }
}