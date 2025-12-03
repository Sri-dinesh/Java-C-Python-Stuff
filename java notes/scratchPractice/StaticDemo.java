import java.util.*;

public class StaticDemo {

    static int length;
    static int width;

    public static int calculate() {
        return length * width;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Length & Width for the Rectangle:");
        length = sc.nextInt();
        width = sc.nextInt();

        System.out.println("The area of Rectangle is: " + calculate());

        sc.close();

    }
}