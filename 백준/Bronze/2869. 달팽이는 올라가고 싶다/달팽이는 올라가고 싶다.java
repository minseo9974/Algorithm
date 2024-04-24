import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long a, b, v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        v = Long.parseLong(st.nextToken());
        long count;
        count = (v - b) / (a - b);
        if ((v - b) % (a - b) != 0) {
            count++;
        }
        System.out.println(count);

    }
}