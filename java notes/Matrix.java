
import java.util.*;

class Matrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m;
        System.out.println("Enter row elements: ");
        n = sc.nextInt();
        System.out.println("Enter column elements: ");
        m = sc.nextInt();

        int[][] m1 = new int[n][m];
        int[][] m2 = new int[n][m];
        int[][] m3 = new int[n][m];

        System.out.println("Enter elements for Matrix 1");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                m1[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter elements for Matrix 2");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                m2[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m2.length; j++) {
                for (int k = 0; k < m2.length; k++) {
                    m3[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }

        System.out.println("Result: ");
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m2.length; j++) {
                System.out.println(m3[i][j]);
            }
        }

        sc.close();

    }
}
