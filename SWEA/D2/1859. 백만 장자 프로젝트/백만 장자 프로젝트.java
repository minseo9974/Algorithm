import java.io.*;
import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());


      
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            long sum = 0;
            int max = arr[n - 1];
            for(int i=n-2; i>=0; i--){
                if (max > arr[i]) {
                    sum += max - arr[i];
                }
                else{
                    max = arr[i];
                }
            }
            sb.append("#").append(test_case).append(" ").append(sum).append('\n');
        }
        System.out.println(sb);
    }
}