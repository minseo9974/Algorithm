import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a,b;
		do {
		a = Integer.parseInt(br.readLine());
		b = Integer.parseInt(br.readLine());
		}while(a==0||b==0);
		if(a>0) {
			if(b>0) {
				System.out.println("1");
			}
			else {
				System.out.println("4");
			}
		}
		else {
			if(b>0) {
				System.out.println("2");
			}
			else {
				System.out.println("3");
			}
		}
	}

}
