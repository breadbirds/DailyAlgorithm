package source_code;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// 1. 자주 나오는 단어일수록 앞에 배치
// 2. 단어 길이가 길수록 앞에 배치
// 3. 알파벳 사전 순으로 앞에 배치
// M 이상인 단어만 외움

public class B_S3_20920_영단어암기는괴로워 {
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

		// 1. 단어의 빈도수 세서 Map에 저장
		Map<String, Integer> sameWordCnt = new HashMap<>();
		for (String s : words) {
			if (sameWordCnt.containsKey(s))
				sameWordCnt.put(s, sameWordCnt.get(s) + 1);
			else
				sameWordCnt.put(s, 1);
		}

		List<Map.Entry<String, Integer>> entryList = new ArrayList<>(sameWordCnt.entrySet());

		// 2. 정렬
		entryList.sort((e1, e2) -> {
			if (!e1.getValue().equals(e2.getValue())) {
				return e2.getValue() - e1.getValue(); // 빈도수 내림차순
			}
			if (e1.getKey().length() != e2.getKey().length()) {
				return e2.getKey().length() - e1.getKey().length(); // 길이 내림차순
			}
			return e1.getKey().compareTo(e2.getKey()); // 사전 순 오름차순
		});

		// 3. 출력
		for (int i = 0; i < entryList.size(); i++) {
			System.out.println(entryList.get(i).getKey());
		}
	}

}
