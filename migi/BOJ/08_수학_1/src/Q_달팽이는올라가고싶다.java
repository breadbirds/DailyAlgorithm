import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_달팽이는올라가고싶다 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		
		int case1 = v % (a - b) == 0 ? v / (a - b) : v / (a - b) + 1;
		int case2 = (v - b) % (a - b) == 0 ? (v - b) / (a - b) : (v - b) / (a - b) + 1;
		
		System.out.println(Math.min(case1, case2));
	}

}
