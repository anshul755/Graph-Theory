package P3;

import java.util.*;

public class P3 {

    static class Edge {
        int src, dest;

        Edge(int s, int d) {
            src = s;
            dest = d;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Edge))
                return false;
            Edge e = (Edge) o;
            return src == e.src && dest == e.dest;
        }

        @Override
        public int hashCode() {
            return Objects.hash(src, dest);
        }

        public String toString() {
            return "(" + src + "->" + dest + ")";
        }
    }

    private static void createGraph(List<List<Edge>> graph, int v, Scanner sc) {
        graph.clear();
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < v; i++) {
            System.out.print("Enter neighbours count for vertex " + i + ": ");
            int n = sc.nextInt();
            for (int j = 0; j < n; j++) {
                System.out.print("Enter destination vertex: ");
                int d = sc.nextInt();
                graph.get(i).add(new Edge(i, d));
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<List<Edge>> G1 = new ArrayList<>();
        List<List<Edge>> G2 = new ArrayList<>();

        System.out.print("Enter number of vertices of G1: ");
        int v1 = sc.nextInt();
        System.out.println("---- Enter Graph 1 ----");
        createGraph(G1, v1, sc);

        System.out.print("Enter number of vertices of G2: ");
        int v2 = sc.nextInt();
        System.out.println("---- Enter Graph 2 ----");
        createGraph(G2, v2, sc);

        if (v1 != v2) {
            System.out.println("Not Isomorphic graphs");
        } else {
            int e1 = 0, e2 = 0;

            for (int i = 0; i < G1.size(); i++) {
                e1 += G1.get(i).size();
            }

            for (int i = 0; i < G2.size(); i++) {
                e2 += G2.get(i).size();
            }

            if (e1 != e2) {
                System.out.println("Not Isomorphic graphs");
            } else {
                int[] deg1 = new int[v1];
                int[] deg2 = new int[v2];

                for (int i = 0; i < v1; i++) {
                    deg1[i] = G1.get(i).size();
                }

                for (int i = 0; i < v2; i++) {
                    deg2[i] = G2.get(i).size();
                }

                Arrays.sort(deg1);
                Arrays.sort(deg2);

                for(int i=0;i<deg1.length;i++){
                    System.out.print(deg1[i]);
                }

                System.out.println("--------------");

                for(int i=0;i<deg2.length;i++){
                    System.out.print(deg2[i]);
                }

                if (!Arrays.equals(deg1, deg2)) {
                    System.out.println("Not Isomorphic graphs");
                } else {
                    int[] mapping = new int[v1];
                    for (int i = 0; i < v1; i++) {
                        mapping[i] = i;
                    }

                    if (isIsomorphic(G1, G2, mapping, 0)) {
                        System.out.println("Isomorphic graphs");
                    } else {
                        System.out.println("Not Isomorphic graphs");
                    }
                }
            }
        }
    }

    private static boolean isIsomorphic(List<List<Edge>> G1, List<List<Edge>> G2, int[] mapping, int index) {
        if (index == G1.size()) {
            return verifyMapping(G1, G2, mapping);
        }

        for (int i = 0; i < G1.size(); i++) {
            boolean alreadyUsed = false;
            for (int j = 0; j < index; j++) {
                if (mapping[j] == i) {
                    alreadyUsed = true;
                    break;
                }
            }

            if (!alreadyUsed) {
                mapping[index] = i;
                if (isIsomorphic(G1, G2, mapping, index + 1)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean verifyMapping(List<List<Edge>> G1, List<List<Edge>> G2, int[] mapping) {
        for (int i = 0; i < G1.size(); i++) {
            List<Edge> edges1 = G1.get(i);
            for (Edge e : edges1) {
                int mappedSrc = mapping[e.src];
                int mappedDest = mapping[e.dest];

                boolean found = false;
                for (Edge e2 : G2.get(mappedSrc)) {
                    if (e2.dest == mappedDest) {
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    return false;
                }
            }
        }
        return true;
    }
}
