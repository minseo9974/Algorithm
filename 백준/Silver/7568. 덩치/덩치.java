
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int[][] arr = new int[t][2];
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < t; i++) {
            int n = 1;
            for (int j = 0; j < t; j++) {
                if (i != j && arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
                    n++;
                }
            }
            sb.append(n).append(" ");
        }
        System.out.println(sb);
    }
}