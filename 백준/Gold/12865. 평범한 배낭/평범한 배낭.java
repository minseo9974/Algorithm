import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static int[][] dp = new int[101][100001];
    static int[] weight = new int[100];
    static int[] value = new int[100];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(0, 0));
    }

    private static int solution(int i, int w) {
        if (dp[i][w] > 0) {
            return dp[i][w];
        }
        if (i == n) {
            return 0;
        }
        int n1 = 0;
        if (w + weight[i] <= k) {
            n1 = value[i] + solution(i + 1, w + weight[i]);
        }
        int n2 = solution(i + 1, w);

        return dp[i][w] = Math.max(n1, n2);
    }
}
