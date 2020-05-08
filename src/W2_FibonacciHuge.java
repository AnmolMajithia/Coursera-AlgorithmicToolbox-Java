import java.util.*;

public class W2_FibonacciHuge {
    private static long getPisano(long m) {
        long curr = 1;
        long prev = 0;
        for(long i = 0; i < m*m; i++){
            long temp = prev;
            prev = curr;
            curr = (temp + curr)%m;
            if(prev == 0 && curr == 1) return i+1;
        }
        return 0;
    }

    private static long getFibonacciHugeNaive(long n, long m) {
        n = n%getPisano(m);
        if (n <= 1)
            return n;
        long previous = 0;
        long current  = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current)%m;
        }

        return current % m;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHugeNaive(n, m));
    }
}

