import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_소수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		int sum = 0;
		int min = 10_000;
		
		for (int i = n; i <= m; i++) {
			boolean isPrime = i > 1;
			
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					isPrime = false;
					break;
				}
			}
			
			if (isPrime) {
				cnt++;
				sum += i;
				
				if (i < min) {
					min = i;
				}
			}
		}

		if (cnt > 0) {
			System.out.println(sum);
			System.out.println(min);
		} else {
			System.out.println(-1);
		}
	}

}
