import java.util.*;

class UnionFind {
  int num_nodes;
  int[] rank, nodes;

  public UnionFind(int n) {
    this.num_nodes = n;
    this.rank = new int[n];
    this.nodes = new int[n];
  }

  public void create(int x) {
    nodes[x] = x;
    rank[x] = 0;
  }

  public int find(int x) {
    if (x != nodes[x]) nodes[x] = find(nodes[x]);
    return nodes[x];
  }
  
  public boolean connected(int x, int y) { return find(x) == find(y); }

  public void merge(int x, int y) {
    int parent_x = find(x);
    int parent_y = find(y);
    if (rank[parent_x] > rank[parent_y]) {
      nodes[parent_y] = parent_x;
    } else if (rank[parent_x] < rank[parent_y]) {
      nodes[parent_x] = parent_y;
    } else {
      nodes[parent_x] = parent_y;
      rank[parent_y]++;
    }
  }

  public static void main(String[] args) {
    UnionFind ds = new UnionFind(10);
    ds.create(1);
    ds.create(2);
    ds.merge(1, 2);
    assert ds.find(1) == 2;
    assert ds.find(2) == 2;

    ds.create(3);
    ds.merge(1, 3);
    assert ds.find(3) == 2;

    ds.create(4);
    ds.create(5);

    ds.create(6);
    ds.create(7);
    ds.create(8);
    ds.create(9);
    ds.merge(6, 7);
    ds.merge(7, 8);
    ds.merge(8, 9);
    assert ds.find(6) == 7;
    assert ds.find(7) == 7;
    assert ds.find(8) == 7;
    assert ds.find(9) == 7;

    ds.merge(9, 3);
    assert ds.find(8) == 2;
  }
}
