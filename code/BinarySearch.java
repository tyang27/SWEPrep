import java.util.*;

class BinarySearch {

  public static int mySearch(int[] A, int key, int low, int high) {
    if (high < low) {
      return -1;
    }
    int mid = low + (high - low)/2;
    if (A[mid] == key)
      return mid;
    else if (A[mid] < key)
      return mySearch(A, key, low, mid-1);
    else
      return mySearch(A, key, mid+1, high);
  }

  public static void main(String[] args) {
    int[] arr = {1, 4, 9, 16, 25, 36};
    int index = mySearch(arr, 9, 0, arr.length-1);
    assert index == 2;
    index = mySearch(arr, 36, 0, arr.length-1);
    assert index == 5;
    index = mySearch(arr, 1, 0, arr.length-1);
    assert index == 0;
    index = mySearch(arr, 26, 0, arr.length-1);
    assert index == -1;
  }
}
