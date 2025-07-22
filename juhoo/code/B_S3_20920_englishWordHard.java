package source_code;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// 1. ���� ������ �ܾ��ϼ��� �տ� ��ġ
// 2. �ܾ� ���̰� ����� �տ� ��ġ
// 3. ���ĺ� ���� ������ �տ� ��ġ
// M �̻��� �ܾ �ܿ�

public class B_S3_20920_���ܾ�ϱ�±��ο� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int wordCnt = sc.nextInt();
		int limitLength = sc.nextInt();
		sc.nextLine();
		List<String> words = new ArrayList<>();

		for (int i = 0; i < wordCnt; i++) {
			String word = sc.nextLine();

			if (word.length() >= limitLength) {
				words.add(word);
			}
		}

		// 1. �ܾ��� �󵵼� ���� Map�� ����
		Map<String, Integer> sameWordCnt = new HashMap<>();
		for (String s : words) {
			if (sameWordCnt.containsKey(s))
				sameWordCnt.put(s, sameWordCnt.get(s) + 1);
			else
				sameWordCnt.put(s, 1);
		}

		List<Map.Entry<String, Integer>> entryList = new ArrayList<>(sameWordCnt.entrySet());

		// 2. ����
		entryList.sort((e1, e2) -> {
			if (!e1.getValue().equals(e2.getValue())) {
				return e2.getValue() - e1.getValue(); // �󵵼� ��������
			}
			if (e1.getKey().length() != e2.getKey().length()) {
				return e2.getKey().length() - e1.getKey().length(); // ���� ��������
			}
			return e1.getKey().compareTo(e2.getKey()); // ���� �� ��������
		});

		// 3. ���
		for (int i = 0; i < entryList.size(); i++) {
			System.out.println(entryList.get(i).getKey());
		}
	}

}
