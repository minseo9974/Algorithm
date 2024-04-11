
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int n, cnt;
    static ArrayList<Integer> primeNumber = new ArrayList<>();
    static boolean isPrime[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        isPrime = new boolean[n + 1];
        prime();
        for (int i = 2; i <= n; i++) {
            if (!isPrime[i]) {
                primeNumber.add(i);
            }
        }
        int size = primeNumber.size();
        for (int i = 0; i < size; i++) {
            int sum = 0;
            for (int j = i; j < size; j++) {
                sum += primeNumber.get(j);
                if (sum > n) {
                    break;
                }
                if (sum == n) {
                    cnt++;
                    break;
                }
            }
        }
        System.out.println(cnt);
    }

    private static void prime() {
        isPrime[0] = isPrime[1] = true;
        for (int i = 2; i * i <= n; i++) {
            if (!isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = true;
                }
            }
        }
    }

}