package Programs;
import java.util.*;

public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.printf("Enter any word: ");
        String s = sc.nextLine();
        System.out.println("You have entered: " + s);
        int len = s.length();
        System.out.println("Length of String is: " + len);

        sc.close();
        int i, l = len - 1;

        boolean flag = true;
        for (i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(l)) {
                flag = false;
            }
            l--;
        }

        System.out.println("flag: " + flag);

        if (flag == true) {
            System.out.println(s + " is Palindrome");
        } else {
            System.out.println(s + "is not Palindrome");
        }

    }
}