import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int arr[][] = new int[1001][1001];
	static boolean visited[][] = new boolean[1001][1001];
	static int x1, y1, weight, height;
	static int cnt[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			weight = Integer.parseInt(st.nextToken());
			height = Integer.parseInt(st.nextToken());

			int x2 = x1 + weight;
			int y2 = y1 + height;
			cnt = new int[N + 1];

			for (int m = x1; m < x2; m++) {
				for (int n = y1; n < y2; n++) {
					if (arr[m][n] != i) {
						arr[m][n] = i;
					}

				}
			}

		}
		for (int i = 0; i < 1001; i++) {
			for (int j = 0; j < 1001; j++) {
				if (arr[i][j] != 0) {
					cnt[arr[i][j]]++;
				}
			}
		}
		for (int i = 1; i <= N; i++) {
			System.out.println(cnt[i]);
		}

	}

}