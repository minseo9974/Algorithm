
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static long m, sum, max, min, mid;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }
        m = Integer.parseInt(br.readLine());
        long result = 0;
        while (min <= max) {
            mid = min + ((max - min) / 2);
            sum = 0;
            for (int i : arr) {
                if (i < mid) {
                    sum += i;
                } else {
                    sum += mid;
                }
            }
            if (sum > m) {
                max = mid - 1;
            } else {
                min = mid + 1;
                result = Math.max(result, mid);
            }
        }
        System.out.println(result);

    }
}