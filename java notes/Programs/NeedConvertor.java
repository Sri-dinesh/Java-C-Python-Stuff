package Programs;
import Measure.Convertor;
import java.util.*;

class NeedConvertor {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            int choice;

            System.out.println("Enter your choice: 1. MM to CM | 2. CM to M | 3. M to KM");

            choice = sc.nextInt();

            System.out.println("Enter m value: ");
            double m = sc.nextDouble();
            Convertor c = new Convertor(m);

            switch (choice) {
                case 1:
                    System.out.println("MM To CM");
                    System.out.println(c.mmTocm(m) + " CM");
                    break;

                case 2:
                    System.out.println("CM TO M");
                    System.out.println(c.cmTom(m) + " M");
                    break;

                case 3:
                    System.out.println("M TO KM");
                    System.out.println(c.mTokm(m) + " KM");
                    break;

                default:
                    System.out.println("Invalid Option");
                    break;
            }

        }

    }
}