
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[3];
            arr[0] = Integer.parseInt(st.nextToken());
            arr[1] = Integer.parseInt(st.nextToken());
            arr[2] = Integer.parseInt(st.nextToken());
            if (arr[0] == 0) {
                break;
            }
            Arrays.sort(arr);
            if (arr[0] == arr[1] && arr[1] == arr[2]) {
                sb.append("Equilateral").append('\n');
            } else if (arr[2] >= (arr[0] + arr[1])) {
                sb.append("Invalid").append('\n');
            } else if (arr[0] != arr[1] && arr[1] != arr[2] && arr[0] != arr[2]) {
                sb.append("Scalene").append('\n');
            } else {
                sb.append("Isosceles").append('\n');
            }
        }
        System.out.println(sb);


    }
}