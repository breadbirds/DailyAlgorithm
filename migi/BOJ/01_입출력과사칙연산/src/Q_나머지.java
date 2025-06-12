import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_나머지 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int a = Integer.parseInt(br.readLine());
		
		String strB = br.readLine();
		
		int sum = 0;
		
		for (int i = 0; i < strB.length(); i++) {
			int num = Integer.parseInt(strB.charAt(strB.length() - 1 - i) + "");
			sum += a * num * Math.pow(10, i);
			System.out.println(a * num);
		}
		
		System.out.println(sum);
	}

}
