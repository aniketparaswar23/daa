import java.util.Arrays;

public class PrimsAlgorithm {

    static void primMST(int graph[][]) {
        long startTime = System.currentTimeMillis(); // Record start time
        
        int V = graph.length;
        int[] parent = new int[V];
        int[] key = new int[V];
        boolean[] mstSet = new boolean[V];

        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        key[0] = 0;

        for (int count = 0; count < V - 1; count++) {
            int u = minKey(key, mstSet);

            mstSet[u] = true;

            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        printMST(parent, graph);
        
        long endTime = System.currentTimeMillis(); // Record end time
        long executionTime = endTime - startTime; // Calculate execution time
        System.out.println("Execution Time: " + executionTime + " milliseconds");
    }

    static int minKey(int[] key, boolean[] mstSet) {
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < key.length; v++)
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                min_index = v;
            }

        return min_index;
    }

    static void printMST(int parent[], int graph[][]) {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < graph.length; i++)
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
    }

    public static void main(String[] args) {
        int graph[][] = new int[][]{{0, 2, 0, 6, 0},
                                    {2, 0, 3, 8, 5},
                                    {0, 3, 0, 0, 7},
                                    {6, 8, 0, 0, 9},
                                    {0, 5, 7, 9, 0}};

        primMST(graph);
    }
}
