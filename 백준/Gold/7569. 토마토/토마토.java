
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, h;
    static int[][][] map;
    static int[] dx = {0, 0, -1, 1, 0, 0};
    static int[] dy = {-1, 1, 0, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static Queue<Point> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        map = new int[n][m][h];
        for (int z = 0; z < h; z++) {
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    int input = Integer.parseInt(st.nextToken());
                    map[i][j][z] = input;
                    if (input == 1) {
                        q.add(new Point(i, j, z, 0));
                    }
                }
            }
        }
        bfs();
    }

    static void bfs() {
        int cnt = 0;
        while (!q.isEmpty()) {
            Point point = q.poll();
            cnt = point.getCount();
            for (int i = 0; i < 6; i++) {
                int nx = point.getX() + dx[i];
                int ny = point.getY() + dy[i];
                int nz = point.getZ() + dz[i];
                if (nx >= 0 && ny >= 0 && nz >= 0 && nz < h && nx < n && ny < m) {
                    if (map[nx][ny][nz] == 0) {
                        map[nx][ny][nz] = 1;
                        q.add(new Point(nx, ny, nz, point.getCount() + 1));
                    }
                }
            }
        }
        for (int z = 0; z < h; z++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j][z] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }
        System.out.println(cnt);
    }

    static class Point {
        private int x;
        private int y;
        private int z;
        private int count;

        public Point(int x, int y, int z, int count) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.count = count;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getZ() {
            return z;
        }

        public int getCount() {
            return count;
        }
    }
}