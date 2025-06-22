import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_팰린드롬인지확인하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		
		int result = 1;
		
		for (int i = 0; i < str.length() / 2; i++) {
			if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
				result = 0;
				break;
			}
		}
		
		System.out.println(result);
	}

}
