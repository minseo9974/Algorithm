
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int t;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            fibo(Integer.parseInt(br.readLine()));
        }
        System.out.println(sb);
    }

    private static void fibo(int num) {
        int tmp;
        int tmp1 = 1;
        int tmp2 = 0;
        if (num == 0) {
            sb.append("1 0").append('\n');
        }else {
            for (int i = 1; i <= num; i++) {
                tmp = tmp1 + tmp2;
                tmp1 = tmp2;
                tmp2 = tmp;
            }
            sb.append(tmp1).append(" ").append(tmp2).append('\n');
        }
    }
}