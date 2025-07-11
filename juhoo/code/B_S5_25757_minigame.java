package source_code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

// ������ Y(2), ���� �׸� ã�� F(3), ��ī�� O(4)
// �÷��� ��û Ƚ�� N
// �� �� ���� �÷��� �ϸ� �ٽ� ����

// �Է�: �÷��� ��û Ƚ�� / �÷����� ������ ���� /// �÷����� ����� �̸�
// ���: �ִ�� �� ���̳� ������ �� �ִ���

// 1. �Է� �ޱ�
// 1-1. �� ���� ������ �ʿ� �ο� ���� map �̸� ���� (�ο� ���� ���� �����ؼ� 1 ���� ����)
// 1-2. ��� �̸� �Է� ���� �� �̹� list�� ������ ���� X

// 2. ��ü size�� �ʿ� �ο� ���� ������ ��� ����

public class B_S5_25757_minigame {
	// 1. �Է� �ޱ�
	// 1-1. �� ���� ������ �ʿ� �ο� ���� map �̸� ���� (�ο� ���� ���� �����ؼ� 1 ���� ����)

	static final Map<String, Integer> games = new HashMap<>();
	static {
		games.put("Y", 1);
		games.put("F", 2);
		games.put("O", 3);
	}

	public static void main(String[] args) {
		// 1-2. ��� �̸� �Է� ���� �� �̹� list�� ������ ���� X
		Scanner sc = new Scanner(System.in);

		int applyNum = sc.nextInt();
		String game = sc.next();
		// List<String> names = new ArrayList<>();
		Set<String> names = new HashSet<>();

		for (int i = 0; i < applyNum; i++) {
			names.add(sc.next());

//			String currentName = sc.next();
//
//			if (!names.contains(currentName)) {
//				names.add(currentName);
//			}
		}

		// 2. ��ü size�� �ʿ� �ο� ���� ������ ��� ����
		int result = names.size() / games.get(game);
		System.out.println(result);
	}
}
