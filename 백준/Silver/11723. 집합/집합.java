
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] stack = new int[21];
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("all")) {
                for (int i = 0; i < 21; i++) {
                    stack[i] = 1;
                }
                continue;
            }else if (command.equals("empty")){
                stack = new int[21];
                continue;
            }

            int num = Integer.parseInt(st.nextToken());
            if (command.equals("add")) {
                    stack[num] = 1;
            } else if (command.equals("remove") && stack[num] == 1) {
                stack[num] = 0;
            } else if (command.equals("check")) {
                sb.append(stack[num] == 1 ? "1" : "0").append('\n');
            } else if (command.equals("toggle")) {
                if (stack[num] == 1) {
                    stack[num] = 0;
                }else {
                    stack[num] = 1;
                }
            }
        }
        System.out.println(sb);
    }
}