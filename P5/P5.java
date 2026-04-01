package P5;

import java.util.*;

public class P5 {

    static class Node {
        int degree;
        int originalId;

        Node(int degree, int id) {
            this.degree = degree;
            this.originalId = id;
        }
    }

    static void printState(List<Node> nodes) {
        System.out.print("Current degree sequence: ");
        for (Node node : nodes) {
            System.out.print(node.degree + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of vertices:");
        int n = sc.nextInt();

        List<Node> nodes = new ArrayList<>();
        long degreeSum = 0;

        System.out.println("Enter the degrees:");
        for (int i = 0; i < n; i++) {
            int d = sc.nextInt();

            if (d < 0 || d >= n) {
                System.out.println("Not graphical (Degree out of bounds)");
                return;
            }

            nodes.add(new Node(d, i));
            degreeSum += d;
        }

        if (degreeSum % 2 != 0) {
            System.out.println("Not graphical (Sum of degrees is odd)");
            return;
        }

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        while (true) {
            nodes.sort((a, b) -> {
                if (b.degree != a.degree) {
                    return b.degree - a.degree;
                }
                return b.originalId - a.originalId;
            });

            if (nodes.isEmpty() || nodes.get(0).degree == 0) {
                if (!nodes.isEmpty() && nodes.get(nodes.size() - 1).degree < 0) {
                    System.out.println("Not graphical");
                    return;
                }
                break;
            }

            printState(nodes);

            Node u = nodes.remove(0);
            int d = u.degree;

            if (d > nodes.size()) {
                System.out.println("Not graphical (Not enough nodes left to connect)");
                return;
            }

            for (int i = 0; i < d; i++) {
                Node v = nodes.get(i);

                v.degree--;

                if (v.degree < 0) {
                    System.out.println("Not graphical (Degree became negative)");
                    return;
                }

                adj.get(u.originalId).add(v.originalId);
                adj.get(v.originalId).add(u.originalId);
            }

            System.out.println("After connecting node " + u.originalId + ":");
            printState(nodes);
            System.out.println("-----------------------------------");
        }

        System.out.println("Graphical");

        System.out.println("--- Adjacency List ---");
        for (int i = 0; i < n; i++) {
            System.out.print(i + ": ");
            for (int neighbor : adj.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }

        /*
         * 7
         * 5 5 3 3 2 2 2
         * 
         * 7
         * 5 5 5 5 2 2 2
        */
    }
}