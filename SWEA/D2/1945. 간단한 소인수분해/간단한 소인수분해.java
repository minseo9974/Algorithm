
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int[] arr = {2, 3, 5, 7, 11};
        int index = 1;
        while (t-- > 0) {
            int[] result = new int[5];
            sb.append("#").append(index++).append(" ");
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < 5; i++) {
                while (n % arr[i] == 0) {
                    n /= arr[i];
                    result[i]++;
                }
            }
            for (int i = 0; i < 5; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}