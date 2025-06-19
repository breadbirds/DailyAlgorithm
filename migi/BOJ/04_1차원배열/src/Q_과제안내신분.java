import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_과제안내신분 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[] array = new int[31];
		
		for (int i = 0; i < 28; i++) {
			st = new StringTokenizer(br.readLine());
			
			int num = Integer.parseInt(st.nextToken());
			
			array[num] = 1;
		}

		for (int i = 1; i <= 30; i++) {
			if (array[i] == 0) {
				System.out.println(i);
			}
		}
	}

}
