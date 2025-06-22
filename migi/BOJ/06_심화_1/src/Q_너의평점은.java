import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Q_너의평점은 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		float sum = 0f;
		float total = 0f;

		Map<String, Float> map = Map.of(
				"A+", 4.5f,
				"A0", 4.0f,
				"B+", 3.5f,
				"B0", 3.0f,
				"C+", 2.5f,
				"C0", 2.0f,
				"D+", 1.5f,
				"D0", 1.0f,
				"F", 0.0f
		);
		
		for (int i = 0; i < 20; i++) {
			String str = br.readLine();
			
			String[] arr = str.split(" ");
			
			if (!arr[2].equals("P")) {
				float credit = Float.parseFloat(arr[1]);
				sum += credit * map.get(arr[2]);
				total += credit;
			}
		}
		
		System.out.println(sum / total);
	}

}
