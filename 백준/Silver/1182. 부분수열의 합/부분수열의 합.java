
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int n, s;
    static int[] arr;
    static int result;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0);
            System.out.println(result);

    }

    private static void dfs(int start, int sum) {
        if (start >= n) {
            return;
        }
        if (sum + arr[start] == s) {
            result++;
        }
        dfs(start + 1, sum + arr[start]);
        dfs(start + 1, sum);
    }
}