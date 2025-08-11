public class Test {

    static int n = 5;

    static void Triangle() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {

                System.out.print(" ");
            }
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }

            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }

    }

    static void DiamondStar() {
        for (int i = 0; i < n; i++) {
            // space
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }

            // star
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }

            // space
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
        for (int i = 0; i < n; i++) {
            // space
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }

            // star
            for (int j = 0; j < 2 * n - (2 * i + 1); j++) {
                System.out.print("*");
            }

            // space
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();

    }

    static void DiamondNumbers() {
        for (int i = 0; i < n; i++) {
            // space
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            // numbers
            for (int j = 1; j < 2 * i + 2; j++) {
                System.out.print(j + "");
            }
            // space
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
        for (int i = 0; i < n; i++) {
            // space
            for (int j = 0; j <= i; j++) {
                System.out.print(" ");
            }
            // numbers
            for (int j = 1; j < 2 * n - (2 * i + 2); j++) {
                System.out.print(j + "");
            }
            // space
            for (int j = 0; j <= i; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void DiamondChars() {
        for (int i = 0; i < n; i++) {
            // space
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            // numbers
            for (char j = 'A'; j < 'A' + (2 * i + 1); j++) {
                System.out.print(j + "");
            }
            // space
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
        for (int i = 0; i < n; i++) {
            // space
            for (int j = 0; j <= i; j++) {
                System.out.print(" ");
            }
            // number
            for (char j = 'A'; j <= (char) ('A' + (2 * (n - i - 2))); j++) {
                System.out.print(j + "");
            }
            // space
            for (int j = 0; j <= i; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();

    }

    static void HollowDiamondStar() {
        for (int i = 0; i < n; i++) {
            // space
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }
            // star
            for (int j = 0; j < 2 * i + 1; j++) {
                if (j == 0 || j == 2 * i)
                    System.out.print("*");
                System.out.print(" ");
            }

            System.out.println();
        }
        for (int i = n - 2; i >= 0; i--) {
            // space
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }
            // star
            for (int j = 0; j < 2 * i + 1; j++) {
                if (j == 0 || j == 2 * i)
                    System.out.print("*");
                System.out.print(" ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        Triangle();
        DiamondStar();
        DiamondNumbers();
        DiamondChars();
        HollowDiamondStar();
    }
}
