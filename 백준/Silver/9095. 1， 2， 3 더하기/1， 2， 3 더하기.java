
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int n;
    static int[] arr;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        arr = new int[11];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            for (int j = 4; j <= n; j++) {
                arr[j] = arr[j - 1] + arr[j - 2] + arr[j - 3];
            }
            sb.append(arr[n]).append('\n');
        }
        System.out.println(sb);

    }

}