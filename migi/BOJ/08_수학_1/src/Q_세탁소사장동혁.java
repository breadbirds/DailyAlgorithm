import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_세탁소사장동혁 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int t = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			
			int c = Integer.parseInt(st.nextToken());
			int[] units = new int[] { 25, 10, 5, 1 };
			
			for (int j = 0; j < 4; j++) {
				System.out.print(c / units[j] + " ");
				c %= units[j];
			}
			System.out.println();
		}
	}

}
