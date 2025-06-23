import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_수학은체육과목입니다 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long n = Long.parseLong(br.readLine());
		
		// 1, 2,  3
		// 4, 8,  12
		// 4, 2 + 1 + (2 * 2) + (2 - 1), 3 + 2 + 1 + (3 * 2) + (3 - 1)
		long result = n == 1 ? 4 : (1 + n) * 2 / 2 + n * 2 + n - 1;
		
		System.out.println(result);
	}

}
