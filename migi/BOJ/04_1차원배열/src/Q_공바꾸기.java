import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_공바꾸기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] array = new int[n];
		
		for (int i = 0; i < n; i++) {
			array[i] = i + 1;
		}
		
		for (int x = 0; x < m; x++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken()) - 1;
			int j = Integer.parseInt(st.nextToken()) - 1;
			
			int temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}

		for (int i = 0; i < n; i++) {
			System.out.print(array[i] + " ");
		}
	}

}
