
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int result = binarySearch(Integer.parseInt(st.nextToken()));
            if (result != -1){
                sb.append(1).append('\n');
            }else{
                sb.append(0).append('\n');
            }
        }
        System.out.println(sb.toString());
        
    }

    public static int binarySearch(int key) {
        int li = 0;
        int ri = arr.length - 1;

        while (li <= ri) {
            int mid = (li + ri) / 2;
            if (key < arr[mid]) {
                ri = mid - 1;
            } else if (key > arr[mid]) {
                li = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
