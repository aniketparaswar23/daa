public class AssemblyLineScheduling {

    public static int carAssembly(int[][] a, int[][] t, int[] e, int[] x) {
        int n = a[0].length;

        // Time taken to reach each station on line 1 and line 2
        int[] f1 = new int[n];
        int[] f2 = new int[n];

        // Time taken to exit from each station on line 1 and line 2
        int[] L1 = new int[n];
        int[] L2 = new int[n];

        f1[0] = e[0] + a[0][0];
        f2[0] = e[1] + a[1][0];

        for (int i = 1; i < n; i++) {
            f1[i] = Math.min(f1[i - 1] + a[0][i], f2[i - 1] + t[1][i] + a[0][i]);
            f2[i] = Math.min(f2[i - 1] + a[1][i], f1[i - 1] + t[0][i] + a[1][i]);
        }

        L1[n - 1] = f1[n - 1] + x[0];
        L2[n - 1] = f2[n - 1] + x[1];

        for (int i = n - 2; i >= 0; i--) {
            L1[i] = Math.min(L1[i + 1] + a[0][i], L2[i + 1] + t[1][i] + a[0][i]);
            L2[i] = Math.min(L2[i + 1] + a[1][i], L1[i + 1] + t[0][i] + a[1][i]);
        }

        return Math.min(L1[0], L2[0]);
    }

    public static void main(String[] args) {
        int[][] a = {{4, 5, 3, 2}, {2, 10, 1, 4}};
        int[][] t = {{0, 7, 4, 5}, {0, 9, 2, 8}};
        int[] e = {10, 12};
        int[] x = {18, 7};

        System.out.println("Minimum time: " + carAssembly(a, t, e, x));
    }
}
