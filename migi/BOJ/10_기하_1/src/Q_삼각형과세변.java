import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Q_삼각형과세변 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		while (!(a == 0 && b == 0 && c == 0)) {
			int max = Math.max(a, Math.max(b, c));
			
			Set<Integer> set = new HashSet<>();
			set.add(a);
			set.add(b);
			set.add(c);
			
			String result = "";
			if (a + b + c - max > max) {
				if (set.size() == 1) {
					result = "Equilateral";
				} else if (set.size() == 2) {
					result = "Isosceles";
				} else {
					result = "Scalene";
				}
			} else {
				result = "Invalid";
			}
			
			System.out.println(result);
		
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
		}
	}

}
