import java.io.*;
import java.util.*;
import java.util.stream.*;
 
class Solution
{
  public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int index = 1;
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[][] map = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int count = 0;
            for (int i = 0; i < n; i++) {
                int a = 0;
                int b = 0;
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == 0) {
                        count = a == k ? count + 1 : count;
                        a = 0;
                    }else{
                    a++;
                    }
                    if (map[j][i] == 0) {
                        count = b == k ? count + 1 : count;
                        b = 0;
                    }else{
                    b++;
                    }
                }
                count = a == k ? count + 1 : count;
                count = b == k ? count + 1 : count;
            }
            sb.append("#").append(index++).append(" ").append(count).append('\n');
        }

        System.out.println(sb);
    }
}