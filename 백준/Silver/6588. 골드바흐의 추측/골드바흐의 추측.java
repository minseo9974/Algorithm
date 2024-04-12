
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean[] prime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        prime = new boolean[1000001];
        int n = Integer.parseInt(br.readLine());
        isPrime();
        while (n != 0) {
            boolean check = false;
            for (int i = 2; i <= n/2; i++) {
                if (!prime[i] && !prime[n - i]) {
                    check = true;
                    sb.append(n).append(" = ").append(i).append(" + ").append(n - i).append('\n');
                    break;
                }
            }
            if (!check) {
                sb.append("Goldbach's conjecture is wrong.").append('\n');
            }
            n = Integer.parseInt(br.readLine());
        }
        System.out.println(sb);

    }

    private static void isPrime() {
        prime[0] = prime[1] = true;
        for (int i = 2; i * i < prime.length; i++) {
            if (!prime[i]) {
                for (int j = i * i; j < prime.length; j += i) {
                    prime[j] = true;
                }
            }
        }
    }

}