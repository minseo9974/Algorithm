
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            int result = 0;
            for (int j = 0; j < str.length(); j++) {
                if (result < 0) {
                    break;
                }
                char c = str.charAt(j);
                if (c == '(') {
                    result++;
                } else if (c == ')') {
                    result--;
                }
            }
            if (result == 0) {
                sb.append("YES").append('\n');
            }else {
                sb.append("NO").append('\n');
            }
        }
        System.out.println(sb);
    }

}
