
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[] prime;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());
        prime = new boolean[(int) (max-min+1)];
        solution(min,max);
        System.out.println(count);
    }

    private static void solution(long min, long max) {
        for (long i = 2; i*i <= max; i++) {
            long mul = i*i;
            long index = min / mul;
            if (min % mul != 0) {
                index++;
            }
            for (long j = index; j*mul <= max; j++) {
                prime[(int)((j*mul) - min)] = true;
            }
        }
        for (int i = 0; i < prime.length; i++) {
            if (!prime[i]) {
                count++;
            }
        }
    }
}