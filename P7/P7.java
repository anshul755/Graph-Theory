package P7;

import java.util.List;

public class P7 {
    private static final int USER_COUNT = 20;
    private static final double EDGE_DENSITY = 0.4;
    private static final int KARGER_ITERATIONS = 100;

    public static void main(String[] args) {
        try {
            Graph graph = buildGraph();
            showGraph(graph);
            analyzeGraph(graph);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static Graph buildGraph() throws Exception {
        GitHubUserService userService = new GitHubUserService();
        GraphGenerator graphGenerator = new GraphGenerator();

        List<User> users = userService.fetchUsers(USER_COUNT);
        List<Edge> edges = graphGenerator.generateCommunityEdges(users.size(), EDGE_DENSITY);

        return new Graph(users, edges);
    }

    private static void showGraph(Graph graph) {
        GraphPrinter printer = new GraphPrinter();
        printer.print(graph);
    }

    private static void analyzeGraph(Graph graph) {
        GraphAnalyzer analyzer = new GraphAnalyzer();

        printArticulationPoints(analyzer.findArticulationPoints(graph));
        printBridges(graph, analyzer.findBridges(graph));
        System.out.println("\nKarger Min Cut: " + analyzer.findKargerMinCut(graph, KARGER_ITERATIONS));
    }

    private static void printArticulationPoints(List<User> articulationPoints) {
        System.out.println("\nArticulation Points\n");
        if (articulationPoints.isEmpty()) {
            System.out.println("None");
            return;
        }

        for (User user : articulationPoints) {
            System.out.println(user.getName());
        }
    }

    private static void printBridges(Graph graph, List<Edge> bridges) {
        System.out.println("\nBridges\n");
        if (bridges.isEmpty()) {
            System.out.println("None");
            return;
        }

        for (Edge edge : bridges) {
            String first = graph.getUsers().get(edge.getU()).getName();
            String second = graph.getUsers().get(edge.getV()).getName();
            System.out.println(first + " - " + second);
        }
    }
}
