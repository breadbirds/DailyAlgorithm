package baekjoon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// �Է�: ������ �� N / ����� �˰� ���� ���� K // �� ������ 1~N ������ ������ ǥ��
// ���: �Է¹��� ���� K�� ���

public class B_S5_8979_Olympics {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int countryCnt = sc.nextInt();
		int targetCountry = sc.nextInt();

		List<int[]> medalList = new ArrayList<>();

		for (int i = 0; i < countryCnt; i++) {
			medalList.add(new int[] { sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt() });
		}

		// ��, ��, �� ������ �������� ����
		medalList.sort((a, b) -> {
			if (a[1] != b[1])
				return b[1] - a[1];
			if (a[2] != b[2])
				return b[2] - a[2];
			return b[3] - a[3];
		});

		int rank = 1;

		for (int i = 0; i < countryCnt; i++) {
			if (i > 0) {
				int[] prev = medalList.get(i - 1);
				int[] curr = medalList.get(i);

				if (!(prev[1] == curr[1] && prev[2] == curr[2] && prev[3] == curr[3])) {
					rank = i + 1;
				}
			}

			if (medalList.get(i)[0] == targetCountry) {
				break;
			}
		}
		
		System.out.println(rank);
	}

}
