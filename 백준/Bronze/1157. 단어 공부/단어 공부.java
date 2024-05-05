import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] words = new int[26];
        int max = 0;
        for (int i = 0; i < str.length(); i++) {
            int num = str.charAt(i) - 'A';
            if (num >= 32) {
                num -= 32;
            }
            words[num]++;
            max = Math.max(max, words[num]);
        }
        int cnt = 0;
        int index = 0;
        for (int i = 0; i < words.length; i++) {
            if (max == words[i]) {
                cnt++;
                index = i;
            }
        }
        if (cnt > 1) {
            System.out.println("?");
        }else{
            System.out.println((char)(index+65));
        }
    }
}