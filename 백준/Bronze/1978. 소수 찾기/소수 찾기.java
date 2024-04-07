import java.io.BufferedReader;
import java.io.InputStreamReader;


class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (isPrime(Integer.parseInt(arr[i]))) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
