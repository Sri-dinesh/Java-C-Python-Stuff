import java.util.*;

class Something {

    public int countTriple(String s) {

        int count = 0;
        int len = s.length();
        for (int i = 0; i < len - 2; i++) {
            char temp = s.charAt(i);

            if (temp == s.charAt(i + 1) && temp == s.charAt(i + 2)) {
                count++;
            }
        }

        return count;
    }
}

public class Triple {

    public static void main(String[] args) {

        Something s = new Something();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter any string: ");
        String a = sc.next();

        System.out.println(s.countTriple(a));

        sc.close();

    }
}