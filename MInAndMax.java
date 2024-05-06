public class MInAndMax {

    static class Pair {
        int min;
        int max;

        public Pair(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }

    public static Pair findMinMax(int[] arr, int low, int high) {
        if (low == high) {
            return new Pair(arr[low], arr[low]);
        } else if (high - low == 1) {
            if (arr[low] < arr[high]) {
                return new Pair(arr[low], arr[high]);
            } else {
                return new Pair(arr[high], arr[low]);
            }
        } else {
            int mid = (low + high) / 2;
            Pair leftPair = findMinMax(arr, low, mid);
            Pair rightPair = findMinMax(arr, mid + 1, high);

            int min = Math.min(leftPair.min, rightPair.min);
            int max = Math.max(leftPair.max, rightPair.max);

            return new Pair(min, max);
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 10, 6, 8, 12, 7, 15, 5, 9, 14};

        Pair result = findMinMax(arr, 0, arr.length - 1);

        System.out.println("Minimum element: " + result.min);
        System.out.println("Maximum element: " + result.max);
    }
}
