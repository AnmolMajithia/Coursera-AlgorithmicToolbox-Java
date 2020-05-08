import java.util.Scanner;

class W1_APlusB {
    static int sumOfTwoDigits(int first_digit, int second_digit) {
        return first_digit + second_digit;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        long startTime = System.nanoTime();
        System.out.println(sumOfTwoDigits(a, b));
        long totalTime = System.nanoTime() - startTime;
        System.out.println(totalTime/1000000 + "ms");
    }
}