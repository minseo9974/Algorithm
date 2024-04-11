
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
        isPrime = new boolean[n+1];
        prime();
        for (int i = 2; i <= n ; i++) {
            if (!isPrime[i]) {
                primeNumber.add(i);
            }
        }
        recur(0);
        System.out.println(cnt);
    }

    private static void recur(int sum) {
        for (Integer p : primeNumber) {
            sum += p;
            if (sum == n) {
                cnt++;
            }
            if (sum > n) {
                primeNumber.remove(0);
                recur(0);
                return;
            }
        }
    }

    private static void prime() {
        isPrime[0] = isPrime[1] = true;
        for (int i = 2; i*i <= n ; i++) {
            if (!isPrime[i]) {
                for (int j = i*i; j <=n ; j+=i) {
                    isPrime[j]=true;
                }
            }
        }
    }

}