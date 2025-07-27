package source_code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// �Ÿ��� K ������ �ܹ��Ÿ� ���� �� ����
// ��Ź ���� N, �ܹ��� ���� ���� �Ÿ� K, �ܹ��� ���� �� �ִ� ��� �ִ� �� ���ϱ�
// P: ���, H: �ܹ���

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

	// �ش� ����� �ܹ��Ÿ� ���� �� �ִ��� ���� Ȯ��
	private static boolean calculatePossibility(int selectLength, char[] table, int i) {
		int m = 0;

		// �������� ���鼭 ������ �Ÿ� �ȿ��� ���� �� �ִ� �ܹ��Ű� �ִ��� üũ\
		// ������ ���� �� ������ Ž��
		while (selectLength >= m) {
			if (i - selectLength + m < 0) {
				m++;
				continue;
			}

			if (table[i - selectLength + m] == 'H') {
				table[i - selectLength + m] = 'X'; // X�� ������ ǥ��
				return true;
			} else {
				m++;
			}
		}

		// ���ʿ��� �ܹ��Ÿ� ���Ծ��ٸ� ������ Ž��
		// �������� ����� ������ Ž��
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
