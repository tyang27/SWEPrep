import java.util.*;

class QuickSort {
  public static boolean compare(int a, int b) {
    // Flip sign if descending.
    return a > b;
  }

  public static void swap(int[] A, int i, int j) {
    int temp = A[i];
    A[i] = A[j];
    A[j] = temp;
  }

  public static int partition(int[] A, int low, int high) {
    // Partition scheme uses A[high] as pivot, assume shuffled data.
    int lessThan = low-1;
    int curr = low;
    for (; curr < high; curr++) {
      if (A[curr] <= A[high]) {
        swap(A, ++lessThan, curr);
      }
    }
    swap(A, ++lessThan, high);
    return lessThan;
  }

  public static void mySort(int[] A, int low, int high) {
    if (high < low) return;
    int pivot = partition(A, low, high);
    mySort(A, low, pivot-1);
    mySort(A, pivot+1, high);
  }

  public static void main(String[] args) {
    int[] arr = {2, 3, 5, 4, 1, 10, 8, 4, 7};
    mySort(arr, 0, arr.length-1);
    System.out.println(Arrays.toString(arr));
  }
}
