
class NegativeAgeException extends Exception {

    public NegativeAgeException(String s) {
        super(s);
    }

    public String toString() {
        return "Age Exception";
    }
}

public class Week7b {

    static void NegativeAgeCheck(int age) throws NegativeAgeException {
        if (age < 0) {
            throw new NegativeAgeException("Not a valid age broo");
        } else {
            System.out.println("Welcome to the world");
        }
    }

    public static void main(String[] args) {

        try {
            NegativeAgeCheck(17);
            NegativeAgeCheck(0);
            NegativeAgeCheck(-1);
            NegativeAgeCheck(20);
        } catch (NegativeAgeException ne) {
            System.out.println("how are u in this world broo " + ne);
        } catch (Exception e) {
            System.out.println("seems like you've entered negative age -- please try again " + e);
        } finally {
            System.out.println("Finally statement also executed !!");
        }

    }
}