import java.util.*;

class SelectionSort {
  public static boolean compare(int a, int b) {
    // Flip sign if descending.
    return a > b;
  }

  public static void swap(int[] A, int i, int j) {
    int temp = A[i];
    A[i] = A[j];
    A[j] = temp;
  }

  public static void mySort(int[] A) {
    // Cursor iterates through array.
    for (int cursor = 0; cursor < A.length-1; cursor++) {

      // Find the next smallest element right of cursor.
      int minIndex = cursor;
      for (int rightIndex=cursor+1; rightIndex < A.length; rightIndex++) {
        if (compare(A[minIndex], A[rightIndex])) minIndex = rightIndex;
      }
      
      // Swap cursor and min.
      if (minIndex != cursor) swap(A, cursor, minIndex);
    }
  }

  public static void main(String[] args) {
    int[] arr = {5, 4, 3, 2, 1};
    mySort(arr);
    System.out.println(Arrays.toString(arr));
  }
}
