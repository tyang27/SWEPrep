import java.util.*;

class RangeSum {

  int[] RS;

  int getSum(int i) {
    int sum = 0;
    i++;
    while (i > 0) {
      sum += RS[i];
      i -= i & (-i);
    }
    return sum;
  }
  void update(int i, int val) {
    i++;
    while (i <= RS.length) {
      RS[i] += val;
      i += i & (-i);
    }
  }

  RangeSum(int[] nums) {
    RS = new int[nums.length+1];
    //for (int i=1; i <= nums.length; i++) RS[i] = 0;
    for (int i=0; i < nums.length; i++) update(i, nums[i]);
  }

  public static void main(String[] args) {
    int[] arr = {2,1,1,3,2,3,4,5,6,7,8,9};

    RangeSum rs = new RangeSum(arr);
    System.out.println(rs.getSum(5));
  }
}
