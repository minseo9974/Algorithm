import java.io.*;
import java.util.*;

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
            int m = Integer.parseInt(st.nextToken());
            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int max = 0;
            sb.append("#").append(index++).append(" ");
            for (int i = 0; i <= n - m; i++) {
                for (int j = 0; j <= n-m; j++) {
                    int maxSum = 0;
                    for (int k = 0; k < m; k++) {
                        for (int l = 0; l < m; l++) {
                            maxSum += arr[i+k][j+l];
                        }
                    }
                    max = Math.max(max, maxSum);
                }
            }
            sb.append(max).append('\n');

        }

        System.out.println(sb);
    }
}