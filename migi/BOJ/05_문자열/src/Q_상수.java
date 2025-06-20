import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_상수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String a = st.nextToken();
		String b = st.nextToken();
		
		int aNum = Integer.parseInt("" + a.charAt(2) + a.charAt(1) + a.charAt(0));
		int bNum = Integer.parseInt("" + b.charAt(2) + b.charAt(1) + b.charAt(0));
		
		System.out.println(aNum > bNum ? aNum : bNum);
	}

}
