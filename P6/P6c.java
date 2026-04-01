package P6;

import java.util.*;

public class P6c {
    static int N;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices (n): ");
        N = sc.nextInt();

        if (N == 2) {
            System.out.println("Tree 1: (1,2)");
            System.out.println("Total spanning trees: 1");
            return;
        }

        int[] currentSeq = new int[N - 2];
    
        generateAndPrint(0, currentSeq);

        System.out.println("\nTotal spanning trees generated: " + count);
    }

    private static void generateAndPrint(int index, int[] currentSeq) {
        if (index == N - 2) {
            printTreeFromPrufer(currentSeq);
            count++;
            return;
        }

        for (int i = 1; i <= N; i++) {
            currentSeq[index] = i;
            generateAndPrint(index + 1, currentSeq);
        }
    }

    private static void printTreeFromPrufer(int[] pruferArr) {

        Queue<Integer> pruferCode = new LinkedList<>();
        for (int x : pruferArr) {
            pruferCode.offer(x);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 1; i <= N; i++) {
            if (!pruferCode.contains(i)) {
                pq.add(i);
            }
        }

        List<String> edges = new ArrayList<>();

        int itr = N - 1;

        while (itr != 1) {

            int fc = pruferCode.poll();
            int tc = pq.poll();

            edges.add("(" + tc + ", " + fc + ")");

            pruferCode.offer(tc);

            for (int i = 1; i <= N; i++) {
                if (!pq.contains(i) && !pruferCode.contains(i)) {
                    pq.add(i);
                }
            }

            itr--;
        }

        edges.add("(" + pq.poll() + ", " + pq.poll() + ")");

        System.out.println("Sequence " + Arrays.toString(pruferArr) + " -> Edges: " + edges);
    }
}
