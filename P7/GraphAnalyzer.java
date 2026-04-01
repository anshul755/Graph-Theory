package P7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GraphAnalyzer {
    private final Random random = new Random();

    public List<User> findArticulationPoints(Graph graph) {
        int n = graph.size();
        int[] disc = new int[n];
        int[] low = new int[n];
        int[] parent = new int[n];
        boolean[] isArticulationPoint = new boolean[n];
        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);
        Arrays.fill(parent, -1);

        int[] time = {0};
        for (int i = 0; i < n; i++) {
            if (disc[i] == -1) {
                dfsArticulation(i, graph.getAdjacencyList(), disc, low, parent, isArticulationPoint, time);
            }
        }

        List<User> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (isArticulationPoint[i]) {
                result.add(graph.getUsers().get(i));
            }
        }

        return result;
    }

    private void dfsArticulation(int u, List<List<Integer>> adjacencyList, int[] disc, int[] low,
                                 int[] parent, boolean[] isArticulationPoint, int[] time) {
        int children = 0;
        disc[u] = low[u] = ++time[0];

        for (int v : adjacencyList.get(u)) {
            if (disc[v] == -1) {
                children++;
                parent[v] = u;
                dfsArticulation(v, adjacencyList, disc, low, parent, isArticulationPoint, time);
                low[u] = Math.min(low[u], low[v]);

                if (parent[u] == -1 && children > 1) {
                    isArticulationPoint[u] = true;
                }
                if (parent[u] != -1 && low[v] >= disc[u]) {
                    isArticulationPoint[u] = true;
                }
            } else if (v != parent[u]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    public List<Edge> findBridges(Graph graph) {
        int n = graph.size();
        int[] disc = new int[n];
        int[] low = new int[n];
        int[] parent = new int[n];
        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);
        Arrays.fill(parent, -1);

        int[] time = {0};
        List<Edge> bridges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (disc[i] == -1) {
                dfsBridges(i, graph.getAdjacencyList(), disc, low, parent, time, bridges);
            }
        }

        return bridges;
    }

    private void dfsBridges(int u, List<List<Integer>> adjacencyList, int[] disc, int[] low,
                            int[] parent, int[] time, List<Edge> bridges) {
        disc[u] = low[u] = ++time[0];

        for (int v : adjacencyList.get(u)) {
            if (disc[v] == -1) {
                parent[v] = u;
                dfsBridges(v, adjacencyList, disc, low, parent, time, bridges);
                low[u] = Math.min(low[u], low[v]);

                if (low[v] > disc[u]) {
                    bridges.add(new Edge(u, v));
                }
            } else if (v != parent[u]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    public int findKargerMinCut(Graph graph, int iterations) {
        int best = Integer.MAX_VALUE;
        for (int i = 0; i < iterations; i++) {
            best = Math.min(best, runKarger(graph));
        }
        return best;
    }

    private int runKarger(Graph graph) {
        int[] parent = new int[graph.size()];
        for (int i = 0; i < graph.size(); i++) {
            parent[i] = i;
        }

        int components = graph.size();
        while (components > 2) {
            Edge edge = graph.getEdges().get(random.nextInt(graph.getEdges().size()));
            int a = find(parent, edge.getU());
            int b = find(parent, edge.getV());

            if (a != b) {
                parent[b] = a;
                components--;
            }
        }

        int cut = 0;
        for (Edge edge : graph.getEdges()) {
            if (find(parent, edge.getU()) != find(parent, edge.getV())) {
                cut++;
            }
        }

        return cut;
    }

    private int find(int[] parent, int node) {
        while (parent[node] != node) {
            node = parent[node];
        }
        return node;
    }
}
