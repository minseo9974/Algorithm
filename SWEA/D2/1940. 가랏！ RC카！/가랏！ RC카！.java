
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
            int sum = 0;
            int speed = 0;
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int command = Integer.parseInt(st.nextToken());
                if (command == 1) {
                    speed += Integer.parseInt(st.nextToken());
                }
                if (command == 2) {
                    speed -= Integer.parseInt(st.nextToken());
                }
                if (speed < 0) {
                    speed = 0;
                }
                sum += speed;
            }
            sb.append("#").append(index++).append(" ").append(sum).append('\n');

        }
        System.out.println(sb);
    }
}