import java.util.*;

class Permute {
  public static void swap(int[] A, int i, int j) {
    int temp = A[i];
    A[i] = A[j];
    A[j] = temp;
  }

  static List<int[]> permutations = new ArrayList<>();
  public static void permute(int[] A, int low, int high) {
    if (low == high) {
      permutations.add(Arrays.copyOf(A, A.length));
      return;
    }
    for (int curr = low; curr <= high; curr++) {
      swap(A, low, curr);
      permute(A, low+1, high);
      swap(A, curr, low);
    }
  }

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5};
    permute(arr, 0, arr.length-1);
    assert permutations.size() == 120; //5!
    for (int[] p : permutations)
      System.out.println(Arrays.toString(p));
  }
}
