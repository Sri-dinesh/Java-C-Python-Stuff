import java.util.Scanner;

public class Week7a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 1st Number");
        String s1 = sc.next();
        System.out.println("Enter 2st Number");
        String s2 = sc.next();

        System.out.println("The 1st & 2nd Numbers are: " + s1 + "and" + s2);

        try {
            int n1 = Integer.parseInt(s1);
            int n2 = Integer.parseInt(s2);

            if (n2 == 0)
                throw new ArithmeticException("Num2 can't be zero");

            System.out.println("Result: " + n1 / n2);

        } catch (NumberFormatException e) {
            System.out.println("The numbers must be numerical data " + e);
        } catch (ArithmeticException ae) {
            System.out.println("Num2 must not be zeo " + ae);
        } catch (Exception ee) {
            System.out.println("Something went wrong " + ee);
        } finally {
            System.out.println("Execution Completeedd !!!");
        }

        sc.close();
    }
}
