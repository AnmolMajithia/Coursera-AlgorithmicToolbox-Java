import java.util.Scanner;

public class W2_Fibonacci {
    private static long calc_fib(int n) {
        if (n <= 1)
            return n;

        return calc_fib(n - 1) + calc_fib(n - 2);
    }

    private static long efficient(int n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        long startTime = System.nanoTime();
        System.out.println(efficient(n));
        long totalTime = System.nanoTime() - startTime;
        System.out.println("Time for effecient algo: " + totalTime/1000000 + "ms");
        startTime = System.nanoTime();
        System.out.println(calc_fib(n));
        totalTime = System.nanoTime() - startTime;
        System.out.println("Time for naive algo: " + totalTime/1000000 + "ms");

    }
}
