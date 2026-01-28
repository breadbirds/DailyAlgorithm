import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int arr[][];
	static int mc[];
	static boolean visited[][];
	static int bingo;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[5][5];
		mc = new int[25];
		visited = new boolean[5][5];

		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				mc[i * 5 + j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int k = 0; k < 25; k++) {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					bingo = 0;
					
					if (mc[k] == arr[i][j]) {
						visited[i][j] = true;
					}

					// 행탐색
					int bingoCnt = 0;
					for (int m = 0; m < 5; m++) {

						for (int n = 0; n < 5; n++) {
							if (visited[m][n]) {
								bingoCnt++;
							}
						}

						if (bingoCnt == 5) {
							bingo++;
						}

						bingoCnt = 0;
					}

					// 열탐색
					int bingoCnt2 = 0;
					for (int m = 0; m < 5; m++) {
						for (int n = 0; n < 5; n++) {
							if (visited[n][m]) {
								bingoCnt2++;
							}
						}
						if (bingoCnt2 == 5) {
							bingo++;
						}
						bingoCnt2 = 0;
					}

					// 대각선탐색
					bingoCnt = 0;

					for (int m = 0; m < 5; m++) {
						for (int n = 0; n < 5; n++) {
							if (m == n && visited[m][n] == true) {
								bingoCnt++;
								if (bingoCnt == 5) {
									bingo++;
								}
							}
						}
					}

					bingoCnt = 0;
					for (int m = 0; m < 5; m++) {
						for (int n = 0; n < 5; n++) {
							if ((m + n == 4) && visited[m][n] == true) {
								bingoCnt++;
								if (bingoCnt == 5) {
									bingo++;
								}
							}
						}
					}

				}

			}
			if (bingo >= 3) {
				System.out.println(k + 1);
				break;
			}
		}

	}
}