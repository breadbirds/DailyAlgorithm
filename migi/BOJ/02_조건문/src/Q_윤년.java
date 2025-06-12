import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_윤년 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int x = Integer.parseInt(br.readLine());
		int y = Integer.parseInt(br.readLine());
		
		int result = 0;
		
		if (x > 0 && y > 0) {
			result = 1;
		} else if (x < 0 && y > 0) {
			result = 2;
		} else if (x < 0 && y < 0) {
			result = 3;
		} else {
			result = 4;
		}
		
		System.out.println(result);
	}

}
