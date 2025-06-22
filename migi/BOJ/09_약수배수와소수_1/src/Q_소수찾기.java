import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_소수찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int result = 0;
		
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			boolean isPrime = num > 1;
			
			for (int j = 2; j < num; j++) {
				if (num % j == 0) {
					isPrime = false;
				}
			}
			
			if (isPrime) {
				result++;
			}
		}
		
		System.out.println(result);
	}

}
