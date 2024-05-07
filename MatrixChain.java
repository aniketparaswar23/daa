public class MatrixChain {

    public static int matrixMultiplication(int n, int a[]) {
        int dp[][] = new int[n][n];
        for (int len = 2; len < n; len++) {
            int col = len;
            for (int row = 0; row < n - len; row++) {
                dp[row][col] = Integer.MAX_VALUE;
                for (int k = row + 1; k < col; k++) {
                    dp[row][col] = Math.min(dp[row][col], dp[row][k] + dp[k][col] + a[row] * a[k] * a[col]);
                }
                col++;
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        // Sample input
        int n = 5;
        int[] dimensions = {10, 20, 30, 40, 30};

        long startTime = System.nanoTime(); // Start measuring time

        int minCost = matrixMultiplication(n, dimensions);

        long endTime = System.nanoTime(); // Stop measuring time
        long executionTime = endTime - startTime; // Calculate execution time

        // Output
        System.out.println("Minimum cost of matrix chain multiplication: " + minCost);
        System.out.println("Execution time: " + executionTime + " ns");
    }
}
