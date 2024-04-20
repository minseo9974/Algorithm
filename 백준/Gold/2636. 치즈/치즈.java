
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, time, cheese;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int input = Integer.parseInt(st.nextToken());
                map[i][j] = input;
                if (input == 1) {
                    cheese++;
                }
            }
        }

        int cheeseCnt = 0;
        while (cheese != 0) {
            cheeseCnt = cheese;
            time++;
            visited = new boolean[n][m];
            bfs();
        }
        System.out.println(time);
        System.out.println(cheeseCnt);
    }

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] point = q.poll();
            int x = point[0];
            int y = point[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m&& !visited[nx][ny]) {
                    if (map[nx][ny] == 0) {
                        q.add(new int[] {nx, ny});
                    }else{
                        cheese--;
                        map[nx][ny] = 0;
                    }
                        visited[nx][ny]=true;
                }
            }
        }
    }

}