package P2;

import java.util.*;

public class P2 {

    static class Edge {
        int src, dest;
        char label;

        Edge(int s, int d, char l) {
            src = s;
            dest = d;
            label = l;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Edge))
                return false;
            Edge e = (Edge) o;
            return src == e.src && dest == e.dest && label == e.label;
        }

        @Override
        public int hashCode() {
            return Objects.hash(src, dest, label);
        }

        public String toString() {
            return "(" + src + "->" + dest + ", " + label + ")";
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
                System.out.print("Enter label: ");
                char l = sc.next().charAt(0);
                graph.get(i).add(new Edge(i, d, l));
            }
        }
    }

    private static List<List<Edge>> generateCompleteGraph(int v) {
        List<List<Edge>> K = new ArrayList<>();
        for (int i = 0; i < v; i++)
            K.add(new ArrayList<>());

        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                if (i != j) {
                    K.get(i).add(new Edge(i, j, 'e'));
                }
            }
        }
        return K;
    }

    private static boolean exists(List<List<Edge>> G, Edge e) {
        if (e.src >= G.size())
            return false;
        return G.get(e.src).contains(e);
    }

    private static List<List<Edge>> Union(List<List<Edge>> G1, List<List<Edge>> G2, int v1, int v2) {
        int maxV = Math.max(v1, v2);
        List<List<Edge>> U = new ArrayList<>();
        for (int i = 0; i < maxV; i++)
            U.add(new ArrayList<>());

        for (int i = 0; i < v1; i++) {
            U.get(i).addAll(G1.get(i));
        }

        for (int i = 0; i < v2; i++) {
            for (Edge e : G2.get(i)) {
                if (!exists(U, e))
                    U.get(i).add(e);
            }
        }

        return U;
    }

    private static List<List<Edge>> Intersection(List<List<Edge>> G1, List<List<Edge>> G2, int v1, int v2) {
        int maxV = Math.max(v1, v2);
        List<List<Edge>> I = new ArrayList<>();
        for (int i = 0; i < maxV; i++)
            I.add(new ArrayList<>());

        int minV = Math.min(v1, v2);
        for (int i = 0; i < minV; i++) {
            for (Edge e : G1.get(i)) {
                if (exists(G2, e))
                    I.get(i).add(e);
            }
        }
        return I;
    }

    private static List<List<Edge>> Difference(List<List<Edge>> G1, List<List<Edge>> G2, int v1, int v2) {
        // G1 - G2: Edges in G1 that are NOT in G2
        int maxV = Math.max(v1, v2);
        List<List<Edge>> D = new ArrayList<>();
        for (int i = 0; i < maxV; i++)
            D.add(new ArrayList<>());

        for (int i = 0; i < v1; i++) {
            for (Edge e : G1.get(i)) {
                if (!exists(G2, e))
                    D.get(i).add(e);
            }
        }
        return D;
    }

    private static List<List<Edge>> Complement(List<List<Edge>> U, List<List<Edge>> G1, int vU, int v1) {
        // U - G1 (relative to U)
        List<List<Edge>> C = new ArrayList<>();
        for (int i = 0; i < vU; i++)
            C.add(new ArrayList<>());

        for (int i = 0; i < vU; i++) {
            for (Edge e : U.get(i)) {
                if (!exists(G1, e))
                    C.get(i).add(e);
            }
        }
        return C;
    }

    private static List<List<Edge>> RingSum(List<List<Edge>> G1, List<List<Edge>> G2, int v1, int v2) {
        // (G1 U G2) - (G1 n G2) OR (G1 - G2) U (G2 - G1)
        int maxV = Math.max(v1, v2);
        List<List<Edge>> R = new ArrayList<>();
        for (int i = 0; i < maxV; i++)
            R.add(new ArrayList<>());

        // G1 - G2
        for (int i = 0; i < v1; i++) {
            for (Edge e : G1.get(i))
                if (!exists(G2, e))
                    R.get(i).add(e);
        }
        // G2 - G1
        for (int i = 0; i < v2; i++) {
            for (Edge e : G2.get(i))
                if (!exists(G1, e))
                    R.get(i).add(e);
        }
        return R;
    }

    private static void printGraph(List<List<Edge>> graph) {
        if (graph == null)
            return;
        for (int i = 0; i < graph.size(); i++) {
            System.out.println(i + " -> " + graph.get(i));
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

        int choice;
        do {
            System.out.println("\n--------------------------");
            System.out.println("Choose Operation:");
            System.out.println("1. Union");
            System.out.println("2. Intersection");
            System.out.println("3. Difference (G1-G2)");
            System.out.println("4. Complement (~G1)");
            System.out.println("5. RingSum (Symmetric Difference)");
            System.out.println("6. Exit");
            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            List<List<Edge>> result = null;

            switch (choice) {
                case 1 -> result = Union(G1, G2, v1, v2);
                case 2 -> result = Intersection(G1, G2, v1, v2);
                case 3 -> result = Difference(G1, G2, v1, v2);
                case 4 -> {
                    System.out.println("For Complement, choose Universal Graph source:");
                    System.out.println("1. Generate Complete Graph (K" + v1 + ")");
                    System.out.println("2. Manually Enter Universal Graph");
                    int uChoice = sc.nextInt();
                    List<List<Edge>> Universal = new ArrayList<>();
                    int vU = v1;

                    if (uChoice == 1) {
                        Universal = generateCompleteGraph(v1);
                    } else if (uChoice == 2) {
                        System.out.print("Enter number of vertices for Universal Graph: ");
                        vU = sc.nextInt();
                        createGraph(Universal, vU, sc);
                    } else {
                        System.out.println("Invalid Universal Graph choice.");
                    }

                    if (!Universal.isEmpty()) {
                        result = Complement(Universal, G1, vU, v1);
                    }
                }
                case 5 -> result = RingSum(G1, G2, v1, v2);
                case 6 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice");
            }

            if (result != null && choice != 6) {
                System.out.println("\nResult Graph:");
                printGraph(result);
            }

        } while (choice != 6);
    }
}
