import java.util.*;

class QuickSelect {
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

  public static int mySearch(int[] A, int k, int low, int high) {
    if (high == low) return A[low];
    int pivot = partition(A, low, high);
    if (pivot > k)
      return mySearch(A, k, low, pivot-1);
    else if (pivot < k)
      return mySearch(A, k, pivot+1, high);
    else
      return A[pivot];
  }

  public static void main(String[] args) {
    int[] arr = {2, 3, 5, 4, 1, 10, 8, 4, 7};
    int order1 = mySearch(arr, 5, 0, arr.length-1);
    System.out.println(order1);
  }
}
