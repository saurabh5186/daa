import java.util.Scanner;

public class Knapsack01 {
    
    // Function to solve the 0-1 Knapsack problem using dynamic programming
    public static int knapSack(int capacity, int[] weights, int[] values, int n) {
        int[][] dp = new int[n + 1][capacity + 1];

        // Build the DP table
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capacity; w++) {
                if (weights[i - 1] <= w) {
                    // Item can be included
                    dp[i][w] = Math.max(dp[i - 1][w], values[i - 1] + dp[i - 1][w - weights[i - 1]]);
                } else {
                    // Item cannot be included
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][capacity]; // Return the maximum value that can be obtained
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of items: ");
        int n = scanner.nextInt();
        
        int[] weights = new int[n];
        int[] values = new int[n];

        System.out.println("Enter the weights and values of the items:");
        for (int i = 0; i < n; i++) {
            System.out.print("Weight of item " + (i + 1) + ": ");
            weights[i] = scanner.nextInt();
            System.out.print("Value of item " + (i + 1) + ": ");
            values[i] = scanner.nextInt();
        }

        System.out.print("Enter the capacity of the knapsack(Weight): ");
        int capacity = scanner.nextInt();
        scanner.close();

        int maxValue = knapSack(capacity, weights, values, n);
        System.out.println("Maximum value that can be obtained: " + maxValue);
    }
}
