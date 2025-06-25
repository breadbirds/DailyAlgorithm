import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_블랙잭 {
	
	private static int N;
	private static int M;
	private static int[] inputArr;
	private static int[] selectedArr;
	private static int result = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		inputArr = new int[N];
		selectedArr = new int[3];
		
		for (int i = 0; i < N; i++) {
			inputArr[i] = Integer.parseInt(st.nextToken());
 		}
		
		comb(0, 0, 0);
		
		System.out.println(result);
	}
	
	private static void comb(int start, int cnt, int sum) {
		if (cnt == 3) {
			if (sum <= M) {
				// System.out.println(Arrays.toString(selectedArr));
				result = Math.max(result, sum);
			}
			return;
		}
		
		for (int i = start; i < N; i++) {
			selectedArr[cnt] = inputArr[i];
			comb(i + 1, cnt + 1, sum + inputArr[i]);
		}
	}
	
}
