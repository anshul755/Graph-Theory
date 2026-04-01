package P6;

import java.util.*;

public class P6a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        Queue<Integer> pruferCode = new LinkedList<>();

        for (char ch : s.toCharArray())
            pruferCode.offer(Integer.parseInt(ch + ""));

        int n = pruferCode.size();

        int itr = n + 1;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 1; i <= n + 2; i++) {
            if (!pq.contains(i) && !pruferCode.contains(i)) {
                pq.add(i);
            }
        }

        System.out.println(pq);

        List<String> edge = new ArrayList<>();

        while (itr != 1) {
            int fc = pruferCode.poll();
            int tc = pq.poll();
            edge.add(fc + "<->" + tc);
            pruferCode.offer(tc);
            for (int i = 1; i <= n + 2; i++) {
                if (!pq.contains(i) && !pruferCode.contains(i)) {
                    pq.add(i);
                }
            }
            itr--;
        }

        System.out.println(pq);

        edge.add(pq.poll() + "<->" + pq.poll());

        System.out.println(edge);

        // 1135559
    }
}
