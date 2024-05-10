
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        int[] arr = new int[n];
        int[] sum = new int[n * n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                sum[cnt++] = arr[i] + arr[j];
            }
        }
        Arrays.sort(sum, 0, cnt - 1);
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                if (Arrays.binarySearch(sum, 0, cnt - 1, arr[i] - arr[j]) >= 0) {
                    System.out.println(arr[i]);
                    return;
                }
            }
        }
    }
}