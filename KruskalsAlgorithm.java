import java.util.*;

public class KruskalsAlgorithm {

    static int V;
    static int[][] adjMatrix;

    KruskalsAlgorithm(int v) {
        V = v;
        adjMatrix = new int[v][v];
    }

    public static void addEdge(int src, int dest, int weight) {
        adjMatrix[src][dest] = weight;
        adjMatrix[dest][src] = weight;
    }

    static int find(int[] parent, int i) {
        if (parent[i] == -1)
            return i;
        return find(parent, parent[i]);
    }

    static void union(int[] parent, int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);
        parent[xset] = yset;
    }

    static void kruskalMST() {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        for (int i = 0; i < V; ++i)
            for (int j = i + 1; j < V; ++j)
                if (adjMatrix[i][j] != 0)
                    pq.add(new int[]{i, j, adjMatrix[i][j]});

        int[] parent = new int[V];
        Arrays.fill(parent, -1);

        ArrayList<int[]> mst = new ArrayList<>();

        while (!pq.isEmpty()) {
            int[] edge = pq.remove();
            int x = find(parent, edge[0]);
            int y = find(parent, edge[1]);

            if (x != y) {
                mst.add(edge);
                union(parent, x, y);
            }
        }

        System.out.println("Edges in the MST:");
        for (int[] edge : mst)
            System.out.println(edge[0] + " - " + edge[1] + ": " + edge[2]);
    }

    public static void main(String[] args) {
        int V = 8;
        KruskalsAlgorithm graph = new KruskalsAlgorithm(V);

        // Adding edges
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 2);
        graph.addEdge(1, 2, 6);
        graph.addEdge(1, 3, 5);
        graph.addEdge(2, 3, 3);
        graph.addEdge(2, 4, 9);
        graph.addEdge(3, 5, 7);
        graph.addEdge(3, 6, 10);
        graph.addEdge(4, 5, 1);
        graph.addEdge(4, 6, 8);
        graph.addEdge(5, 7, 11);
        graph.addEdge(6, 7, 12);
        graph.addEdge(0, 5, 13);
        graph.addEdge(1, 4, 15);
        graph.addEdge(2, 7, 14);

        kruskalMST();
    }
}
