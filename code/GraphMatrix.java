import java.util.*;

class GraphMatrix {
  int[][] edges;

  public GraphMatrix(int n) {
    edges = new int[n][n];
  }
  public void insertDirected(int v1, int v2, int weight) {
    edges[v1][v2] = weight;
  }
  public void insertUndirected(int v1, int v2, int weight) {
    insertDirected(v1, v2, weight);
    insertDirected(v2, v1, weight);
  }

  public static void main(String args[]) {
    GraphMatrix g = new GraphMatrix(10);
    g.insertDirected(1, 2, 1);
    for (int[] e : g.edges) {
      for (int i : e) System.out.print(i + " ");
      System.out.println();
    }
  }
}
