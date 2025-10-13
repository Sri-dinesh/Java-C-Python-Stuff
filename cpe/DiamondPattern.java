
public class DiamondPattern {
  public static void main(String[] args) {
    int n = 5;

    for (int i = n; i <= 0; i--) {
      for (int j = 0; j <= i + 1; j++) {
        System.out.printf("*");
      }
      System.out.println(" ");
    }
  }
}
