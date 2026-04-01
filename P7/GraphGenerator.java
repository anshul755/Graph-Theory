package P7;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GraphGenerator {
    private final Random random = new Random();

    public List<Edge> generateCommunityEdges(int vertices, double density) {
        List<Edge> edges = new ArrayList<>();
        int half = vertices / 2;

        connectFirstCommunity(edges, half, density);
        connectSecondCommunity(edges, half, vertices, density);
        addBridgeEdges(edges, half, vertices);

        return edges;
    }

    private void connectFirstCommunity(List<Edge> edges, int half, double density) {
        for (int i = 0; i < half; i++) {
            for (int j = i + 1; j < half; j++) {
                if (random.nextDouble() < density) {
                    edges.add(new Edge(i, j));
                }
            }
        }
    }

    private void connectSecondCommunity(List<Edge> edges, int half, int vertices, double density) {
        for (int i = half; i < vertices; i++) {
            for (int j = i + 1; j < vertices; j++) {
                if (random.nextDouble() < density) {
                    edges.add(new Edge(i, j));
                }
            }
        }
    }

    private void addBridgeEdges(List<Edge> edges, int half, int vertices) {
        int bridges = 1 + random.nextInt(2);

        for (int i = 0; i < bridges; i++) {
            int u = random.nextInt(half);
            int v = half + random.nextInt(vertices - half);
            edges.add(new Edge(u, v));
        }
    }
}
