
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
        int[] day = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m1 = Integer.parseInt(st.nextToken());
            int d1 = Integer.parseInt(st.nextToken());
            int m2 = Integer.parseInt(st.nextToken());
            int d2 = Integer.parseInt(st.nextToken());
            sb.append("#").append(index++).append(" ");
            int sum;
            if (m1 == m2) {
                sum = d2 - d1;
            } else {
                sum = d2;
                for (int i = m1; i < m2; i++) {
                    sum += day[i - 1];
                }
                sum -= d1;
            }
            sb.append(sum + 1).append('\n');
        }
        System.out.println(sb);
    }
}
