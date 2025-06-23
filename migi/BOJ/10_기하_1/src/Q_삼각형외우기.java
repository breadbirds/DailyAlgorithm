import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Q_삼각형외우기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int sum = 0;
		Set<Integer> set = new HashSet<>();
		
		for (int i = 0; i < 3; i++) {
			int angle = Integer.parseInt(br.readLine());
			
			sum += angle;
			set.add(angle);
		}
		
		String result = "";
		if (sum == 180) {
			if (set.size() == 1) {
				result = "Equilateral";
			} else if (set.size() == 2) {
				result = "Isosceles";
			} else {
				result = "Scalene";
			}
		} else {
			result = "Error";
		}
		
		System.out.println(result);
	}

}
