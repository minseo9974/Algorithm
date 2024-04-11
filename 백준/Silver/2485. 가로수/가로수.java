
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int distance = 0;
        for (int i = 0; i < n - 1; i++) {
            int d = arr[i + 1] - arr[i];
            distance = gcd(d, distance);
        }

        System.out.println((arr[n - 1] - arr[0]) / distance + 1 - arr.length);

    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int c = a % b;
            a = b;
            b = c;
        }
        return a;
    }

}