import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_진법변환 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 0, 1, 2, ..., 9, A, B, ..., Z
		String n = st.nextToken();
		int b = Integer.parseInt(st.nextToken());
		
		int result = 0;
		
		for (int i = 0; i < n.length(); i++) {
			char ch = n.charAt(n.length() - 1 - i);
			int num = ch >= 65 ? ch - 65 + 10 : ch - 48; // 알파벳, 숫자 구분 
			
			result += Math.pow(b, i) * num;
		}

		System.out.println(result);
	}

}
