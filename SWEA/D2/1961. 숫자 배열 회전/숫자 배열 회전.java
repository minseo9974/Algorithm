
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int index = 1;
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] map = new int[n][n];
            sb.append("#").append(index++).append('\n');
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sb.append(map[n - 1 - j][i]);
                }
                sb.append(' ');
                for (int j = 0; j < n; j++) {
                    sb.append(map[n - 1 - i][n - 1 - j]);
                }
                sb.append(' ');
                for (int j = 0; j < n; j++) {
                    sb.append(map[j][n - 1 - i]);
                }
                sb.append('\n');
            }
        }
        System.out.println(sb);
    }
}