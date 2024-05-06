
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int index = 1;
        while (t-- > 0) {
            int[][] map = new int[10][10];
            int[] check1;
            int[] check2;
            int[] check3;
            boolean flag = false;
            sb.append("#").append(index++).append(" ");
            for (int i = 1; i <= 9; i++) {
                check1 = new int[10];
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= 9; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    check1[map[i][j]]++;
                    if (check1[map[i][j]] > 1) {
                        flag = true;
                    }
                }
            }
            for (int i = 1; i <= 9; i++) {
                check2 = new int[10];
                for (int j = 1; j <= 9; j++) {
                    check2[map[j][i]]++;
                    if (check2[map[j][i]] > 1) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    break;
                }
            }
            for (int i = 1; i <=7 ; i+=3) {
                for (int j = 1; j <7 ; j+=3) {
                    check3 = new int[10];
                    for (int k= 0; k < 3; k++) {
                        for (int l = 0; l < 3; l++) {
                            check3[map[i + k][j + l]]++;
                            if (check3[map[i + k][j + l]] > 1) {
                                flag = true;
                                break;
                            }
                        }
                    }
                    if (flag) {
                        break;
                    }
                }
            }
            sb.append(flag ? 0 : 1).append('\n');
        }
        System.out.println(sb);
    }
}