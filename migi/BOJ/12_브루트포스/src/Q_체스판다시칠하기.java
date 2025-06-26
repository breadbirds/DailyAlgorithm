import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_체스판다시칠하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		char[][] arr = new char[n][m];

		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = line.charAt(j);
			}
		}

		int result = (n * m) / 2;

		for (int i = 0; i <= n - 8; i++) {
			for (int j = 0; j <= m - 8; j++) {
				int startWCnt = 0;
				int startBCnt = 0;
				
				for (int y = i; y < i + 8; y++) {
					for (int x = j; x < j + 8; x++) {
						if (y % 2 == 0) {
							if (x % 2 == 0) {
								if (arr[y][x] == 'B') {
									startWCnt++;
								} else {
									startBCnt++;
								}
							}

							if (x % 2 != 0) {
								if (arr[y][x] == 'W') {
									startWCnt++;
								} else {
									startBCnt++;
								}
							}
						}

						if (y % 2 != 0) {
							if (x % 2 == 0) {
								if (arr[y][x] == 'W') {
									startWCnt++;
								} else {
									startBCnt++;
								}
							}

							if (x % 2 != 0) {
								if (arr[y][x] == 'B') {
									startWCnt++;
								} else {
									startBCnt++;
								}
							}
						}
					}
				}

				result = Math.min(result, Math.min(startWCnt, startBCnt));
			}
		}

		System.out.println(result);
	}

}
