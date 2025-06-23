import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_알고리즘수업_알고리즘의수행시간_4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long n = Integer.parseInt(br.readLine());
		
		System.out.println(n * (n - 1) / 2);
		System.out.println(2);
	}

}
