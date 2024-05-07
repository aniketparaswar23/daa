import java.util.*;

public class FifteenPuzzleBranchAndBound {

    static final int N = 4; // Size of the puzzle
    static final int[][] GOAL_STATE = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 0}}; // Goal state

    // Class to represent the puzzle state
    static class State {
        int[][] board;
        int cost;
        int blankX, blankY;

        public State(int[][] board, int cost, int blankX, int blankY) {
            this.board = board;
            this.cost = cost;
            this.blankX = blankX;
            this.blankY = blankY;
        }
    }

    // Function to check if two states are equal
    static boolean areEqual(int[][] a, int[][] b) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (a[i][j] != b[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    // Function to calculate the cost of a state
    static int calculateCost(int[][] board) {
        int cost = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] != 0 && board[i][j] != GOAL_STATE[i][j]) {
                    cost++;
                }
            }
        }
        return cost;
    }

    // Function to find the possible moves for the blank tile
    static ArrayList<State> findNeighbors(State curr) {
        ArrayList<State> neighbors = new ArrayList<>();
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Up, Down, Left, Right

        for (int[] dir : directions) {
            int newX = curr.blankX + dir[0];
            int newY = curr.blankY + dir[1];

            if (newX >= 0 && newX < N && newY >= 0 && newY < N) {
                int[][] newBoard = new int[N][N];
                for (int i = 0; i < N; i++) {
                    newBoard[i] = Arrays.copyOf(curr.board[i], N);
                }

                // Swap blank tile with the neighboring tile
                newBoard[curr.blankX][curr.blankY] = newBoard[newX][newY];
                newBoard[newX][newY] = 0;

                State newState = new State(newBoard, calculateCost(newBoard), newX, newY);
                neighbors.add(newState);
            }
        }

        return neighbors;
    }

    // Function to solve the 15 Puzzle problem using Branch and Bound
    static int solve15Puzzle(int[][] board) {
        PriorityQueue<State> pq = new PriorityQueue<>(Comparator.comparingInt(s -> s.cost));
        Set<String> visited = new HashSet<>();

        State initial = new State(board, calculateCost(board), 0, 0);
        pq.add(initial);

        while (!pq.isEmpty()) {
            State curr = pq.poll();
            visited.add(Arrays.deepToString(curr.board));

            if (areEqual(curr.board, GOAL_STATE)) {
                return curr.cost;
            }

            ArrayList<State> neighbors = findNeighbors(curr);
            for (State neighbor : neighbors) {
                if (!visited.contains(Arrays.deepToString(neighbor.board))) {
                    pq.add(neighbor);
                }
            }
        }

        return -1; // No solution found
    }

    public static void main(String[] args) {
        int[][] board = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 0, 14, 15}
        };

        long startTime = System.nanoTime(); // Start measuring time
        int minMoves = solve15Puzzle(board);
        long endTime = System.nanoTime(); // Stop measuring time

        if (minMoves == -1) {
            System.out.println("No solution exists!");
        } else {
            long executionTime = endTime - startTime; // Calculate execution time in nanoseconds
            System.out.println("Minimum number of moves to reach the goal state: " + minMoves);
            System.out.println("Execution time: " + executionTime + " ns");
        }
    }
}
