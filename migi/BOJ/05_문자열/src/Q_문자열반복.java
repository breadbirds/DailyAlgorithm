import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_문자열반복 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			
			int r = Integer.parseInt(st.nextToken());
			String s = st.nextToken();
			
			String result = "";
			
			for (int j = 0; j < s.length(); j++) {
				for (int k = 0; k < r; k++) {
					result += s.charAt(j) + "";
				}
			}
			
			System.out.println(result);
		}
	}

}
