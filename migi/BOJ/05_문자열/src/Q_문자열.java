import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_문자열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < t; i++) {
			String str = br.readLine();
			
			System.out.println("" + str.charAt(0) + str.charAt(str.length() - 1));
		}
	}

}
