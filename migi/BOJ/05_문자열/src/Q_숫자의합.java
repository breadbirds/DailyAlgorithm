import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_숫자의합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();

		int sum = 0;
		
		for (int i = 0; i < n; i++) {
			sum += Integer.parseInt(str.charAt(i) + "");
		}
		
		System.out.println(sum);
	}

}
