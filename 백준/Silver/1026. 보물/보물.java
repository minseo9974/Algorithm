
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr1;
    static int[] arr2;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr1 = new int[n];
        arr2 = new int[n];

        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solve());
    }

    public static int solve() {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = result + (arr1[i] * arr2[n - 1 - i]);
        }
        return result;
    }
}

