import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_최소최대 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		
		int min = 1_000_000;
		int max = -1_000_000;
		
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if (num < min) {
				min = num;
			}
			
			if (num > max) {
				max = num;
			}
		}

		System.out.println(min + " " + max);
	}

}
