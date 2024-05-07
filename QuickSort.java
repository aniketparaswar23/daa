import java.util.Scanner;

public class QuickSort {

    public static void quickSort(int[] arr, int lb, int ub) {
        
        
        if (lb < ub) {
            int pivot = arr[lb];
            int start = lb + 1;
            int end = ub;
            while (start <= end) {
                while (start <= end && arr[start] < pivot) {
                    start++;
                }
                while (end >= start && arr[end] >= pivot) {
                    end--;
                }
                if (start < end) {
                    swap(arr, start, end);
                }
            }
            swap(arr, lb, end);
            quickSort(arr, lb, end - 1);
            quickSort(arr, end + 1, ub);
        }
        
        
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis(); // Record start time
        Scanner sc=new Scanner(System.in);
        
        

        printArr(arr);
        quickSort(arr, 0, n-1);
        printArr(arr);
        long endTime = System.currentTimeMillis(); // Record end time
        long executionTime = endTime - startTime; // Calculate execution time
        System.out.println("Execution Time: " + executionTime + " milliseconds");
    }
}
