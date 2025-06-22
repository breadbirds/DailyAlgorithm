import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Q_크로아티아알파벳 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		
		List<String> list = List.of("c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=");
	
		int result = 0;
		
		for (int i = 0; i < str.length(); i++) {
			if (i + 1 < str.length() && list.contains("" + str.charAt(i) + str.charAt(i + 1))) {
				i += 1;
			} else if (i + 2 < str.length() && list.contains("" + str.charAt(i) + str.charAt(i + 1) + str.charAt(i + 2))) {
				i += 2;
			}
			result++;
		}
		
		System.out.println(result);
	}

}
