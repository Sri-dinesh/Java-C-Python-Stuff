import java.util.Scanner;

public class Patterns {

    int n = 5;
    // System.out.println("Enter the number of rows for the pattern:");
    // int n = sc.nextInt();

    void nxn() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    void rightAngledTriangle() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    void RightAngledNumber1Triangle() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    void RightAngledNumber2Triangle() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    void RightAngledInvertedTriangle() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    void RightAngledInvertedNumberTriangle() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    void Triangle() {
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
    }

    void InvertedTriangle() {
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < 2 * n - (2 * i + 1); j++) {
                System.out.print("*");
            }

            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            System.out.println();

        }
    }

    void Diamond() {
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

            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < 2 * n - (2 * i + 1); j++) {
                System.out.print("*");
            }

            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            System.out.println();

        }
    }

    void FullRightAngledTriangle() {
        int n = 9;
        for (int i = 1; i <= 2 * n - 1; i++) {
            int stars = i;
            if (i > n)
                stars = 2 * n - i;
            for (int j = 1; j <= stars; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    void Num01Triangle() {
        int start = 1;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0)
                start = 1;
            else
                start = 0;

            for (int j = 0; j <= i; j++) {
                System.out.print(start);
                start = 1 - start;
            }
            System.out.println();
        }
    }

    void MiddleNumTriangle() {
        int space = 2 * n - 1;
        for (int i = 1; i <= n; i++) {
            // numbers
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }

            // space
            for (int j = 1; j <= space; j++) {
                System.out.print(" ");
            }

            // numbers
            for (int j = i; j >= 1; j--) {
                System.out.print(j);
            }

            System.out.println();
            space -= 2;
        }
    }

    void ContinousRightAngledTriangle() {
        int num = 1;
        int n = 5;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(num + " ");
                num += 1;
            }
            System.out.println();
        }
    }

    void RepeatedCharTriangle() {
        for (int i = 0; i <= n; i++) {
            for (char j = 'A'; j <= 'A' + i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    void InvertedCharTriangle() {
        for (int i = 0; i <= n; i++) {
            for (char j = 'A'; j <= 'A' + (n - i - 1); j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    void RepeatedRowCharTriangle() {
        for (int i = 1; i <= 'A' + i; i++) {
            for (char j = 'A'; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Patterns patterns = new Patterns();

        System.out.println("NxN Pattern:");
        patterns.nxn();

        System.out.println("Right Angled Triangle Pattern:");
        patterns.rightAngledTriangle();
        System.out.println();

        System.out.println("Right Angled Number1 Triangle Pattern:");
        patterns.RightAngledNumber1Triangle();
        System.out.println();

        System.out.println("Right Angled Number2 Triangle Pattern:");
        patterns.RightAngledNumber2Triangle();
        System.out.println();

        System.out.println("Right Angled Inverted Triangle");
        patterns.RightAngledInvertedTriangle();
        System.out.println();

        System.out.println("Right Angled Inverted Number Triangle");
        patterns.RightAngledInvertedNumberTriangle();
        System.out.println();

        System.out.println("Triangle Pattern:");
        patterns.Triangle();
        System.out.println();

        System.out.println("Inverted Triangle Pattern:");
        patterns.InvertedTriangle();
        System.out.println();

        System.out.println("Diamond Pattern:");
        patterns.Diamond();
        System.out.println();

        System.out.println("FullRightAngledTriangle");
        patterns.FullRightAngledTriangle();
        System.out.println();

        System.out.println("Num01Triangle");
        patterns.Num01Triangle();
        System.out.println();

        System.out.println("MiddleSpaceNumTriangle");
        patterns.MiddleNumTriangle();
        System.out.println();

        System.out.println("ContinousRightAngledTriangle");
        patterns.ContinousRightAngledTriangle();
        System.out.println();

        System.out.println("RepeatedCharTriangle");
        patterns.RepeatedCharTriangle();
        System.out.println();

        System.out.println("InvertedCharTriangle");
        patterns.InvertedCharTriangle();
        System.out.println();

        System.out.println("RepeatedRowCharTriangle");
        patterns.RepeatedRowCharTriangle();
        System.out.println();

        sc.close();
    }
}