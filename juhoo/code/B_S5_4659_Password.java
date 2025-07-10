package source_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// �н����� ������ �׽�Ʈ �� ǰ�� ��

// ���� ǰ���� ��й�ȣ ����
// 1. ����(aeiou)�� �ϳ� �̻� �ݵ�� ����
// 2. ������ 3�� or ������ 3�� ���� x
// 3. ���� ���ڰ� �������� �ι� x, but ee && oo�� OK

// �Է�: �� �ٿ� �н����� / end ������ �� (�빮�� ����)
// ���: <> �ȿ� ������ �е���� + " " + "is acceptable." or "is not acceptable."

// 1. �Է� �ޱ�
// 1-1. while������ �Է��� �޵�, end�� �����Ǹ� stop (����Ʈ ����)

// 2. list ���̸�ŭ �ݺ��ϸ鼭 ǰ�� �׽�Ʈ -> �ϳ��� �������� ������ is not acceptable.�� ó��
// 2-1. ������ �ϳ� �̻� ���ԵǾ����� Ȯ��
// 2-2. ������ 3�� Ȥ�� 3���� 3�� ���ӵ��� �ʾҴ��� Ȯ��
// 2-3. ���� ���ڰ� �� �� �������� ���� �ʾҴ��� Ȯ�� (ee / oo ����)

// 3. ��� ���

public class B_S5_4659_Password {
	static List<String> vowels = Arrays.asList("a", "e", "i", "o", "u"); // *

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 1. �Է� �ޱ�
		// 1-1. while������ �Է��� �޵�, end�� �����Ǹ� stop (����Ʈ ����)
		List<String> passwords = new ArrayList<>();
		String currentWord = "";

		while (!currentWord.equals("end")) {
			currentWord = sc.nextLine();
			passwords.add(currentWord);
		}

		passwords.remove(passwords.size() - 1); // ������ end�� �����

		// 2. list ���̸�ŭ �ݺ��ϸ鼭 ǰ�� �׽�Ʈ -> �ϳ��� �������� ������ is not acceptable.�� ó��
		boolean isPassed = true;

		for (String targetPassword : passwords) {
			// 2-1. ������ �ϳ� �̻� ���ԵǾ����� Ȯ��
			isPassed = hasVowel(targetPassword);

			if (isPassed == false) {
				failedResult(targetPassword);
				continue;
			}

			// 2-2. ������ 3�� Ȥ�� ������ 3�� ���ӵ��� �ʾҴ��� Ȯ��
			isPassed = noTriplePattern(targetPassword);

			if (isPassed == false) {
				failedResult(targetPassword);
				continue;
			}

			// 2-3. ���� ���ڰ� �� �� �������� ���� �ʾҴ��� Ȯ�� (ee / oo ����)
			isPassed = hasNoDoubleLetters(targetPassword);

			if (isPassed == true) {
				System.out.println("<" + targetPassword + ">" + " " + "is acceptable.");
			} else {
				failedResult(targetPassword);
			}
		}
	}

	// 1�� ���� Ȯ��
	private static boolean hasVowel(String targetPassword) {
		if (!vowels.stream().anyMatch(targetPassword::contains)) { // *
			return false;
		}

		return true;
	}

	// 2�� ���� Ȯ��
	private static boolean noTriplePattern(String targetPassword) {
		int vowelCnt = 0;// ����
		int consonantCnt = 0; // ����

		for (char c : targetPassword.toCharArray()) {
			if (vowels.stream().anyMatch(Character.toString(c)::contains)) {
				vowelCnt++;
				consonantCnt = 0;
			} else {
				consonantCnt++;
				vowelCnt = 0;
			}

			if (vowelCnt >= 3 || consonantCnt >= 3) {
				return false;
			}
		}

		return true;
	}

	// 3�� ���� Ȯ��
	private static boolean hasNoDoubleLetters(String targetPassword) {
		char passedChar = ' ';

		for (char c : targetPassword.toCharArray()) {
			if (c == passedChar && !(c == 'e' || c == 'o')) {
				return false;
			}

			passedChar = c;
		}

		return true;
	}

	// ���� ��� ���
	private static void failedResult(String targetPassword) {
		System.out.println("<" + targetPassword + ">" + " " + "is not acceptable.");
	}
}
