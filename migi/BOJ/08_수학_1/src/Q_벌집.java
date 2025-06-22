import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_벌집 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());

		// 1, 2, 3,  4,  5
		// 1, 7, 19, 37, 61
		int currentRoom = 1;
		int cnt = 1;
		
		while (currentRoom < n) {
			cnt++;
			currentRoom += 6 * (cnt - 1);
		}
		
		System.out.println(cnt);
	}

}
