package Programs;
import java.util.*;

class Volume {

    public double Vol(double r) {
        // System.out.println("Sphere");
        return (4 / 3) * Math.PI * r * r * r;
    }

    public double Vol(double h, double r, boolean b) {
        // System.out.println("Cone");
        return Math.PI * r * r * h;
    }

    public double Vol(double r, double h) {
        // System.out.println("Cylinder");
        return (1 / 3) * Math.PI * r * r * h;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Volume v = new Volume();

        // sphere
        double radiusSphere;

        // cone
        double radiusCone;
        double heightCone;
        boolean b = true;

        // cynlinder
        double radiusCynlinder;
        double heightCynlinder;

        double radius;
        double height;

        radius = sc.nextDouble();
        height = sc.nextDouble();

        int choice;
        while (true) {

            System.out.println("Enter your choice: 1. Sphere 2.Cone 3.Cylinder 4.Exit");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter Sphere Radius: ");
                    radiusSphere = sc.nextDouble();
                    System.out.println(v.Vol(radiusSphere));
                    break;

                case 2:
                    System.out.println("Enter Cone Radius, Height: ");
                    radiusCone = sc.nextDouble();
                    heightCone = sc.nextDouble();
                    System.out.println(v.Vol(radiusCone, heightCone, b));
                    break;

                case 3:
                    System.out.println("Enter Cylinder Radius, Height: ");
                    radiusCynlinder = sc.nextDouble();
                    heightCynlinder = sc.nextDouble();
                    System.out.println(v.Vol(radiusCynlinder, heightCynlinder));
                    break;

                case 4:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invaid Choice");
                    break;
            }

        }

    }
}