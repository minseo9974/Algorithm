
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] distance = new long[n - 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        long[] liter = new long[n];
        for (int i = 0; i < n; i++) {
            liter[i] = Integer.parseInt(st.nextToken());
        }
        long min = liter[0];
        long sum = 0;
        for (int i = 0; i < n - 1; i++) {
            if (liter[i] < min) {
                min = liter[i];
            }
            sum += (min * distance[i]);
        }
        System.out.println(sum);
    }
}