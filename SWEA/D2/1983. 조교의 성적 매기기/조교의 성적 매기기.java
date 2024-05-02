import java.io.*;
import java.util.*;

public class Solution {

	 public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int index = 1;
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            String[] s = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                arr[i] = a * 35 + b * 45 + c * 20;
                if (i == k-1) {
                    k = arr[i];
                }
            }
            Arrays.sort(arr);
            int tmp = -1;
            for (int i = n - 1; i >= 0; i--) {
                if (arr[i] == k) {
                    tmp = n - 1 - i;
                    break;
                }
            }
            sb.append("#").append(index++).append(" ").append(s[tmp / (n / 10)]).append('\n');
        }

        System.out.println(sb);
    }
}