import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_알람시계 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int result = 0;
		
		if (a == b && b == c) {
			result = 10000 + a * 1000;
		} else if (a == b && b != c) {
			result = 1000 + a * 100;
		} else if (b == c && a != b) {
			result = 1000 + b * 100;
		} else if (c == a && a != b) {
			result = 1000 + c * 100;
		} else {
			result = Math.max(Math.max(a, b), Math.max(b, c)) * 100;
		}
		
		System.out.println(result);
	}

}
