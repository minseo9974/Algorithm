
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int index = 1;
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            StringBuilder result = new StringBuilder();
            result.append("#").append(index++).append('\n');
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String s = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                for (int j = 0; j < num; j++) {
                    sb.append(s);
                    if (sb.length() % 10 == 0) {
                        result.append(sb).append('\n');
                        sb = new StringBuilder();
                    }
                }
            }
            result.append(sb);
            System.out.println(result);
        }
    }
}
