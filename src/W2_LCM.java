import java.util.*;

public class W2_LCM {
  private static long lcm(int a, int b) {
    return (long)a*(long)b / gcd(a, b);
  }

  private static long gcd(int a, int b) {
    if(b == 0) return a;
    return gcd(b, a%b);
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(lcm(a, b));
  }
}
