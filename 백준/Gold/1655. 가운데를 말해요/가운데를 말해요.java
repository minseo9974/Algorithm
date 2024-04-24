
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> leftQ = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> rightQ = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            if (i % 2 == 0) {
                leftQ.add(input);
            } else {
                rightQ.add(input);
            }
            if (!leftQ.isEmpty() && !rightQ.isEmpty()) {
                if (leftQ.peek() > rightQ.peek()) {
                    int tmp = rightQ.poll();
                    rightQ.add(leftQ.poll());
                    leftQ.add(tmp);
                }
            }
            sb.append(leftQ.peek()).append('\n');
        }
        System.out.println(sb);
    }
}