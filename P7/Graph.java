package P7;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private final List<User> users;
    private final List<Edge> edges;
    private final List<List<Integer>> adjacencyList;

    public Graph(List<User> users, List<Edge> edges) {
        this.users = users;
        this.edges = edges;
        this.adjacencyList = buildAdjacencyList(users.size(), edges);
    }

    private List<List<Integer>> buildAdjacencyList(int size, List<Edge> edgeList) {
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            adjacency.add(new ArrayList<>());
        }

        for (Edge edge : edgeList) {
            adjacency.get(edge.getU()).add(edge.getV());
            adjacency.get(edge.getV()).add(edge.getU());
        }

        return adjacency;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public List<List<Integer>> getAdjacencyList() {
        return adjacencyList;
    }

    public int size() {
        return users.size();
    }
}
