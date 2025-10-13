import java.util.*;

class Underage extends Exception {
  Underage(String s) {
    System.out.println("Invalid age");
  }
}

public class TwoIntegersException {
  public static void main(String[] args) throws NumberFormatException {

    Scanner sc = new Scanner(System.in);

    int num1;
    int num2;
    int age = 17;

    num1 = sc.nextInt();
    num2 = sc.nextInt();

    try {
      // float res = num1 / num;
      // System.out.println(res);
      if (age < 18) {
        throw new Underage("Not valid");
      }
    } catch (Underage ua) {
      System.out.println(ua);
    }

    catch (ArithmeticException ae) {
      System.out.println(ae);
    } catch (Exception nfe) {
      System.out.println(nfe);
      nfe.toString();
      // nfe.stackTrace();
      System.out.println(nfe.getMessage());
    } finally {
      System.out.println("Perfomr");
    }
    sc.close();
  }
}
