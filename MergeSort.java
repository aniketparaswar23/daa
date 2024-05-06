class MergeSort {
    public static void merge(int arr[], int si, int mid, int ei) {
        int temp[] = new int[ei - si + 1];
        int p = 0;
        int index1 = si;
        int index2 = mid + 1;
        while (index1 <= mid && index2 <= ei) {
            if (arr[index1] <= arr[index2])
                temp[p++] = arr[index1++];
            else
                temp[p++] = arr[index2++];
        }
        while (index1 <= mid) {
            temp[p++] = arr[index1++];
        }
        while (index2 <= ei) {
            temp[p++] = arr[index2++];
        }

        for (int i = 0, j = si; i < temp.length; i++, j++) {
            arr[j] = temp[i];
        }
    }

    public static void mergesort(int arr[], int si, int ei) {
        if (si >= ei)
            return;
        int mid = si + (ei - si) / 2;
        mergesort(arr, si, mid);
        mergesort(arr, mid + 1, ei);
        merge(arr, si, mid, ei);
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(" ");
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (end <= start)
            return;
        int pivot = partition(arr, start, end);
        quickSort(arr, start, pivot - 1);
        quickSort(arr, pivot + 1, end);
    }

    public static int partition(int[] arr, int start, int end) {
        int i = start - 1;
        int p = arr[end];
        for (int j = start; j <= end - 1; j++) {
            if (arr[j] < p) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = arr[end];
        arr[end] = temp;
        return i;
    }

    public static void swap(int arr[], int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis(); // Record start time

        int arr1[] = {90, 10, 30, 60, 50, 40, 100, 70, 20, 80};
        int n = 10;

        System.out.println("\nMerge Sort");
        System.out.print("before - ");
        printArr(arr1);
        mergesort(arr1, 0, n - 1);
        System.out.print("after -  ");
        printArr(arr1);

        long endTime = System.currentTimeMillis(); // Record end time
        long executionTime = endTime - startTime; // Calculate execution time
        System.out.println("Execution Time: " + executionTime + " milliseconds");
    }
}
