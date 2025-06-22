import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_약수구하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int cnt = 1;
		int current = 1;
		int factor = 1;
		
		while (current < n && cnt < k) {
			current++;
			
			if (n % current == 0) {
				cnt++;
				factor = current;
			}
		}
		
		System.out.println(cnt < k ? 0 : factor);
	}

}
