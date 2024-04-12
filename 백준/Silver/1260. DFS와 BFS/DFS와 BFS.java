
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, v;
    static int[][] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = 1;
            arr[y][x] = 1;
        }
        dfs(v);
        sb.append('\n');
        visited = new boolean[n + 1];
        bfs(v);
        System.out.println(sb);
    }
    static Queue<Integer>q;
    private static void bfs(int node) {
        q = new LinkedList<>();
        q.offer(node);
        visited[node] = true;
        while (!q.isEmpty()) {
            int now = q.poll();
            sb.append(now).append(" ");
            for (int i = 1; i <= n; i++) {
                if (arr[now][i] == 1 && !visited[i]) {
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }

    }

    private static void dfs(int node) {
        visited[node] = true;
        sb.append(node).append(" ");
        for (int i = 1; i <= n; i++) {
            if (arr[node][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

}