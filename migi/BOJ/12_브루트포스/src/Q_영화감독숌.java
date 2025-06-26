import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_영화감독숌 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int current = 666;
		
		while (n > 0) {
			String currentStr = String.valueOf(current);
			if (currentStr.contains("666")) {
				n--;
			}
			current++;
		}

		System.out.println(current - 1);
	}

}
