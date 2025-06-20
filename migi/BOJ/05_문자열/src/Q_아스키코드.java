import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_아스키코드 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();

		System.out.println(str.charAt(0) - 0);
	}

}
