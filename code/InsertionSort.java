import java.util.*;

class InsertionSort {
  public static boolean compare(int a, int b) {
    // Flip sign if descending.
    return a > b;
  }

  public static void mySort(int[] A) {

    // Cursor iterates through array.
    for (int cursor=1; cursor < A.length; cursor++) {
      int insertor = cursor - 1;
      int cursorVal = A[cursor];

      // Iterate through sorted portion of array, pushing
      // elements back.
      while (insertor >= 0 && compare(A[insertor], cursorVal)) {
        A[insertor+1] = A[insertor];
        insertor--;
      }
      
      // Once location is found, insert it.
      A[insertor+1] = cursorVal;
    }
  }

  public static void main(String[] args) {
    int[] arr = {5, 4, 3, 2, 1};
    mySort(arr);
    System.out.println(Arrays.toString(arr));
  }
}
