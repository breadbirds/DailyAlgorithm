import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_분해합 {
	
	private static int N;
	private static int L;
	private static int[] selectedArr;
//	private static boolean[] isSelected = new boolean[10];
	private static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		L = String.valueOf(N).length();
		
		selectedArr = new int[L];
		
		perm(0, 0, "");
		
		System.out.println(result == Integer.MAX_VALUE ? 0 : result);
	}
	
	private static void perm(int cnt, int sum, String sumStr) {
		if (cnt == L) {
			int temp = Integer.parseInt(sumStr);
			if (sum + temp == N) {
				result = Math.min(result, temp);
			}
			return;
		}
		
		for (int i = 0; i < 10; i++) {
//			if (isSelected[i]) {
//				continue;
//			}
			
//			isSelected[i] = true;
			selectedArr[cnt] = i;
			perm(cnt + 1, sum + i, sumStr + i);
//			isSelected[i] = false;
		}
	}
	
}
