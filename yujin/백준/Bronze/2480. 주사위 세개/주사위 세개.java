import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int a, b, c;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		

		int big = Math.max(a, Math.max(b, c));
		

		if (a == b && a == c && b == c) {
			System.out.println(10000 + (a * 1000));
		} else if (a == b && b != c) {
			System.out.println(1000 + a * 100);
		} else if (b == c && b != a) {
			System.out.println(1000 + b * 100);
		} else if (a == c && b != c) {
			System.out.println(1000 + a * 100);
		} else if (a != b && b != c) {
			System.out.println(big * 100);
		}

	}

}