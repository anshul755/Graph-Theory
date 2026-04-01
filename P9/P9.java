package P9;

import java.util.*;

public class P9 {

    static boolean isSafe(int v, int[][] graph, int[] color, int c, int V) {
        for (int i = 0; i < V; i++) {
            if (graph[v][i] == 1 && color[i] == c) {
                return false;
            }
        }
        return true;
    }

    static boolean solve(int v, int[][] graph, int[] color, int m, int V) {
        if (v == V)
            return true;

        for (int c = 1; c <= m; c++) {
            if (isSafe(v, graph, color, c, V)) {
                color[v] = c;

                if (solve(v + 1, graph, color, m, V)) return true;

                color[v] = 0;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E = sc.nextInt();
        int m = sc.nextInt();

        int[][] graph = new int[V][V];

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;

            graph[u][v] = 1;
            graph[v][u] = 1;
        }

        int[] color = new int[V];

        if (solve(0, graph, color, m, V)) {
            System.out.println("Solution exists");
            for (int i = 0; i < V; i++) {
                System.out.println("Vertex " + (i + 1) + " -> Color " + color[i]);
            }
        } else {
            System.out.println("No solution exists");
        }
    }
}