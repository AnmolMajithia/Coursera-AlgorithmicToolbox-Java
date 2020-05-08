import java.util.Scanner;

public class W3_FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        double[] unitValue = new double[values.length];
        for(int i = 0; i < values.length; i++) {
            unitValue[i] = (double)values[i]/(double)weights[i];
        }
        //Sorting
        for(int i = 0; i < unitValue.length-1; i++) {
            for(int j = 0; j < unitValue.length-i-1; j++) {
                if(unitValue[j] < unitValue[j+1]) {
                    double temp = unitValue[j];
                    unitValue[j] = unitValue[j+1];
                    unitValue[j+1] = temp;
                    temp = values[j];
                    values[j] = values[j+1];
                    values[j+1] = (int)temp;
                    temp = weights[j];
                    weights[j] = weights[j+1];
                    weights[j+1] = (int)temp;
                }
            }
        }
        int i = 0;
        int temp = 0;
        while(temp <= capacity && i < weights.length) {
            if(weights[i] <= (capacity-temp)){
                temp += weights[i];
                value += values[i];
            } else {
                value += unitValue[i]*(capacity-temp);
                break;
            }
            i++;
        }
        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
} 
