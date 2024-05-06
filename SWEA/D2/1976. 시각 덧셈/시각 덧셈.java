
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
            int h1 = Integer.parseInt(st.nextToken());
            int m1 = Integer.parseInt(st.nextToken());
            int h2 = Integer.parseInt(st.nextToken());
            int m2 = Integer.parseInt(st.nextToken());
            int plusH = (m1 + m2) / 60;
            int resultM = (m1 + m2) % 60;
            int resultH = h1 + h2 + plusH;
            while(resultH>12){
                 resultH -= 12;
            }
            sb.append("#").append(index++).append(" ").append(resultH).append(" ").append(resultM).append('\n');
        }
        System.out.println(sb);
    }
}