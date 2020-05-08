import java.util.*;
import java.io.*;

public class W1_MaxPairwiseProduct {
    static long getMaxPairwiseProduct(int[] numbers) {
        Arrays.sort(numbers);
        return (long)numbers[0]*(long)numbers[1] > (long)numbers[numbers.length-1]*(long)numbers[numbers.length-2] ? (long)numbers[0]*(long)numbers[1] : (long)numbers[numbers.length-1]*(long)numbers[numbers.length-2];
    }

    public static void main(String[] args) {
        // Stress Testing :
        //int n = (int)Math.random()*10 + 2;


        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProduct(numbers));
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
