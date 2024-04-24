
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, c;
    static long[] arr;
    static long min, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(arr);
        max = arr[n - 1];
        min = 1;
        while (min <= max) {
            long distance = min + ((max - min) / 2);
            long sum = 1;
            int index = 0;
            for (int i = 1; i < n; i++) {
                if ((arr[i] - arr[index]) >= distance) {
                    index = i;
                    sum++;
                }
            }

            if (sum < c) {
                max = distance -1;
            }else{
                min = distance + 1;
            }
        }
        System.out.println(min-1);
    }
}