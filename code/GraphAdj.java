import java.util.*;

class GraphAdj {

  class Edge {
    int dst;
    int weight;
    public Edge(int dst, int weight) { this.dst = dst; this.weight = weight; }
    @Override
    public boolean equals(Object obj) {
      if (obj == null) return false;
      if (!Edge.class.isAssignableFrom(obj.getClass())) return false;
      final Edge other = (Edge) obj;
      return other.dst == this.dst;
    }
  }

  Map<Integer, List<Edge>> edges;
  public GraphAdj(int n) {
    edges = new HashMap<>(n);
  }
  public void insertDirected(int v1, int v2, int weight) {
    if (edges.get(v1) == null) edges.put(v1, new ArrayList<Edge>());
    if (edges.get(v1).contains(new Edge(v2, -1))) {
      int index = edges.get(v1).indexOf(new Edge(v2, -1));
      edges.get(v1).set(index, new Edge(v2, weight));
      return;
    }
    edges.get(v1).add(new Edge(v2, weight));
  }
  public void insertUndirected(int v1, int v2, int weight) {
    insertDirected(v1, v2, weight);
    insertDirected(v2, v1, weight);
  }
  public int getWeight(int v1, int v2) {
    if (edges.get(v1) == null || !edges.get(v1).contains(new Edge(v2, -1))) return 0;
    int v2index = edges.get(v1).indexOf(new Edge(v2, -1));
    return edges.get(v1).get(v2index).weight;
  }

  public static void main(String args[]) {
    GraphAdj g = new GraphAdj(10);
    g.insertDirected(1, 2, 1);
    g.insertDirected(1, 2, 2);
    g.insertDirected(2, 1, 4);
    assert g.getWeight(1, 2) == 2;
    assert g.getWeight(2, 1) == 4;
    assert g.getWeight(3, 1) == 0;
  }
}
