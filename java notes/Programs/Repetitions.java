package Programs;

// repeatEnd("Hello", 3) "llollollo",
// repeatEnd("Hello", 2) "lolo",
// repeatEnd("Hello", 1) "o"
import java.util.Scanner;

class Something1 {

    String repeatEnd(String s, int n) {
        String s1 = "";

        int len = s.length();

        for (int i = 0; i < n; i++) {
            s1 += s.substring(len - n, len);
        }

        return s1;
    }

}

// public class Repetitions extends Something {
public class Repetitions {

    public static void main(String[] args) {

        // Repetitions r = new Repetitions();
        Something1 r = new Something1();

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int n = sc.nextInt();

        System.out.println("Enter any string: ");
        String a = sc.next();

        System.out.println("Entered string is " + a + " and entered number is: " + n);

        System.out.println(r.repeatEnd(a, n));

        sc.close();

    }
}