import java.util.*;

class W5_EditDistance {
  public static int min(int a, int b, int c) {
    if(a <= b && a <= c) return a;
    else if (b <= a && b <= c) return b;
    return c;
  }

  public static void printArray(int[][] a, String s, String t) {
    System.out.println("\n\n");
    System.out.print("   0  ");
    for (int i = 0; i < t.length(); i++) {
      System.out.print(t.charAt(i) + "  ");
    }
    System.out.println();
    for(int i = 0; i < a.length; i++) {
      if(i == 0) {
        System.out.print("0  ");
      } else {
        System.out.print(s.charAt(i - 1) + "  ");
      }
      for (int j = 0; j < a[0].length; j++) {
        System.out.print(a[i][j] + "  ");
      }
      System.out.println();
    }
  }

  public static int EditDistance(String s, String t) {
    int[][] dp = new int[s.length()+1][t.length()+1];
    for (int i = 0; i <= s.length(); i++) {
      for (int j = 0; j <= t.length(); j++) {
        if(i == 0) {
          dp[i][j] = j;
        }
        else if (j == 0) {
          dp[i][j] = i;
        }
        else if (s.charAt(i - 1) == t.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1];
        }
        else {
          dp[i][j] = 1 + min(dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - 1]);
        }
        //printArray(dp, s, t);
      }
    }
    return dp[s.length()][t.length()];
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(EditDistance(s, t));
  }
}
