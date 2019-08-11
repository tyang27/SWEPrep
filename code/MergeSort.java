import java.util.*;

class MergeSort {
  public static boolean compare(int a, int b) {
    // Flip sign if descending.
    return a > b;
  }

  public static void merge(int[] A, int[] left, int[] right) {
    int l, r, i;
    i = l = r = 0;
    while (l < left.length || r < right.length) {
      if (l < left.length && r < right.length)
        A[i++] = compare(left[l], right[r]) ? right[r++] : left[l++];
      else if (l < left.length)
        A[i++] = left[l++];
      else if (r < right.length)
        A[i++] = right[r++];
    }
  }

  public static void mySort(int[] A) {
    if (A.length <= 1) return;

    int mid = A.length / 2;
    int[] left = new int[mid];
    int[] right = new int[A.length-mid];

    System.arraycopy(A, 0, left, 0, mid);
    System.arraycopy(A, mid, right, 0, A.length-mid);

    mySort(left);
    mySort(right);
    merge(A, left, right);
  }

  public static void main(String[] args) {
    int[] arr = {5, 5, 4, 3, 2, 1, 10};
    mySort(arr);
    System.out.println(Arrays.toString(arr));
  }
}
