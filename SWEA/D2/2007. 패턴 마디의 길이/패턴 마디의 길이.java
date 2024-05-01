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
            for (int i = 1; i <= 10; i++) {
                String s1 = str.substring(0, i);
                String s2 = str.substring(i, i * 2);
                if (s1.equals(s2)) {
                    sb.append("#").append(index++).append(" ").append(s1.length()).append('\n');
                    break;
                }
            }
        }

        System.out.println(sb);
    }
}