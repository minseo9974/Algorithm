
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, k,cnt;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n][k];
        visited = new boolean[n][k];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < k; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        visited[0][0] = true;
        bfs(0, 0);
        System.out.println(arr[n-1][k-1]);
    }

    static Queue<int[]> q = new LinkedList<>();
    private static void bfs(int x, int y) {
        q.add(new int[] {x, y});
        while (!q.isEmpty()) {
            int[] node = q.poll();
            int nx = node[0];
            int ny = node[1];
            for (int i = 0; i < 4; i++) {
                int nextX = nx + dx[i];
                int nextY = ny + dy[i];
                if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < k && !visited[nextX][nextY] &&
                        arr[nextX][nextY] != 0) {
                    q.add(new int[] {nextX, nextY});
                    arr[nextX][nextY] = arr[nx][ny] +1;
                    visited[nextX][nextY] = true;
                }
            }
        }

    }
}