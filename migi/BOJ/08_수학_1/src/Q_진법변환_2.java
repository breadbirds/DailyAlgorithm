import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_진법변환_2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		StringBuilder result = new StringBuilder();
		
		while (n > 0) {
			int remains = n % b;
			result.append(remains < 10 ? remains : Integer.toString(remains, b).toUpperCase());
			n /= b;
		}

		System.out.println(result == null ? "0" : result.reverse().toString());
	}

}
