package P8;

import java.util.*;

public class P8 {

    static boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] color = new int[V];
        Arrays.fill(color, -1);

        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                color[i] = 0;

                while (!q.isEmpty()) {
                    int u = q.poll();

                    for (int v : adj.get(u)) {
                        if (color[v] == -1) {
                            color[v] = 1 - color[u];
                            q.add(v);
                        } else if (color[v] == color[u]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        if (V <= 4) {
            System.out.println("Graph is Planar");
            return;
        }

        boolean bip = isBipartite(V, adj);

        if (bip) {
            if (E <= 2 * V - 4)
                System.out.println("Graph is Planar");
            else
                System.out.println("Graph is NOT Planar");
        } else {
            if (E <= 3 * V - 6)
                System.out.println("Graph is Planar");
            else
                System.out.println("Graph is NOT Planar");
        }
    }
}