import java.util.*;

public class W5_PrimitiveCalculator {
    private static List<Integer> optimal_sequence(int n) {
        int[] arr = new int[n+1];
        arr[1] = 1;
        for(int i = 2; i <= n; i++) {
            arr[i] = arr[i-1] + 1;
            if(i%2 == 0) {
                arr[i] = Math.min(arr[i/2] + 1, arr[i]);
            }
            if(i%3 == 0) {
                arr[i] = Math.min(arr[i/3] + 1, arr[i]);
            }
        }

        List<Integer> sequence = new ArrayList<>();
        int i = n;
        while (i >= 1) {
            sequence.add(i);
            if(arr[i - 1] == arr[i] - 1) {
                i--;
            }
            else if (i % 2 == 0 && arr[i/2] == arr[i] - 1) {
                i /= 2;
            }
            else if (i % 3 == 0 && arr[i/3] == arr[i] - 1) {
                i /= 3;
            }
        }
        Collections.reverse(sequence);
        return sequence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}

