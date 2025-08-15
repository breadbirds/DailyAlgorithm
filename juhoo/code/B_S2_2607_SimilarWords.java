package source_code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// ���� ����: ���� ���� ���� & ���� ����
// ����� �ܾ�: �� ���ڸ� ���ϰ� ���ų�, �ٸ� ���ڷ� �ٲ㼭 �������� ���

// ù ��° �ܾ�� ���� ���� or ����� �ܾ� ���� ã��!

public class B_S2_2607_SimilarWords {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int result = 0;

		int cnt = Integer.parseInt(s);
		String firstWord = br.readLine();

		for (int i = 0; i < cnt - 1; i++) {
			s = br.readLine();
			StringBuilder word = new StringBuilder(s);

			boolean isSame = checkSameWord(word, firstWord);

			if (isSame) {
				result++;
			}

		}

		System.out.println(result);
	}

	private static boolean checkSameWord(StringBuilder word, String firstWord) {
		// firstWord�� �� char�� word�� �ִ��� Ȯ���ϰ� ����
		if (word.length() == firstWord.length()) {
			int noNumCnt = checkAndDelete(word, firstWord);
			if (word.length() <= 1) {
				return true;
			}
		} else if (Math.abs(word.length() - firstWord.length()) == 1) {
			int noNumCnt = checkAndDelete(word, firstWord);

			if (noNumCnt > 1) {
				return false;
			}

			if (word.length() <= 1) {
				return true;
			}
		}

		return false;
	}

	private static int checkAndDelete(StringBuilder word, String firstWord) {
		int noNumCnt = 0;

		for (int i = 0; i < firstWord.length(); i++) {
			int index = word.indexOf(String.valueOf(firstWord.charAt(i)));
			if (index >= 0) {
				word.deleteCharAt(index);
			} else {
				noNumCnt++;
			}
		}

		return noNumCnt;
	}
}
