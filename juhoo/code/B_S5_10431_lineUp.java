package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Ű ������� ��ȣ �ο� (���� ������� 1������)
// �л� �� : 20�� (���� Ű x)

// 1. �ƹ��� �� ���� �� �� �տ� ����
// 2. ���� �л��� �� �ڿ� ���鼭 ��Ģ ����
// 2-1. �ڱ� �տ� �� ū �ְ� ������ ����
// 2-2. �ڱ� �տ� �� ū �ְ� �� ���̶� ������ �� �߿� ���� �տ� �ִ� ���� �ٷ� �տ� ��
// (�ݺ�)

// �Է�: ���̽� �� P, ���̽� �� ����
// ���: ���̽� ��ȣ, �л����� ������ ���� �� ����

public class B_S5_10431_lineUp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int caseNum = sc.nextInt();

		for (int i = 0; i < caseNum; i++) {
			int statusCase = sc.nextInt();

			List<Integer> newStanding = new ArrayList<>();
			int backMove = 0;

			// 1. �� ���� �� �� �տ� ����
			newStanding.add(sc.nextInt());

			for (int j = 0; j < 19; j++) {

				int currentStudent = sc.nextInt();

				// 2. ���� �л��� �� �ڿ� ���鼭 ��Ģ ����
				boolean hasBigger = false;
				int tallerIdx = -1;

				for (int s : newStanding) {
					if (s > currentStudent) {
						hasBigger = true;
						tallerIdx = newStanding.indexOf(s);
						break;
					}
				}

				if (hasBigger) {
					// 2-2. �ڱ� �տ� �� ū �ְ� �� ���̶� ������ �� �߿� ���� �տ� �ִ� ���� �ٷ� �տ� ��
					newStanding.add(tallerIdx, currentStudent);

					// ���� ���� �� ���� ��� ����ŭ �������� ��
					backMove += newStanding.size() - (tallerIdx + 1);
				} else {
					// 2-1. �ڱ� �տ� �� ū �ְ� ������ stop
					newStanding.add(currentStudent);
				}
			}

			System.out.println(statusCase + " " + backMove);

		}
	}

}
