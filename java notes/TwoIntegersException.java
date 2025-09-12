import java.util.*;

public class TwoIntegersException {
    public static void main(String[] args) throws NumberFormatException {

        Scanner sc = new Scanner(System.in);

        int num1;
        int num2;

        num1 = sc.nextInt();
        num2 = sc.nextInt();

        try {
            float res = num1 / num2;
            System.out.println(res);
        } catch (NumberFormatException nfe) {
            System.out.println(nfe);
        }
        finally {
            System.out.println("Perfomr");
        }

    }
}