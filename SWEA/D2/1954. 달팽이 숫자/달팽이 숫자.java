
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int index = 1;
        while (t-- > 0) {
            sb.append("#").append(index++).append('\n');
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];
            int cnt = 1;
            int x = 0;
            int y = -1;
            int direction = 1;
            while (n > 0) {
                for (int i = 0; i < n; i++) {
                    y+=direction;
                    arr[x][y] = cnt++;
                }
                n-=1;
                for (int i = 0; i < n; i++) {
                    x+=direction;
                    arr[x][y] = cnt++;
                }
                direction = -1 * direction;
            }
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    sb.append(arr[i][j]).append(' ');
                }
                sb.append('\n');
            }
        }
        System.out.println(sb);
    }
}