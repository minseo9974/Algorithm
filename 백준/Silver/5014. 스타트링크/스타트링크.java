
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int f, s, g, u, d;
    static int[] ud;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        ud = new int[2];
        ud[0] = Integer.parseInt(st.nextToken());
        ud[1] = -Integer.parseInt(st.nextToken());
        visited = new boolean[f + 1];
        bfs();
    }

    private static void bfs() {
        Queue<Elevator> q = new LinkedList<>();
        q.add(new Elevator(s, 0));
        visited[s] = true;
        while (!q.isEmpty()) {
            Elevator e = q.poll();
            if (e.n == g) {
                System.out.println(e.cnt);
                return;
            }
            for (int i = 0; i < 2; i++) {
                int nx = e.n + ud[i];
                if (nx < 1 || nx > f || visited[nx]) {
                    continue;
                }
                visited[nx] = true;
                q.add(new Elevator(nx, e.cnt + 1));
            }
        }
        System.out.println("use the stairs");
    }
}

class Elevator {
    int n;
    int cnt;

    public Elevator(int n, int cnt) {
        this.n = n;
        this.cnt = cnt;
    }
}