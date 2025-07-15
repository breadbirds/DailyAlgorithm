package source_code;

import java.util.Scanner;

// ��: ���� ���� ����� ����ġ ���� �ٲ� (1)
// ��: ���� ���� �������� �� �� ����, �������� ������鼭 ���� ���� �� �ٲ� (2)

// �Է�: ����ġ ���� // ����ġ �� ���µ� // �л� �� // �� �л��� ����, �л��� ���� ��
// ���: ����ġ�� ������ ���� (�� �ٿ� 20����)

// 1. �Է¹ޱ�
// 1-1. �迭�� ����ġ ���� ����
// 1-2. �迭�� �л� ���� ����

// 2. ����ġ �����ϱ�
// 2-1. �������� �������� �Ǻ�
// 2-2. ���ڶ��, ���� ���� ����� ����ġ ���� ����
// 2-3. ���� ���� ���� ����� ����ġ �迭 ũ�⺸�� ũ�ٸ� �Ѿ
// 2-4. ���ڶ��, ���� ���� ����ġ �ε����� ã�� ����ġ ����
// 2-5. �� �ε����� ��������, �¿�� ���� �̵��ϸ鼭 ���� ������ ����ġ ����
// 2-6. ���� �ٸ��ų�, �迭 �ε����� ����� ����

// 3. ���� ���� ����ϱ�

public class B_S4_1244_SwitchOnOff {
	static int[] switchStatus;

	public static void main(String[] args) {
		// 1. �Է¹ޱ�
		Scanner sc = new Scanner(System.in);

		int switchCnt = sc.nextInt();
		switchStatus = new int[switchCnt];

		// 1-1. �迭�� ����ġ ���� ����
		for (int i = 0; i < switchCnt; i++) {
			switchStatus[i] = sc.nextInt();
		}

		int studentCnt = sc.nextInt();
		int[][] student = new int[studentCnt][2];

		// 1-2. �迭�� �л� ���� ����
		for (int i = 0; i < studentCnt; i++) {
			for (int j = 0; j < 2; j++) {
				student[i][j] = sc.nextInt();
			}
		}

		// 2. ����ġ �����ϱ�
		for (int i = 0; i < studentCnt; i++) {
			// 2-1. �������� �������� �Ǻ�
			int gender = student[i][0];
			int num = student[i][1];

			// 2-2. ���ڶ��, ���� ���� ����� ����ġ ���� ����
			if (gender == 1) {
				int multiple = num;
				int n = 2;

				// 2-3. ���� ���� ���� ����� ����ġ �迭 ũ�⺸�� ũ�ٸ� �Ѿ
				while (multiple < switchCnt) {
					convertValue(multiple);
					multiple = num * n;
					n++;
				}
			} else if (gender == 2 && num < switchCnt) { // 2-4. ���ڶ��, ���� ���� ����ġ �ε����� ã�� ����ġ ����
				convertValue(num);

				// 2-5. �� �ε����� ��������, �¿�� ���� �̵��ϸ鼭 ���� ������ ����ġ ����
				// 2-6. ���� �ٸ��ų�, �迭 �ε����� ����� ����
				int left = num - 1;
				int right = num + 1;

				while (left > 0 && right <= switchCnt && (switchStatus[left - 1] == switchStatus[right - 1])) {
					convertValue(left);
					convertValue(right);

					left--;
					right++;
				}
			}
		}

		// 3. ���� ���� ����ϱ�
		int i = 1;

		while (i <= switchCnt) {
			System.out.print(switchStatus[i-1] + " ");
			
			if(i % 20 == 0) {
				System.out.println();
			}

			i++;
		}
	}

	// ���� ������Ű�� �Լ�
	private static void convertValue(int num) {
		switchStatus[num - 1] = (switchStatus[num - 1] == 1) ? 0 : 1;
	}

}
