import java.util.*;

class NextPermutation {
  static void swap(int[] A, int i, int j) {
    int tmp = A[i]; A[i] = A[j]; A[j] = tmp;
  }

  static void reverse(int[] A, int start, int end) {
    while (start < end) swap(A, start++, end--);
  }

  static int[] nextPermutation(int[] A) {
    if (A.length <= 1) return A;

    int last = A.length - 2;
    while (last >= 0) {
      if (A[last] < A[last + 1]) break;
      last--;
    }
    if (last == -1) return A;

    int nextGreater = A.length - 1;
    for (int i = A.length - 1; i > last; i--) {
      if (A[i] > A[last]) {
        nextGreater = i;
        break;
      }
    }

    swap(A, nextGreater, last);
    reverse(A, last+1, A.length-1); //suffix

    return A;
  }

  public static void main(String[] args) {
    int[] A = new int[] {1, 2, 3, 4};
    int i = 0;
    while (i < 4 * 3 * 2) {
      System.out.println(Arrays.toString(nextPermutation(A)));
      i++;
    }
  }
}
