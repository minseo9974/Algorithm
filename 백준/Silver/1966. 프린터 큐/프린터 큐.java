
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Queue<Integer> qIndex;
        Queue<Integer> q;

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int total = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());

            q = new LinkedList<>();
            qIndex = new LinkedList<>();

            for (int j = 0; j < total; j++) {
                q.offer(Integer.parseInt(st.nextToken()));
                qIndex.offer(j);
            }
            int count = 1;
            while (!q.isEmpty()) {
                int max = Collections.max(q);
                int cur = q.poll();
                int curIndex = qIndex.poll();
                if (cur == max) {
                    if (curIndex == m) {
                        sb.append(count).append('\n');
                        break;
                    }
                    count++;
                } else {
                    q.offer(cur);
                    qIndex.offer(curIndex);
                }
            }
        }
        System.out.println(sb);
    }

}
