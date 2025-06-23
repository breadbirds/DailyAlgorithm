import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q_세막대 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] list = new int[] { a, b, c };	
		Arrays.sort(list);
		
		int result = 0;
		
		if (a == b && b == c) {
			result = a + b + c;
		} else {
			if (list[0] + list[1] > list[2]) {
				result = list[0] + list[1] + list[2];
			} else {
				result = (list[0] + list[1]) * 2 - 1;
			}
		}
		
		System.out.println(result);
	}

}
