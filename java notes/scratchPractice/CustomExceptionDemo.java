class AgeException extends Exception {
    AgeException(String msg) {
        super(msg);
    }
}

public class CustomExceptionDemo {
    static void checkAge(int age) throws AgeException {
        if (age < 18) {
            throw new AgeException("Age is below 18, not eligible");
        } else {
            System.out.println("Age accepted, eligible");
        }
    }

    public static void main(String[] args) {
        try {
            checkAge(15);
        } catch (AgeException e) {
            System.out.println("Custom exception caught");
            System.out.println(e.getMessage());
        }

        try {
            checkAge(22);
        } catch (AgeException e) {
            System.out.println(e.getMessage());
        }
    }
}
