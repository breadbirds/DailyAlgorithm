import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_소인수분해 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		for (int i = 2; i <= n; i++) {
			while (n % i == 0) {
				n /= i;
				System.out.println(i);
			}
		}
	}

}
