
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static String[] arr;
    static boolean[] visited;
    static int max = 0;
    static int min = Integer.MAX_VALUE;
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new String[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = st.nextToken();
        }
        visited = new boolean[10];
        dfs(0, "");
        System.out.println(list.get(list.size()-1));
        System.out.println(list.get(0));

    }

    private static void dfs(int depth, String result) {
        if (n+1 == depth) {
            list.add(result);
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (!visited[i]) {
                if (depth == 0 || check(result.charAt(depth - 1), i, arr[depth - 1])) {
                    visited[i] = true;
                    dfs(depth + 1, result + i);
                    visited[i] = false;
                }
            }
        }
    }

    private static boolean check(char a, int b, String c) {
        int numA = Character.getNumericValue(a);
        if (c.equals(">")) {
            if (numA > b) {
                return true;
            }
        }else {
            if (numA < b) {
                return true;
            }
        }
        return false;
    }
}