import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int s[][];
	static boolean[] visited;
	static int minDifference = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		s = new int[N][N];
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				s[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 백트래킹으로 팀 나누기
		divideTeam(0, 0);
		System.out.println(minDifference);

	}

	private static void divideTeam(int idx, int count) {
		if (count == N / 2) {
			calculateDifference();
			return;

		}

		for (int i = idx; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				divideTeam(i + 1, count + 1);
				visited[i] = false;
			}
		}

	}

	private static void calculateDifference() {
		int startTeam = 0, linkTeam = 0;
		
		for(int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				if(visited[i] && visited[j]) {
					startTeam += s[i][j] + s[j][i];
				} else if (!visited[i] && !visited[j]) {
					linkTeam += s[i][j] + s[j][i];
				}
			}
		}
		
		int difference = Math.abs(startTeam - linkTeam);
		minDifference = Math.min(minDifference, difference);

	}

}