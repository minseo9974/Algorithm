
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        tree = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            tree[i][0] = Integer.parseInt(st.nextToken());
            tree[i][1] = Integer.parseInt(st.nextToken());
            tree[i][2] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i < n; i++) {
            tree[i][0] += Math.min(tree[i - 1][1], tree[i - 1][2]);
            tree[i][1] += Math.min(tree[i - 1][0], tree[i - 1][2]);
            tree[i][2] += Math.min(tree[i - 1][1], tree[i - 1][0]);
        }
        System.out.println(Math.min(tree[n - 1][0], Math.min(tree[n - 1][1], tree[n - 1][2])));

    }
}