import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_평균 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int[] array = new int[n];
		double max = 0d;
		
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if (num > max) {
				max = num;
			}
			
			array[i] = num;
		}
		
		double sum = 0d;
		
		for (int i = 0; i < n; i++) {
			sum += array[i] / max * 100;
		}
		

		System.out.println(sum / n);
	}

}
