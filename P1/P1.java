package P1;

import java.util.*;

public class P1 {

    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }

        @Override
        public String toString() {
            return "(" + src + " -> " + dest + ")";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Graph Creation Menu ---");
            System.out.println("1. Adjacency Matrix");
            System.out.println("2. Adjacency List");
            System.out.println("3. Incidence Matrix");
            System.out.println("4. Undirected Graph Delete Edge");
            System.out.println("5. Directed Graph Delete Edge");
            System.out.println("6. Vertex Delete");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int ch = sc.nextInt();

            if (ch == 0) {
                System.out.println("Exiting...");
                break;
            }

            switch (ch) {
                case 1:
                    callAdj(sc);
                    break;
                case 2:
                    calladjList(sc);
                    break;
                case 3:
                    callIncidenceMatrix(sc);
                    break;
                case 4:
                    List<List<Edge>> graph_ud=new ArrayList<>();
                    calladjList(sc,graph_ud);
                    System.out.println("Enter the vertices of Edge to delete the edge: ");
                    int src_ud=sc.nextInt();
                    int dest_ud=sc.nextInt();
                    undirectedDelEdge(graph_ud,src_ud, dest_ud);
                    break;
                case 5:
                    List<List<Edge>> graph_d=new ArrayList<>();
                    calladjList(sc,graph_d);
                    System.out.println("Enter the vertices of Edge to delete the edge: ");
                    int src_d=sc.nextInt();
                    int dest_d=sc.nextInt();
                    Edge e_d=new Edge(src_d, dest_d);
                    directedDelEdge(graph_d,e_d);
                    break;
                case 6:
                    List<List<Edge>> graph_v=new ArrayList<>();
                    calladjList(sc,graph_v);
                    System.out.println("Enter the vertice to delete it:");
                    int v=sc.nextInt();
                    DelVertice(graph_v,v);
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
        sc.close();
    }

    private static void callAdj(Scanner sc) {
        System.out.println("\n-- Adjacency Matrix --");

        System.out.print("Enter the No. of Vertices: ");
        int n = sc.nextInt();
        System.out.println("Enter the Adjacency Matrix (" + n + "x" + n + "):");
        int[][] adjMat = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adjMat[i][j] = sc.nextInt();
            }
        }

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (adjMat[i][j] != 0) {
                    graph.get(i).add(new Edge(i, j));
                }
            }
        }
        printGraph(graph);
    }

    private static void calladjList(Scanner sc) {
        System.out.println("\n-- Adjacency List --");

        System.out.print("Enter the No. of Vertices: ");
        int n = sc.nextInt();

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < n; i++) {
            System.out.print("Enter number of neighbors for vertex " + i + ": ");
            int degree = sc.nextInt();
            System.out.print("Enter neighbors of vertex " + i + ": ");
            for (int j = 0; j < degree; j++) {
                int neighbor = sc.nextInt();
                graph.get(i).add(new Edge(i, neighbor));
            }
        }
        printGraph(graph);
    }

    private static void calladjList(Scanner sc, List<List<Edge>> graph) {
        System.out.println("\n-- Adjacency List --");

        System.out.print("Enter the No. of Vertices: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < n; i++) {
            System.out.print("Enter number of neighbors for vertex " + i + ": ");
            int degree = sc.nextInt();
            System.out.print("Enter neighbors of vertex " + i + ": ");
            for (int j = 0; j < degree; j++) {
                int neighbor = sc.nextInt();
                graph.get(i).add(new Edge(i, neighbor));
            }
        }
        printGraph(graph);
    }

    private static void callIncidenceMatrix(Scanner sc) {
        System.out.println("\n-- Incidence Matrix --");
        System.out.println("1. Directed Graph");
        System.out.println("2. Undirected Graph");
        System.out.print("Enter your choice: ");
        int type = sc.nextInt();

        System.out.print("Enter the No. of Vertices: ");
        int n = sc.nextInt();
        System.out.print("Enter the No. of Edges: ");
        int e = sc.nextInt();

        int[][] incMat = new int[n][e];
        System.out.println("Enter the Incidence Matrix (" + n + "x" + e + "):");
        // Row = Vertex, Col = Edge
        for (int i = 0; i < n; i++) {
            System.out.print("Row for Vertex " + i + ": ");
            for (int j = 0; j < e; j++) {
                incMat[i][j] = sc.nextInt();
            }
        }

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        if (type == 1) { // Directed
            // 1 for outgoing source, -1 for incoming destination
            for (int j = 0; j < e; j++) {
                int u = -1, v = -1;
                for (int i = 0; i < n; i++) {
                    if (incMat[i][j] == 1)
                        u = i;
                    if (incMat[i][j] == -1)
                        v = i;
                }
                if (u != -1 && v != -1) {
                    graph.get(u).add(new Edge(u, v));
                }
            }
        } else { // Undirected
            // 1 for incident (usually two 1s in a single column)
            for (int j = 0; j < e; j++) {
                List<Integer> nodes = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    if (incMat[i][j] == 1)
                        nodes.add(i);
                }
                if (nodes.size() == 2) {
                    int u = nodes.get(0);
                    int v = nodes.get(1);
                    graph.get(u).add(new Edge(u, v));
                    graph.get(v).add(new Edge(v, u));
                }
            }
        }
        printGraph(graph);
    }

    private static void undirectedDelEdge(List<List<Edge>> graph, int src, int dest){
        for(int i=0;i<graph.get(src).size();i++){
            if(graph.get(src).get(i).dest==dest){
                graph.get(src).remove(i);
                break;
            }
        }
        for(int i=0;i<graph.get(dest).size();i++){
            if(graph.get(dest).get(i).dest==src){
                graph.get(dest).remove(i);
                break;
            }
        }
        printGraph(graph);
    }

    private static void directedDelEdge(List<List<Edge>> graph, Edge e){
        for(int i=0;i<graph.get(e.src).size();i++){
            if(graph.get(e.src).get(i).dest==e.dest){
                graph.get(e.src).remove(i);
                break;
            }
        }
        printGraph(graph);
    }

    private static void DelVertice(List<List<Edge>> graph, int v){
        graph.remove(v);
        for(int i=0;i<graph.size();i++){
            for(int j=0;j<graph.get(i).size();j++){
                if(graph.get(i).get(j).dest==v){
                    graph.get(i).remove(j);
                }
            }
        }
        printGraph(graph);
    }

    private static void printGraph(List<List<Edge>> graph) {
        System.out.println("\nGenerated Graph Structure (Adjacency List):");
        for (int i = 0; i < graph.size(); i++) {
            System.out.print("Vertex " + ": ");
            if (graph.get(i).isEmpty()) {
                System.out.print("No edges");
            }
            for (Edge edge : graph.get(i)) {
                System.out.print(edge + " ");
            }
            System.out.println();
        }
    }
}