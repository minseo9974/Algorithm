
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int temp = 1;
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            for (; temp <= input; temp++) {
                stack.push(temp);
                sb.append("+").append('\n');
            }
            if (stack.peek() == input) {
                stack.pop();
                sb.append("-").append('\n');
            }else {
                System.out.println("NO");
                return;
            }
        }
        System.out.println(sb.toString());

    }
}


