import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int min = Integer.MAX_VALUE;
    static int n;
    static int[][] arr;
    static boolean[] visit;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(min);

    }

    private static void dfs(int depth, int start) {
        if (depth == n / 2) {
            diff();
            return;
        }
        for (int i = start; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(depth + 1, i + 1);
                visit[i] = false;
            }
        }
    }

    private static void diff() {
        int start = 0;
        int link = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (visit[i] && visit[j]) {
                    start += arr[i][j];
                    start += arr[j][i];
                } else if (!visit[i] && !visit[j]) {
                    link += arr[i][j];
                    link += arr[j][i];
                }
            }
        }
        int result = Math.abs(start - link);
        if (result == 0) {
            System.out.println(0);
            System.exit(0);
        }
        min = Math.min(min, result);
    }

}