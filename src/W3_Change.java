import java.util.Scanner;

public class W3_Change {
    private static int getChange(int m) {
        int coins = 0;
        while(m > 0) {
            coins ++;
            if(m >= 10) {
                m -= 10;
            }
            else if(m >= 5) {
                m -= 5;
            }
            else {
                m -= 1;
            }
        }
        return coins;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

