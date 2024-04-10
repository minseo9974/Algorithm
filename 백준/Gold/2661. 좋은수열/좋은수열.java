
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        backtracking("");
    }

    private static void backtracking(String s) {
        if (s.length() == n) {
            System.out.println(s);
            System.exit(0);
        }
        for (int i = 1; i <= 3; i++) {
            if (checkStr(s + i)) {
                backtracking(s + i);
            }
        }
    }

    private static boolean checkStr(String s) {
        int length = s.length() / 2;
        for (int i = 1; i <= length; i++) {
            if (s.substring(s.length() - i).equals(s.substring(s.length() - 2 * i, s.length() - i))) {
                return false;
            }
        }
        return true;
    }
}