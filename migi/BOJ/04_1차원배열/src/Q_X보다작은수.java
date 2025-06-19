import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_X보다작은수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		String result = "";
		
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if (num < x) {
				result += num + " ";
			}
		}

		System.out.println(result);
	}

}
