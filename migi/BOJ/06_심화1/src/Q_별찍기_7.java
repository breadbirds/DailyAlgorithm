import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_별찍기_7 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		// 2 * n - 1
		// 1 3 5 7 9
		for (int i = 1; i <= n; i++) {
			for (int j = n - i; j > 0; j--) {
				System.out.print(" ");
			}
			
			for (int k = 0; k < 2 * i - 1; k++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
		
		// 7 5 3 1
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			
			for (int k = 2 * (n - i) - 1; k > 0; k--) {
				System.out.print("*");
			}
			
			System.out.println();
		}
	}

}
