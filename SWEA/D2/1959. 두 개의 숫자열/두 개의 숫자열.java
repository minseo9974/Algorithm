
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
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] a = new int[n];
            int[] b = new int[m];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }
            if (n > m) {
                int[] tmp = a;
                a = b;
                b = tmp;
            }
            int min = Math.min(n, m);
            int max = 0;
            for (int i = 0; i <= Math.abs(n - m); i++) {
                int sum = 0;
                for (int j = 0; j < min; j++) {
                    sum += a[j] * b[i + j];
                }
                max = Math.max(max, sum);
            }
            sb.append("#").append(index++).append(" ").append(max).append('\n');
        }
        System.out.println(sb);
    }
}