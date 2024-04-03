
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[20000001];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(st.nextToken());
            arr[number + 10000000]++;
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            int number = Integer.parseInt(st.nextToken());
            sb.append(arr[number + 10000000]).append(' ');
        }
        System.out.println(sb);
    }

}
