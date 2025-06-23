import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_알고리즘수업_알고리즘의수행시간_6 {

	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long n = Integer.parseInt(br.readLine());
		
		// nC3 = n * (n - 1) * (n - 2) / 6
		long result = n * (n - 1) * (n - 2) / 6;
		
		System.out.println(result);
		System.out.println(3);
	}

}
