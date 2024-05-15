
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int a,b,n;
    static boolean[] visited;
    static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
         a = Integer.parseInt(st.nextToken());
         b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(br.readLine());
        graph = new int[n + 1][n + 1];
        for (int i = 1; i <= c; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = 1;
            graph[y][x] = 1;
        }
        visited = new boolean[n + 1];
        bfs(a);
    }

    static Queue<Node> q = new LinkedList<>();
    private static void bfs(int a) {
        q.add(new Node(a,1));

        while (!q.isEmpty()) {
            Node node = q.poll();
            visited[node.n] = true;
            for (int i = 1; i <= n; i++) {
                if (graph[node.n][i] == 1 && !visited[i]) {
                    if (i == b) {
                        System.out.println(node.cnt);
                        return;
                    }
                    q.add(new Node(i,node.cnt+1));
                }
            }
        }
        System.out.println(-1);
    }
}

class Node{
    int n;
    int cnt;

    public Node(int n, int cnt) {
        this.n = n;
        this.cnt = cnt;
    }
}