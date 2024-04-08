
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] arr;
    static int n, result;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp(0);
        System.out.println(result);

    }

    private static void dp(int depth) {
        if (depth == n) {
            result++;
            return;
        }
        for (int i = 0; i < n; i++) {
            arr[depth] = i;
            if (possible(depth)) {
                dp(depth + 1);
            }
        }
    }

    private static boolean possible(int depth) {
        for (int i = 0; i < depth; i++) {
            if (arr[i] == arr[depth]) {
                return false;
            }
            if (Math.abs(depth - i) == Math.abs(arr[depth] - arr[i])) {
                return false;
            }
        }
        return true;
    }
}