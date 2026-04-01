package P7;

import java.util.ArrayList;
import java.util.List;

public class GraphPrinter {
    public void print(Graph graph) {
        printUsers(graph.getUsers());
        printFriendships(graph);
        printAdjacencyList(graph);
    }

    private void printUsers(List<User> users) {
        System.out.println("\nUsers\n");
        for (User user : users) {
            System.out.println(user.getId() + " : " + user.getName() + " (" + user.getCity() + ")");
        }
    }

    private void printFriendships(Graph graph) {
        System.out.println("\nFriendships\n");
        for (Edge edge : graph.getEdges()) {
            User first = graph.getUsers().get(edge.getU());
            User second = graph.getUsers().get(edge.getV());
            System.out.println(first.getName() + " - " + second.getName());
        }
    }

    private void printAdjacencyList(Graph graph) {
        System.out.println("\nAdjacency List\n");
        for (int i = 0; i < graph.size(); i++) {
            List<String> friends = new ArrayList<>();
            for (int neighbor : graph.getAdjacencyList().get(i)) {
                friends.add(graph.getUsers().get(neighbor).getName());
            }

            String friendNames = friends.isEmpty() ? "none" : String.join(", ", friends);
            System.out.println(graph.getUsers().get(i).getName() + " -> " + friendNames);
        }
    }
}
