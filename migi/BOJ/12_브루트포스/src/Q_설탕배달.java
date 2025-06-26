import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_설탕배달 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		int result = n;
		
		for (int i = 0; i <= n / 5; i++) {
			for (int j = 0; j <= n / 3; j++) {
				if (i * 5 + j * 3 == n) {
					result = Math.min(result, i + j);
				}
			}
		}

		System.out.println(result == n ? -1 : result);
	}

}
