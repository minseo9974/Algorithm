
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] arr = {'a', 'e', 'i', 'o', 'u'};
        while (true) {
            String str = br.readLine();
            boolean flag = false;
            if (str.equals("end")) {
                break;
            }
            sb.append("<").append(str).append("> is ");
            int a = 0;
            int b = 0;
            for (int i = 0; i < str.length(); i++) {
                boolean or = false;
                if (i != str.length() - 1 && str.charAt(i) == str.charAt(i + 1) && str.charAt(i) != 'e' &&
                        str.charAt(i) != 'o') {
                    flag = false;
                    break;
                }
                for (int j = 0; j < 5; j++) {
                    if (str.charAt(i) == arr[j]) {
                        flag = true;
                        or = true;
                        break;
                    }
                }
                if (or) {
                    a++;
                    b = 0;
                } else {
                    b++;
                    a = 0;
                }
                if (a == 3 || b == 3) {
                    flag = false;
                    break;
                }
            }
            sb.append(flag ? "acceptable." : "not acceptable.").append('\n');
        }
        System.out.println(sb);
    }
}