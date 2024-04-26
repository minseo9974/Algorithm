
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] distance = new int[n - 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int[] liter = new int[n];
        for (int i = 0; i < n; i++) {
            liter[i] = Integer.parseInt(st.nextToken());
        }
        int min = liter[0];
        long sum = 0;
        sum += (long) min * distance[0];
        for (int i = 1; i < n - 1; i++) {
            if (liter[i] < liter[i - 1]) {
                min = liter[i];
            }
            sum += (long) min * distance[i];
        }
        System.out.println(sum);
    }
}