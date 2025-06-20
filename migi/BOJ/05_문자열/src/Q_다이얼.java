import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_다이얼 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String s = st.nextToken();
		
		int result = 0;
		
		for (int i = 0; i < s.length(); i++) {
			if ("ABC".contains("" + s.charAt(i))) {
				result += 2;
			}
			
			if ("DEF".contains("" + s.charAt(i))) {
				result += 3;
			}
			
			if ("GHI".contains("" + s.charAt(i))) {
				result += 4;
			}
			
			if ("JKL".contains("" + s.charAt(i))) {
				result += 5;
			}
			
			if ("MNO".contains("" + s.charAt(i))) {
				result += 6;
			}
			
			if ("PQRS".contains("" + s.charAt(i))) {
				result += 7;
			}
			
			if ("TUV".contains("" + s.charAt(i))) {
				result += 8;
			}
			
			if ("WXYZ".contains("" + s.charAt(i))) {
				result += 9;
			}
			
			result++;
		}
		
		System.out.println(result);
	}

}
