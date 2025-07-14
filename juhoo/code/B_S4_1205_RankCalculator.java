package source_code;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// �Է�: N(����Ʈ�� ���� ����), ���ο� ����, P(��ŷ ����Ʈ�� �ö� �� �� �ִ� ���� ����)
// �Է�: N���� ���� ������������� ����
// ���: �¼��� new ������ ���

// 1. �Է¹ޱ�
// 1-1. ���� ����, �¼� ����, ����Ʈ ��ü ũ�� ����
// 1-2. ���� ����Ʈ�� �������� ����Ʈ�� ����

// 2. ��� ���ϱ�

// 3. ����ϱ�

public class B_S4_1205_RankCalculator {
	public static void main(String[] args) {
		// 1. �Է¹ޱ�
		Scanner sc = new Scanner(System.in);

		// 1-1. ���� ����, �¼� ����, ����Ʈ ��ü ũ�� ����
		int currentRankNum = sc.nextInt();
		int newScore = sc.nextInt();
		int fullNum = sc.nextInt();

		// 1-2. ���� ����Ʈ�� �������� ����Ʈ�� ����
		List<Integer> scores = new ArrayList<>();

		for (int i = 0; i < currentRankNum; i++) {
			scores.add(sc.nextInt());
		}

		// 2. ��� ���ϱ�
		// 2-1. �տ������� �¼� ������ ��
		int result = 0;
		int i = scores.size() - 1;
		int lastNum = (currentRankNum != 0) ? scores.get(scores.size() - 1) : 0;

		while (true) {
			// 2-5. ���� �迭�� �ִ� ���� ������ 0�̸� result�� 1 ����
			if (currentRankNum == 0 && fullNum > 0) {
				result = 1;
				break;
			}

			// ������ ���ڿ� ���ؼ� new number���� ũ�ų� ������ -1 return (�� á����)
			if (lastNum >= newScore && scores.size() >= fullNum) {
				result = -1;
				break;
			}

			// ������ ���ڿ� ���ؼ� new number���� ������ �������� �̵��ϸ鼭 count
			if ((scores.size() < fullNum) || (lastNum <= newScore)) {
				while (i >= 0 && scores.get(i) <= newScore) {
					i--;
				}

				if (i >= 0 && scores.get(i) == newScore) {
					result = i + 1;
				} else {
					result = i + 2;
				}

				break;
			}

		}

		// 3. ����ϱ�
		System.out.println(result);
	}

}
