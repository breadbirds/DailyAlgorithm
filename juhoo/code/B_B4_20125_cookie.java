package source_code;

import java.util.Scanner;

// �Է�: ���� ���� ���� ���� /// �� ĭ�� �� (_ or *)
// ���: ������ ��ġ�� x, y /// ���� ��, ������ ��, ���� �ٸ�, ������ �ٸ� ����

// 1. �Է¹ޱ�
// 1-1. �迭�� �� ���� - _�̸� 0, *�̸� 1�� ��ȯ�Ͽ� �����ϱ�

// 2. �Ӹ� ã��
// 2-1. �ǿ��� ���������� 1�� ���Ե� ù �� ã��

// 3. ���� ��ġ ã�� - (�Ӹ� x�� -1) (�Ӹ� y��)

// 4. �� ���� ���
// 4-1. ���� ��ġ�� �������� ���� 0�� �ɶ����� �������� ���鼭 count
// 4-2. ���� ��ġ�� �������� ���� 0�� �ɶ����� ���������� ���鼭 count

// 5. �ٸ� ���� ���
// 5-1. �㸮 ���� �� ã�� - ���� ��ġ�� �������� ���� 0�� �� ������ �Ʒ��� �̵�
// 5-2. ���� �ٸ� ���� count
// 5-3. ������ �ٸ� ���� count

// 6. ����ϱ�

public class B_B4_20125_cookie {
	public static void main(String[] args) {
		// 1. �Է¹ޱ�
		Scanner sc = new Scanner(System.in);

		int boardWidth = sc.nextInt();
		sc.nextLine();

		int[][] board = new int[boardWidth][boardWidth];

		// 1-1. �迭�� �� ���� - _�̸� 0, *�̸� 1�� ��ȯ�Ͽ� �����ϱ�
		for (int i = 0; i < boardWidth; i++) {
			String line = sc.nextLine();

			for (int j = 0; j < boardWidth; j++) {
				char c = line.charAt(j);

				if (c == '_') {
					board[i][j] = 0;
				} else {
					board[i][j] = 1;
				}
			}
		}

		int[] head = new int[2];
		int[] heart = new int[2];
		int leftArm = 0;
		int rightArm = 0;
		int leftLeg = 0;
		int rightLeg = 0;
		int waistLength = 0;

		// 2. �Ӹ� ��ǥ ã��
		// 2-1. �ǿ��� ���������� 1�� ���Ե� ù �� ã��

		loop1: for (int i = 0; i < boardWidth; i++) {
			for (int j = 0; j < boardWidth; j++) {
				if (board[i][j] == 1) {
					head[0] = i + 1;
					head[1] = j + 1;
					break loop1;
				}
			}
		}

		// 3. ���� ��ġ ã�� - (�Ӹ� x�� -1) (�Ӹ� y��)
		heart[0] = head[0] + 1;
		heart[1] = head[1];

		// 4. �� ���� ���
		// 4-1. ���� ��ġ�� �������� ���� 0�� �ɶ����� �������� ���鼭 count
		for (int j = heart[1] - 2; j >= 0; j--) {
			if (board[heart[0] - 1][j] == 1) {
				leftArm++;
			} else {
				break;
			}
		}

		// 4-2. ���� ��ġ�� �������� ���� 0�� �ɶ����� ���������� ���鼭 count
		for (int j = heart[1]; j < boardWidth; j++) {
			if (board[heart[0] - 1][j] == 1) {
				rightArm++;
			} else {
				break;
			}
		}

		// 5. �ٸ� ���� ���
		// 5-1. �㸮 ���� �� ã�� - ���� ��ġ�� �������� ���� 0�� �� ������ �Ʒ��� �̵�
		for (int i = heart[0] + 1; i < boardWidth; i++) {
			if (board[i - 1][heart[1] - 1] == 1) {
				waistLength++;
			} else {
				break;
			}
		}

		// 5-2. ���� �ٸ� ���� count
		for (int i = heart[0] + waistLength; i < boardWidth; i++) {
			if (board[i][heart[1] - 2] == 1) {
				leftLeg++;
			} else {
				break;
			}
		}

		// 5-3. ������ �ٸ� ���� count
		for (int i = heart[0] + waistLength; i < boardWidth; i++) {
			if (board[i][heart[1]] == 1) {
				rightLeg++;
			} else {
				break;
			}
		}

		// 6. ����ϱ�
		// ���: ������ ��ġ�� x, y /// ���� ��, ������ ��, �㸮, ���� �ٸ�, ������ �ٸ� ����
		System.out.printf("%d %d\n", heart[0], heart[1]);
		System.out.printf("%d %d %d %d %d\n", leftArm, rightArm, waistLength, leftLeg, rightLeg);
	}

}
