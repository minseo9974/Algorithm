
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        arr = new int[n];
        for (int i = 0; i <n; i++) {
            arr[i] =  Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            int input = Integer.parseInt(st.nextToken());
            if (searchKey(input)) {
                sb.append(1).append(" ");
            }
            else{
                sb.append(0).append(" ");
            }
        }
        System.out.println(sb.toString());
    }

    public static boolean searchKey(int key) {
        int li = 0;
        int ri = arr.length-1;
        while (li <= ri) {
            int mid = (li+ri)/2;
            if (key <arr[mid]){
                ri = mid-1;
            } else if (key > arr[mid]) {
                li = mid + 1;
            }else{
                return true;
            }
        }
        return false;
    }

}