package source_code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

// 1. ���� ���� ī�� ������
// 2. �� ���� ���� �ִ� ī�带 ���� �Ʒ��� �ű�

// �Է�: N (������ ī�� ����)
// ���: ���� �������� ���� ī�� ����

// 1. �Է� �ޱ�
// 1-1. ī�带 ������� list�� ����
// 2. ��Ģ�� ���� �� ���� ī�尡 ���� ������ ���� play
// 3. list�� ������ �ϳ��� �Ǹ� ���߰� ���

public class B_S4_2164_Card2 {
	public static void main(String[] args) {
		// 1. �Է� �ޱ�
		Scanner sc = new Scanner(System.in);
		int lastNumber = sc.nextInt();

		// 1-1. ī�带 ������� list�� ����
		List<Integer> cards = new LinkedList<>();
		for (int i = 0; i < lastNumber; i++) {
			cards.add(i + 1);
		}

		// 2. ��Ģ�� ���� �� ���� ī�尡 ���� ������ ���� play
		int lastCard = checkCardsCnt(cards);

		// 3. list�� ������ �ϳ��� �Ǹ� ���߰� ���
		System.out.println(lastCard);
	}

	private static int checkCardsCnt(List<Integer> cards) {
		while (cards.size() > 1) {
			playGame(cards);
		}

		return cards.get(0);
	}

	private static void playGame(List<Integer> cards) {
		// 1�� ��Ģ
		cards.remove(0);
		// 2�� ��Ģ
		int x = cards.get(0);
		cards.remove(0);
		cards.add(x);
	}

}
