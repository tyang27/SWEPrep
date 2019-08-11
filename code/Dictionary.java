import java.util.*;

class Dictionary {
  List<List<Pair>> dictionary;
  int capacity;

  class Pair {
    public int key;
    public String value;
    public Pair(int key, String value) { this.key = key; this.value = value; }
  }

  public int hash(int key) {
    return Math.abs(key) % capacity;
  }

  public Dictionary(int capacity) {
    this.capacity = capacity;
    this.dictionary = new ArrayList<>(capacity);
    for (int i=0; i < capacity; i++) dictionary.add(new ArrayList<Pair>());
  }


  public String get(int key) {
    for (Pair p : dictionary.get(hash(key))) {
      if (p.key == key)
        return p.value;
    }
    return null;
  }

  public void put(int key, String value) {
    int hashVal = hash(key);
    List<Pair> entries = dictionary.get(hashVal);

    for (Pair p : entries) {
      if (p.key == key) {
        p.value = value;
        return;
      }
    }
    
    dictionary.get(hash(key)).add(new Pair(key, value));
  }

  public static void main(String[] args) {
    Dictionary d = new Dictionary(10);
    d.put(0, "a");
    d.put(10, "b");
    d.put(-10, "c");
    d.put(2, "d");
    assert d.get(-10).equals("c");
    assert d.get(0).equals("a");
    assert d.get(10).equals("b");

    assert d.get(3) == null;

    assert d.get(2).equals("d");
    d.put(2, "a");
    assert d.get(2).equals("a");
  }
}
