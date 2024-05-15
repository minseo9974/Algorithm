
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        String[] sp = new String[n + 1];
        dp[1] = 0;
        sp[1] = "1";
        for (int i = 2; i <= n; i++) {
            int cnt = Integer.MAX_VALUE;
            int number = 0;
            if (i % 3 == 0) {
                cnt = dp[i / 3];
                number = i / 3;
            }
            if (i % 2 == 0) {
                if (cnt > dp[i / 2]) {
                    cnt = dp[i / 2];
                    number = i / 2;
                }
            }
            if (cnt > dp[i - 1]) {
                number = i - 1;
            }
            dp[i] = dp[number] + 1;
            sp[i] = i + " " + sp[number];
        }
        System.out.println(dp[n]);
        System.out.println(sp[n]);
    }
}
