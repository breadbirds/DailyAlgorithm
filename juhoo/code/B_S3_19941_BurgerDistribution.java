package source_code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 거리가 K 이하인 햄버거를 먹을 수 있음
// 식탁 길이 N, 햄버거 선택 가능 거리 K, 햄버거 먹을 수 있는 사람 최대 수 구하기
// P: 사람, H: 햄버거

public class B_S3_19941_BurgerDistribution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		int tableLength = Integer.parseInt(input[0]);
		int selectLength = Integer.parseInt(input[1]);

		char[] table = br.readLine().toCharArray();

		int canEatHamburgerCnt = 0;

		for (int i = 0; i < tableLength; i++) {
			if (table[i] == 'P') {
				boolean possibility = calculatePossibility(selectLength, table, i);

				if (possibility == true) {
					canEatHamburgerCnt++;
				}
			}
		}

		System.out.println(canEatHamburgerCnt);
	}

	// 해당 사람이 햄버거를 먹을 수 있는지 여부 확인
	private static boolean calculatePossibility(int selectLength, char[] table, int i) {
		int m = 0;

		// 왼쪽으로 가면서 정해진 거리 안에서 먹을 수 있는 햄버거가 있는지 체크\
		// 왼쪽은 제일 먼 곳부터 탐색
		while (selectLength >= m) {
			if (i - selectLength + m < 0) {
				m++;
				continue;
			}

			if (table[i - selectLength + m] == 'H') {
				table[i - selectLength + m] = 'X'; // X로 먹음을 표시
				return true;
			} else {
				m++;
			}
		}

		// 왼쪽에서 햄버거를 못먹었다면 오른쪽 탐색
		// 오른쪽은 가까운 곳부터 탐색
		m = 1;
		while (i + m < table.length && selectLength >= m) {
			if (table[i + m] == 'H') {
				table[i + m] = 'X';
				return true;
			} else {
				m++;
			}
		}

		return false;
	}

}
