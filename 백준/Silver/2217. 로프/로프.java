
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int n;
    static int[] lope;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int max = 0;
        lope = new int[n];
        for (int i = 0; i < n; i++) {
            lope[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(lope);
        for (int i = 0; i < n; i++) {
            int weight = lope[i] *(n - i);
            max = Math.max(max, weight);
        }
        System.out.println(max);
    }
}