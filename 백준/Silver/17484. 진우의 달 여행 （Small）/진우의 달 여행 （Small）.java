
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] map;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < m; i++) {
            dfs(0, i, 0,0,0,0);
        }

        System.out.println(min);
    }

    private static void dfs(int depth, int start, int sum,int a,int b,int c) {
        if (depth == n) {
            min = Math.min(min, sum);
            return;
        }
        if (start < 0 || start == m) {
            return;
        }
        if (a < 1) {
        dfs(depth + 1, start, sum + map[depth][start],1,0,0);
        }
        if (b < 1) {
        dfs(depth + 1, start-1, sum + map[depth][start],0,1,0);
        }
        if (c < 1) {
        dfs(depth + 1, start+1, sum + map[depth][start],0,0,1);
        }
    }
}