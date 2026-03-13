import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();

		int n = 0;

		while (n != -1) {
			
			n = Integer.parseInt(br.readLine());
			 if (n == -1) break;
			StringBuilder sb = new StringBuilder();
			int sum = 0;

			for (int i = 2; i < n; i++) {

				if (n % i == 0) {
					sum += i;
					sb.append(" + ").append(i);
//					list.add(i);

				}
			}
			if (sum + 1 == n) {
				System.out.println(n + " = 1" + sb);
			} else {
				System.out.println(n + " is NOT perfect.");
			}
		}
	}

}