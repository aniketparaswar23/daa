import java.util.Scanner;

public class lcs {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis(); // Record start time

        Scanner sc = new Scanner(System.in);

        String s1 = "aniketparaswar";
        String s2 = "ntasrin";

        int col = s1.length();
        int row = s2.length();

        int matrix[][] = new int[row + 2][col + 2];

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (s1.charAt(j - 1) == s2.charAt(i - 1)) {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                } else {
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i][j - 1]);
                }
            }
        }
        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= col; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
        int lcsLength = matrix[row][col];
        char[] lcs = new char[lcsLength];
        int i = row, j = col;
        int index = lcsLength - 1;
        while (i > 0 && j > 0) {
            if (s1.charAt(j - 1) == s2.charAt(i - 1)) {
                lcs[index] = s1.charAt(j - 1);
                index--;
                i--;
                j--;
            } else if (matrix[i - 1][j] > matrix[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        System.out.print("Longest Common Subsequence: ");
        for (char c : lcs) {
            System.out.print(c);
        }

        long endTime = System.currentTimeMillis(); // Record end time
        long executionTime = endTime - startTime; // Calculate execution time
        System.out.println("\nExecution Time: " + executionTime + " milliseconds");
    }
}
