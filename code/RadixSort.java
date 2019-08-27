import java.util.*;

class RadixSort {

  public static final int BUCKETS = 27;
  public static final int MAX_LEN = 5;

  public static void mySort(String[] S) {

    for (int i = 0; i < MAX_LEN; i++) {
      // Initialize buckets
      List<List<String>> B = new ArrayList<>(BUCKETS);
      for (int b = 0; b < BUCKETS; b++)
        B.add(new ArrayList<>());

      // Count sort by MAX_LEN-1-i;
      for (String s : S)
        B.get(mapping(s, MAX_LEN - 1- i)).add(s);

      // Unpack
      for (int b = 0, unpacker = 0; b < BUCKETS; b++)
        for (String s : B.get(b))
          S[unpacker++] = s;
    }
  }

  public static int mapping(String s, int i) {
    return (int) s.charAt(i) - (int) '`';
  }

  public static void main(String[] args) {
    String[] arr = {"```jt", "``and", "````I", "``are", "going",
      "```to", "Spain", "``and", "``its", "going", "```to", "```be",
      "````a", "blast"};
    int maxStrLen = Arrays.stream(arr)
      .map((x) -> x.length())
      .max(Integer::compareTo)
      .get();
    arr = Arrays.stream(arr)
      .map((x) -> x.toLowerCase())
      .toArray(String[]::new);

    mySort(arr);
    System.out.println(Arrays.toString(arr));
  }
}
