import java.util.*;

class CountSort {
  public static void mySort(int[] A) {
    if (A.length == 0) return;
    int min, max;
    max = Arrays.stream(A).max().getAsInt();
    min = Arrays.stream(A).min().getAsInt();
    int[] counts = new int[max - min + 1];
    for (int i : A) counts[i - min]++;

    int j = 0;
    for (int i = 0; i < A.length; i++) {
      while (counts[j] == 0) j++;
      A[i] = min + j;
      counts[j]--;
    }
  }

  public static void main(String[] args) {
    int[] arr = {5, 5, 4, 2, 1};
    mySort(arr);
    System.out.println(Arrays.toString(arr));
  }
}
