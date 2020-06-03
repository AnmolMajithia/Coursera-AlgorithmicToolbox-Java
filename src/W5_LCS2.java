import java.util.*;

public class W5_LCS2 {
    public static void printArray(int[][] a, int[] s, int[] t) {
        System.out.println("\n\n");
        System.out.print("   0  ");
        for (int value : t) {
            System.out.print(value + "  ");
        }
        System.out.println();
        for(int i = 0; i < a.length; i++) {
            if(i == 0) {
                System.out.print("0  ");
            } else {
                System.out.print(s[i - 1] + "  ");
            }
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + "  ");
            }
            System.out.println();
        }
    }

    private static int lcs2(int[] a, int[] b) {
        int[][] l = new int[a.length+1][b.length+1];
        for (int i = 0; i <= a.length; i++) {
            for (int j=0; j <= b.length; j++) {
                if (i == 0 || j == 0) {
                    l[i][j] = 0;
                }
                else if (a[i - 1] == b[j - 1]) {
                    l[i][j] = l[i - 1][j - 1] + 1;
                }
                else {
                    l[i][j] = Math.max(l[i - 1][j], l[i][j - 1]);
                }
                //printArray(l,a,b);
            }
        }
        return l[a.length][b.length];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        System.out.println(lcs2(a, b));
    }
}

