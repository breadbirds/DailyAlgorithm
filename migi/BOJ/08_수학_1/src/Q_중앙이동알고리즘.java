import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_중앙이동알고리즘 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		// 0, 1, 2, 3, 4,  5
		// 2, 3, 5, 9, 17, 33
		int[] arr = new int[n + 1];
		arr[0] = 2;
		
		for (int i = 1; i <= n; i++) {
			arr[i] = 2 * arr[i - 1] - 1;
		}
		
		System.out.println(arr[n] * arr[n]);
	}

}
