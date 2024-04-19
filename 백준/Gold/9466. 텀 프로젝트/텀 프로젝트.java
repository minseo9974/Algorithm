
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int count;
    static boolean[] visited, finish;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            count = 0;
            arr = new int[n + 1];
            visited = new boolean[n + 1];
            finish = new boolean[n + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            for (int j = 1; j <= n; j++) {
                if (finish[j]) {
                    continue;
                }
                dfs(j);
            }
            sb.append(n - count).append('\n');
        }
        System.out.println(sb);
    }

    private static void dfs(int node) {
        if (finish[node]) {
            return;
        }
        if (visited[node]) {
            count++;
            finish[node] = true;
        }
        visited[node] = true;
        dfs(arr[node]);
        visited[node] = false;
        finish[node] = true;
    }
}