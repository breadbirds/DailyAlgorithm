package baekjoon;

import java.util.Scanner;

// Ź�� ���� �� N��
// �� �����ư��鼭, ���� 1�� or 3�� ������
// ������ ���� �������� ����� WIN!
// start�� ���

// �Է�: N
// ���: ��� win -> SK, â�� win -> CY

// Ȧ��: ��� / ¦��: â��

public class B_S5_9655_StoneGame {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int gameNum = sc.nextInt();
		if (gameNum % 2 == 1) {
			System.out.println("SK");
		} else {
			System.out.println("CY");
		}
	}

}
