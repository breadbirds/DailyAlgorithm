import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_알고리즘수업_점근적표기_1 {

	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a1 = Integer.parseInt(st.nextToken()); // f(n) = a1 * n + a0
		int a0 = Integer.parseInt(st.nextToken());
		
		int c = Integer.parseInt(br.readLine()); // g(n) = n
		int n0 = Integer.parseInt(br.readLine());
		
		int fn0 = a1 * n0 + a0;
		int gn0 = c * n0;
		
		System.out.println(fn0 <= gn0 && a1 <= c ? 1 : 0);
	}

}
