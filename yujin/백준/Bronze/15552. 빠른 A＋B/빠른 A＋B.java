import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T, A, B;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			sb.append(A+B).append('\n');
		}
		System.out.println(sb);
	}

}