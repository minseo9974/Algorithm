
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        boolean isHead = false;
        boolean isHand = false;
        boolean isBack = false;
        boolean isLeg = false;
        int heart = 0;
        int heartI = 0;
        int first = Integer.MAX_VALUE;
        int last = 0;
        int left = 0;
        int right = 0;
        for (int i = 1; i <= n; i++) {
            String cookie = br.readLine();
            int back = 0;
            for (int j = 0; j < cookie.length(); j++) {
                if (!isHead && cookie.charAt(j) == '*') {
                    sb.append(i + 1).append(" ").append(j + 1).append('\n');
                    isHead = true;
                    heart = j;
                    heartI = i + 1;
                    break;
                }
                if (isHead && !isHand && cookie.charAt(j) == '*') {
                    first = Math.min(first, j);
                    last = Math.max(last, j);
                }
                if (isHead && isHand && !isBack && cookie.charAt(j) == '*') {
                    back++;
                }
                if (isHead && isHand && isBack && !isLeg && cookie.charAt(j) == '*') {
                    if (j == heart - 1) {
                        left++;
                    } else if (j == heart + 1) {
                        right++;
                    }
                }
            }
            if (!isBack && back == 2) {
                sb.append(i - heartI-1).append(" ");
                isBack = true;
            }
            if (!isHand && last != 0) {
                isHand = true;
                sb.append(heart - first).append(" ").append(last - heart).append(" ");
            }
        }
        sb.append(left+1).append(" ").append(right+1);
        System.out.println(sb);
    }
}