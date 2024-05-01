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
            String str = br.readLine();
            int n = 1;
            for (int i = 0; i < str.length() / 2; i++) {
                if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                    n = 0;
                    break;
                }
            }
            sb.append("#").append(index++).append(" ").append(n).append('\n');

        }

        System.out.println(sb);
    }
}