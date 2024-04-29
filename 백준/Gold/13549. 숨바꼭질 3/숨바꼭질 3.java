
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];
        bfs();
        System.out.println(min);
    }

    private static void bfs() {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(n, 0));
        while (!q.isEmpty()) {
            Point p = q.poll();
            visited[p.x] = true;
            if (p.x == k) {
                min = Math.min(min, p.count);
            }
            if (p.x * 2 <= 100000 && !visited[p.x * 2]) {
                q.add(new Point(p.x * 2, p.count));
            }
            if (p.x + 1 <= 100000 && !visited[p.x + 1]) {
                q.add(new Point(p.x + 1, p.count + 1));
            }
            if (p.x - 1 >= 0 && !visited[p.x - 1]) {
                q.add(new Point(p.x - 1, p.count + 1));
            }
        }
    }
}

class Point {
    int x;
    int count;

    public Point(int x, int count) {
        this.x = x;
        this.count = count;
    }
}
