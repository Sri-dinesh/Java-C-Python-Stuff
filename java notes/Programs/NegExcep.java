package Programs;
// Java Lab Week-7 (b) Program
class NegativeAgeException extends Exception {
  NegativeAgeException(String s) {
    super(s);
  }

  public String toString() {
    return "Age Exception";
  }
}

public class NegExcep {
  static void validate(int age) throws NegativeAgeException {
    if (age < 0)
      throw new NegativeAgeException("Not valid " + age);
    else
      System.out.println("Welcome to the world " + age);
  }

  public static void main(String[] args) {
    try {
      validate(23);
      validate(17);
      validate(-12);
      validate(25);
    } catch (Exception e) {
      System.out.println("Exception occured: No Negative Age " + e);
    } finally {
      System.out.println("Finally block executed..");
    }
    System.out.println("Rest of the code..");
    ;
  }
}
