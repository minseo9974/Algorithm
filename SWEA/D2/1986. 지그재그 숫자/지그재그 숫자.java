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
            int n = Integer.parseInt(br.readLine());
            boolean flag = false;
            int first = 1;
            for (int i = 2; i <= n; i++) {
                if (!flag) {
                    first -= i;
                }
                else{
                    first += i;
                }
                flag = !flag;
            }
            sb.append("#").append(index++).append(" ").append(first).append('\n');
        }

        System.out.println(sb);
    }
}