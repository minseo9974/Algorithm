
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static int[] result;
    static int n;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while (true) {
            s = br.readLine();
            if (s.equals("0")) {
                break;
            }
            n = Integer.parseInt(s.split(" ")[0]);
            arr = new int[n];
            check = new boolean[n];
            result = new int[6];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(s.split(" ")[i + 1]);
            }
            dp(0,0);
            sb.append('\n');
        }
            System.out.println(sb);

    }

    private static void dp(int start, int depth) {
        if (depth == 6) {
            for (int j = 0; j < 6; j++) {
                sb.append(result[j]).append(" ");
            }
            sb.append('\n');
            return;
        }
        for (int i = start; i < n; i++) {
            if (check[i]) {
                continue;
            }
                check[i] = true;
                result[depth] = arr[i];
                dp(i, depth + 1);
                check[i] = false;
        }

    }
}