import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        System.out.println(gcd(n, m));
        System.out.println(lcm(n, m));


    }

    static int gcd(int n, int m) {
        if (m == 0)
            return n;
        return gcd(m, n % m);
    }

    static int lcm(int n, int m) {
        return (n * m) / gcd(n, m);
    }
}
