import java.util.*;
import java.io.*;

public class W4_MajorityElement {
    private static int count(int[] a, int left, int right, int element) {
        int count = 0;
        for(int i = left; i <= right; i++) {
            if(a[i] == element) {
                count++;
            }
        }
        return count;
    }

    private static int getMajorityElement(int[] a, int left, int right) {
        if(left > right) {
            return -1;
        }
        if (left == right) {
            return a[left];
        }
        int mid = left + (right-left)/2;
        int left_half = getMajorityElement(a, left, mid);
        int right_half = getMajorityElement(a, mid+1, right);
        if(left_half != -1 && right_half != -1) {
            int lc = count(a, left, right, left_half);
            int rc = count(a, left, right, right_half);
            if(lc > (right - left + 1) / 2) {
                return left_half;
            }
            else if(rc > (right - left + 1) / 2) {
                return right_half;
            }
            else {
                return -1;
            }
        }
        else if(left_half == -1 && right_half != -1) {
            int rc = count(a, left, right, right_half);
            if(rc > (right - left + 1) / 2) {
                return right_half;
            }
            else {
                return -1;
            }
        }
        else if(left_half != -1) {
            int lc = count(a, left, right, left_half);
            if(lc > (right - left + 1) / 2) {
                return left_half;
            }
            else {
                return -1;
            }
        }
        else {
            return -1;
        }
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (getMajorityElement(a, 0, a.length-1) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}