
import java.util.Scanner;

class Rectangle {
    double length;
    double width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double calculateArea() {
        return 2 * (length + width);
    }
}

public class Constructors {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter rectangle Length & Width: ");
        double len = sc.nextDouble();
        double wid = sc.nextDouble();

        Rectangle ra = new Rectangle(len, wid);

        System.out.println("The Lenght of Rect is: " + len + " & Width is: " + wid);
        System.out.println("The Area of Rectangle is " + ra.calculateArea());

    }
}