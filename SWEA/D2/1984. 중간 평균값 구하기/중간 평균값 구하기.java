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
            int[] arr = new int[10];
            for (int i = 0; i < 10; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            double mid = 0;
            for (int i = 1; i < 9; i++) {
                mid += arr[i];
            }
            mid = Math.round(mid / 8);
            sb.append("#").append(index++).append(" ").append((int)mid).append('\n');
        }

        System.out.println(sb);
    }
}