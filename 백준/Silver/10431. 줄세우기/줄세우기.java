
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            int[] arr = new int[20];
            for (int i = 0; i < 20; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int cnt = 0;
            int[] newArr = new int[20];
            for (int i = 0; i < 20; i++) {
                int p = arr[i];
                boolean flag = false;
                for (int j = 0; j < i; j++) {
                    if (newArr[j] > p) {
                        flag = true;
                        for (int k = i; k > j; k--) {
                            newArr[k] = newArr[k - 1];
                            cnt++;
                        }
                        newArr[j] = p;
                        break;
                    }
                }
                if (!flag) {
                    newArr[i] = p;
                }
            }
            sb.append(index).append(" ").append(cnt).append('\n');
        }
        System.out.println(sb);
    }
}