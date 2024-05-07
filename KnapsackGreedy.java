import java.util.Arrays;

public class KnapsackGreedy {

    public static int knapsackGreedy(int capacity, int[] values, int[] weights) {
        int n = values.length;
        int[] ratios = new int[n];

        // Calculate value per unit weight ratios
        for (int i = 0; i < n; i++) {
            ratios[i] = values[i] / weights[i];
        }

        // Sort items based on value per unit weight ratios
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (ratios[i] < ratios[j]) {
                    int temp = ratios[i];
                    ratios[i] = ratios[j];
                    ratios[j] = temp;

                    temp = values[i];
                    values[i] = values[j];
                    values[j] = temp;

                    temp = weights[i];
                    weights[i] = weights[j];
                    weights[j] = temp;
                }
            }
        }

        // Fill knapsack with items greedily
        int totalValue = 0;
        int remainingCapacity = capacity;

        for (int i = 0; i < n; i++) {
            if (remainingCapacity >= weights[i]) {
                totalValue += values[i];
                remainingCapacity -= weights[i];
            } else {
                // Take a fraction of the item to fill the knapsack completely
                totalValue += (double) values[i] / weights[i] * remainingCapacity;
                break;
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        int capacity = 50;
        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};

        long startTime = System.nanoTime(); // Start measuring time

        int maxValue = knapsackGreedy(capacity, values, weights);

        long endTime = System.nanoTime(); // Stop measuring time
        long executionTime = endTime - startTime; // Calculate execution time

        System.out.println("Maximum value that can be obtained: " + maxValue);
        System.out.println("Execution time: " + executionTime + " ns");
    }
}
