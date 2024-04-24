
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
        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> {
            int a = Math.abs(o1);
            int b = Math.abs(o2);
            if (a > b) {
                return a - b;
            } else if (a == b) {
                return o1 - o2;
            }else{
                return -1;
            }
        });
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                Integer output = q.poll();
                sb.append(output == null ? 0 : output).append('\n');
                continue;
            }
            q.add(input);
        }
        System.out.println(sb);
    }
}