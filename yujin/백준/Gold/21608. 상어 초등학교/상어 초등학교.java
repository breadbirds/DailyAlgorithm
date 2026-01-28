import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int room[][];
	static int saticefy;
	static int num, love1, love2, love3, love4;
	static int happy;
	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { -1, 0, 1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		room = new int[N + 1][N + 1];
		Map<Integer, List<Integer>> loves = new HashMap<>();

		for (int i = 0; i < N * N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken());
			love1 = Integer.parseInt(st.nextToken());
			love2 = Integer.parseInt(st.nextToken());
			love3 = Integer.parseInt(st.nextToken());
			love4 = Integer.parseInt(st.nextToken());

			// 학생의 좋아하는 학생들을 리스트로 저장
			List<Integer> love = Arrays.asList(love1, love2, love3, love4);
			loves.put(num, love);

			placeStudent(num, loves);
		}
		System.out.println(happy(loves));

	}

	private static void placeStudent(int student, Map<Integer, List<Integer>> loves) {
		int bestX = -1;
		int bestY = -1;
		int maxLike = -1;
		int maxEmpty = -1;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (room[i][j] != 0)
					continue;

				int likeCnt = 0;
				int emptyCnt = 0;

				for (int dir = 0; dir < 4; dir++) {
					int nx = i + dx[dir];
					int ny = j + dy[dir];

					if (nx < 1 || ny < 1 || nx >= N + 1 || ny >= N + 1) {
						continue;
					}
					if (room[nx][ny] == 0) {
						emptyCnt++;
					} else if (loves.get(student).contains(room[nx][ny])) {
						likeCnt++;
					}

					if (likeCnt > maxLike || (likeCnt == maxLike && emptyCnt > maxEmpty)) {
						bestX = i;
						bestY = j;
						maxLike = likeCnt;
						maxEmpty = emptyCnt;
					}
				}
			}
			
		}
		room[bestX][bestY] = student;
	}

	private static int happy(Map<Integer, List<Integer>> loves) {
		int totalHappy = 0;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				int student = room[i][j];
				int likeCnt = 0;

				for (int dir = 0; dir < 4; dir++) {
					int nx = i + dx[dir];
					int ny = j + dy[dir];

					if (nx < 1 || ny < 1 || nx >= N + 1 || ny >= N + 1) {
						continue;
					}
					if (loves.get(student).contains(room[nx][ny])) {
						likeCnt++;
					}
				}
				if (likeCnt > 0) {
					totalHappy += (int) Math.pow(10, likeCnt - 1);
				}
			}
		}
		return totalHappy;
	}

}