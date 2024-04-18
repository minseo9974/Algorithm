
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m][2];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                if (str.charAt(j) == '1') {
                    map[i][j] = 1;
                }
            }
        }
        bfs();
    }

    static class Point{
        private int x;
        private int y;
        private boolean destroyed;
        private int count;

        public Point(int x, int y, boolean destroyed, int count) {
            this.x = x;
            this.y = y;
            this.destroyed = destroyed;
            this.count = count;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public boolean isDestroyed() {
            return destroyed;
        }

        public int getCount() {
            return count;
        }
    }
    private static void bfs() {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0, false, 1));
        visited[0][0][0]=true;

        while (!q.isEmpty()) {
            Point point = q.poll();
            if (point.getX() == n - 1 && point.getY() == m - 1) {
                System.out.println(point.getCount());
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nx = point.getX() + dx[i];
                int ny = point.getY() + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                if (point.isDestroyed()) {
                    if (map[nx][ny] == 0 && !visited[nx][ny][1]) {
                        visited[nx][ny][1] = true;
                        q.offer(new Point(nx, ny, true, point.getCount() + 1));
                    }
                }else{
                    if (map[nx][ny] == 1) {
                        visited[nx][ny][1] =true;
                        q.offer(new Point(nx, ny, true, point.getCount() + 1));
                    }else if(!visited[nx][ny][0]){
                        visited[nx][ny][0]=true;
                        q.offer(new Point(nx, ny, false, point.getCount() + 1));
                    }
                }
            }
        }
        System.out.println(-1);
    }
}