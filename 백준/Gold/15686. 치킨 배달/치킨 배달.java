
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static int[][] map;
    static ArrayList<Point> home;
    static ArrayList<Point> chicken;
    static int result;
    static boolean[] open;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        home = new ArrayList<>();
        chicken = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int input = Integer.parseInt(st.nextToken());
                map[i][j] = input;
                if (input == 1) {
                    home.add(new Point(i, j));
                } else if (input == 2) {
                    chicken.add(new Point(i, j));
                }
            }
        }

        result = Integer.MAX_VALUE;
        open = new boolean[chicken.size()];
        dfs(0, 0);
        System.out.println(result);

    }

    private static void dfs(int start, int depth) {
        if (depth == m) {
            int chickenStreet = 0;
            for (int i = 0; i < home.size(); i++) {
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < chicken.size(); j++) {
                    if (open[j]) {
                        int distance = Math.abs(home.get(i).getX() - chicken.get(j).getX()) +
                                Math.abs(home.get(i).getY() - chicken.get(j).getY());
                        min = Math.min(min, distance);
                    }
                }
                chickenStreet += min;
            }
            result = Math.min(chickenStreet, result);
            return;
        }
        for (int i = start; i < chicken.size(); i++) {
            if (!open[i]) {
                open[i] = true;
                dfs(i + 1, depth + 1);
                open[i] = false;
            }
        }
    }
}

class Point{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}