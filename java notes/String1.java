import java.util.Scanner;

public class String1 {
    public static void main(String[] args) {
        String s1 = "Java";
        String s2 = "Java";

        String s3 = new String("Programming");

        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s2 == s3);

        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter any String: ");
        String s4 = sc.nextLine();
        System.out.printf("Enter any String: ");
        String s5 = sc.nextLine();

        // == -> false(compares references not values) & equals() -> True
        System.out.println(s4 == s5);
        System.out.println(s4.equals(s5));

        String s = 50 + 40 + "String" + 100 + 90;
        // Java reads "+" from left to right.
        // If both sides are numbers → it adds them.
        // If one side is a string → it sticks them together as text.
        System.out.println(s);

        String str = "java, rust, go, web3";
        System.out.println(str);
        String[] langs = str.split(",");

        for (String lang : langs) {
            System.out.println(lang);
        }

        // String Methods --> concat(), split(), equals(), charAt(), length(),
        // replace(), intern()= returns a canonical representation of the string
        // object from the string pool(pullling object from the string pool);
        // substring(),
        String ss = new String("Sridinesh");
        System.out.println(ss.intern());

        // Class Loader -> uses a string object as an argument
        // Thread safe -> as the string object is immutable we dont' have to take care
        // fo the synchronization that is required while sharing an oject across
        // multiple threads.
        // Heap Space -> the immutabiltiy of string helps to minimize the usage in the
        // heap memory.
        sc.close();

    }
}
