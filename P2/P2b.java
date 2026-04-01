package P2;

import java.util.*;

public class P2b {
    static int n;
    static int nodeCount = 0;

    static int[][] maze;
    static int[][] parX;
    static int[][] parY;

    static boolean[][] vis;

    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };

    private static void generateMaze(int x) {
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maze[i][j] = (random.nextInt(x) == 0) ? 1 : 0;
            }
        }

        maze[0][0] = 0;
        maze[n - 1][n - 1] = 0;
    }

    private static boolean isBfs(int sx, int sy, int ex, int ey) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { sx, sy });
        vis[sx][sy] = true;
        parX[sx][sy] = -1;
        parY[sx][sy] = -1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int x = cur[0];
            int y = cur[1];

            if (x == ex && y == ey)
                return true;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n && maze[nx][ny] == 0 && !vis[nx][ny]) {
                    vis[nx][ny] = true;
                    parX[nx][ny] = x;
                    parY[nx][ny] = y;
                    q.add(new int[] { nx, ny });
                }
            }
        }

        return false;
    }

    private static void display(int sx, int sy, int ex, int ey) {
        char[][] displayMaze = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                displayMaze[i][j] = (maze[i][j] == 1) ? 'X' : '.';
            }
        }

        displayMaze[sx][sy] = '.';
        displayMaze[ex][ey] = '.';

        int x = ex;
        int y = ey;

        if (vis[ex][ey]) {
            while (x != -1 && y != -1) {
                displayMaze[x][y] = '*';
                int nx = parX[x][y];
                int ny = parY[x][y];

                if (x != nx && y == ny)
                    if (x == nx && y != ny)
                        nodeCount++;
                    else if (x != nx && y == ny)
                        nodeCount++;

                x = nx;
                y = ny;
            }
        }

        displayMaze[sx][sy] = 'S';
        displayMaze[ex][ey] = 'E';

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(displayMaze[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the dimension of matrix: ");
        n = sc.nextInt();

        maze = new int[n][n];
        parX = new int[n][n];
        parY = new int[n][n];
        vis = new boolean[n][n];

        System.out.println("Enter the no. to denote the 1/x % of obstacles: ");
        int x = sc.nextInt();

        generateMaze(x);

        System.out.println("Enter the starting x coord:");
        int sx = sc.nextInt();
        System.out.println("Enter the starting y coord:");
        int sy = sc.nextInt();
        System.out.println("Enter the ending x coord:");
        int ex = sc.nextInt();
        System.out.println("Enter the ending y coord:");
        int ey = sc.nextInt();

        maze[sx][sy] = 0;
        maze[ex][ey] = 0;

        if (isBfs(sx, sy, ex, ey)) {
            System.out.println("Path exists.");
            display(sx, sy, ex, ey);
            System.out.println(nodeCount);
        } else {
            display(sx, sy, ex, ey);
            System.out.println(nodeCount);
            System.out.println("Path doesn't exists.");
        }
    }
}
