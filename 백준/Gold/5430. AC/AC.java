
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;


public class Main {
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
            ArrayDeque<Integer> deque = new ArrayDeque<>();

            for (int j = 0; j < n; j++) {
                int input = Integer.parseInt(st.nextToken());
                deque.add(input);
            }
            AC(p, deque);
        }
        System.out.println(sb);

    }

    public static void AC(String p, ArrayDeque<Integer> deque) {
        boolean reverse = false;

        for (char c : p.toCharArray()) {
            if (c == 'R') {
                reverse = !reverse;
            } else {
                if (deque.size() == 0) {
                    sb.append("error").append('\n');
                    return;
                }
                if (reverse) {
                    deque.pollLast();
                } else {
                    deque.pollFirst();
                }
            }
        }
        printAC(deque, reverse);
    }

    private static void printAC(ArrayDeque<Integer> deque, boolean reverse) {
        sb.append("[");
        while (deque.size() != 0) {
            if (reverse) {
                sb.append(deque.pollLast());
            } else {
                sb.append(deque.pollFirst());
            }
            if (deque.size() > 0) {
                sb.append(",");
            }
        }
        sb.append("]").append('\n');

    }
}