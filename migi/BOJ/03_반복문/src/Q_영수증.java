import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_영수증 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int totalPrice = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(bf.readLine());
		int totalCount = Integer.parseInt(st.nextToken());
		
		int sumPrice = 0;
		
		for (int i = 0; i < totalCount; i++) {
			st = new StringTokenizer(bf.readLine());
			
			int price = Integer.parseInt(st.nextToken());
			int count = Integer.parseInt(st.nextToken());
			
			sumPrice += price * count;
		}

		String result = totalPrice == sumPrice ? "Yes" : "No";
		System.out.println(result);
	}

}
