import java.util.*;

public class W2_FibonacciSumSquares {
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

    private static long fibo(long n) {
        n = n%getPisano(10);
        if(n <= 1) return n;
        long prev = 0;
        long curr = 1;
        for(long i = 0; i < n-1; i++) {
            long temp = prev;
            prev = curr;
            curr = (temp + prev)%10;
        }
        return curr;
    }

    private static long getFibonacciSumSquares(long n) {
        double sum = fibo(n) * fibo(n+1);
        return (long)(sum % 10);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumSquares(n);
        System.out.println(s);
    }
}

