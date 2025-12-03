import java.util.*;

public class ExceptionDemo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number num1");
        String s1 = sc.next();
        System.out.println("Enter the number num2");
        String s2 = sc.next();

        try {
            int num1 = Integer.parseInt(s1);
            int num2 = Integer.parseInt(s2);

            System.out.println("Num1 is " + num1 + "Num2 is: " + num2);

            if (num2 == 0) {
                throw new ArithmeticException("Division error");
            }

            int res = num1 / num2;
            System.out.println("The result is: " + res);
        } catch (NumberFormatException nfe) {
            System.out.println("THe numbers must be numeric data");
            System.out.println("Exception " + nfe);
        } catch (ArithmeticException ae) {
            System.out.println("Num2 must not be zero");
            System.out.println("Exception " + ae);
        } finally {
            System.out.println("Finally block is excecuted");
        }
        System.out.println("Remaining Statements");
    }
}