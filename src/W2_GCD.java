import java.util.*;

public class W2_GCD {
  private static int gcd_naive(int a, int b) {
    int current_gcd = 1;
    for(int d = 2; d <= a && d <= b; ++d) {
      if (a % d == 0 && b % d == 0) {
        if (d > current_gcd) {
          current_gcd = d;
        }
      }
    }
    return current_gcd;
  }

  private static int gcd_eff(int a, int b) {
    if(b == 0) return a;
    return gcd_eff(b, a%b);
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    long startTime = System.nanoTime();
    System.out.println(gcd_eff(a,b));
    long totalTime = System.nanoTime() - startTime;
    System.out.println("Time for effecient algo: " + totalTime/1000000 + "ms");
    startTime = System.nanoTime();
    System.out.println(gcd_naive(a,b));
    totalTime = System.nanoTime() - startTime;
    System.out.println("Time for naive algo: " + totalTime/1000000 + "ms");
  }
}
