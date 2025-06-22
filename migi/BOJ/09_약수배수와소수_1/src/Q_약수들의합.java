import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q_약수들의합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		while (n != -1) {
			List<Integer> list = new ArrayList<>();
			int sum = 0;
			
			for (int i = 1; i < n; i++) {
				if (n % i == 0) {
					list.add(i);
					sum += i;
				}
			}
			
			String result = "";

			if (sum == n) {
				result += n + " = ";
				for (int i = 0; i < list.size(); i++) {
					result += list.get(i);
					if (i != list.size() - 1) {
						result += " + ";
					}
				}
			} else {
				result = n + " is NOT perfect.";
			}
			
			System.out.println(result);
			
			n = Integer.parseInt(br.readLine());
		}		
	}

}
