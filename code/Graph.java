import java.util.*;

class GraphMatrix {
  public List<List<Integer>> g;
  public List<String> nodes;
  GraphMatrix(List<String> nodes) {
    this.nodes = nodes;
    g = new ArrayList<List<Integer>>(nodes.size());
    for (int i=0; i < nodes.size(); i++) {
      g.add(new ArrayList<Integer>(nodes.size()));
      for (int j = 0; j < nodes.size(); j++)
        g.get(i).add(-1);
    }
  }
  public void edge(String v1, String v2, int value) {
    g.get(nodes.indexOf(v1)).set(nodes.indexOf(v2), value);
  }
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int i=0; i < g.size(); i++) sb.append(nodes.get(i) + " ");
    sb.append("\n");
    for (int i=0; i < g.size(); i++) {
      sb.append(nodes.get(i) + ": ");
      for (int j = 0; j < g.size(); j++)
        sb.append(g.get(i).get(j) + " ");
      sb.append("\n");
    }
    return sb.toString();
  }
}

class GraphAdjacency {
  Map<Vertex, List<Vertex>> g;
  GraphAdjacency() { g = new HashMap<Vertex, List<Vertex>>(); }
  public Vertex vertex(String key, String val) {
    Vertex v = new Vertex(key, val);
    if (g.containsKey(v)) return null;
    g.put(v, new ArrayList<Vertex>());
    return v;
  }
  public void edge(Vertex v1, Vertex v2) {
    if (g.get(v1).contains(v2)) return;
    g.get(v1).add(v2);
  }
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (Map.Entry<Vertex, List<Vertex>> v1 : g.entrySet()) {
      sb.append(v1.getKey().key + " " + v1.getKey().val + ": ");
      for (Vertex v2 : v1.getValue()) sb.append(v2.key + "\t");
      sb.append("\n");
    }
    return sb.toString();
  }
}

class Vertex {
  public String key;
  public String val;
  Vertex(String key) { this.key=key; }
  Vertex(String key, String val) { this.key = key; this.val = val; }
  @Override
  public boolean equals(Object o) {
    return (this.key.equals(((Vertex) o).key));
  }
}

class Edge {
  Vertex v1, v2;
  String val;
  Edge(Vertex v1, Vertex v2, String val) { v1=v1; v2=v2; val=val; }
}

class Graph {
  public static void main(String[] args) {
    GraphMatrix gmat = new GraphMatrix(Arrays.asList("joe", "john", "jim", "joline"));
    gmat.edge("john", "jim", 3);
    gmat.edge("joline", "john", 2);
    gmat.edge("joline", "joe", 2);
    System.out.println(gmat.toString());
    
    GraphAdjacency gadj = new GraphAdjacency();
    Vertex joe = gadj.vertex("joe", "1000");
    Vertex john = gadj.vertex("john", "100");
    Vertex jim = gadj.vertex("jim", "10");
    Vertex joline = gadj.vertex("joline", "1");
    gadj.edge(joline, joe);
    gadj.edge(joline, john);
    gadj.edge(john, jim);
    System.out.println(gadj.toString());
  }
}
