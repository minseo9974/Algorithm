

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] dp = new int[k + 1];
        int[] coin = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(coin);
        Arrays.fill(dp, 100001);
        dp[0] = 0;
        for (int j = 0; j < n; j++) {
            for (int i = coin[j]; i <= k; i++) {
                dp[i] = Math.min(dp[i], 1 + dp[i-coin[j]]);
            }
        }
        System.out.println(dp[k] == 100001 ? "-1" : dp[k]);
    }
}