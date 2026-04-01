package P6;

import java.util.*;

public class P6b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the no. of edges: ");
        int edgesCount = sc.nextInt();
        int verticesCount = edgesCount + 1;

        List<Set<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= verticesCount; i++) {
            adj.add(new HashSet<>());
        }

        int[] degree = new int[verticesCount + 1];

        System.out.println("Enter the edges (u v):");
        for (int i = 0; i < edgesCount; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            if (u < 1 || u > verticesCount || v < 1 || v > verticesCount) {
                System.out.println("Invalid vertex label. Vertices should be between 1 and " + verticesCount);
                return;
            }

            adj.get(u).add(v);
            adj.get(v).add(u);
            degree[u]++;
            degree[v]++;
        }

        PriorityQueue<Integer> leaves = new PriorityQueue<>();
        for (int i = 1; i <= verticesCount; i++) {
            if (degree[i] == 1) {
                leaves.add(i);
            }
        }

        List<Integer> pruferCode = new ArrayList<>();

        for (int i = 0; i < verticesCount - 2; i++) {
            if (leaves.isEmpty()) break;

            int leaf = leaves.poll();
            int neighbor = -1;
            for (int n : adj.get(leaf)) {
                neighbor = n;
            }

            adj.get(neighbor).remove(leaf);

            pruferCode.add(neighbor);

            degree[neighbor]--;
            if (degree[neighbor] == 1) {
                leaves.add(neighbor);
            }
        }

        System.out.print("The Pruefer code is: { ");
        for (int i = 0; i < pruferCode.size(); i++) {
            System.out.print(pruferCode.get(i) + (i < pruferCode.size() - 1 ? ", " : ""));
        }
        System.out.println(" }");

        /*
         * 8
         * 2 6
         * 5 6
         * 6 4
         * 4 1
         * 1 8
         * 3 4
         * 3 7
         * 3 9
         */

    }
}
