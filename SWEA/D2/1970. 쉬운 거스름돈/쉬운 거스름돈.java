
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int index = 1;
        int[] money = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
        while (t-- > 0) {
            sb.append("#").append(index++).append('\n');
            int input = Integer.parseInt(br.readLine());
            for (int i = 0; i < 8; i++) {
                int cnt = 0;
                while (money[i] <= input) {
                    input -= money[i];
                    cnt++;
                }
                sb.append(cnt).append(" ");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}