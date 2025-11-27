package source_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// 패스워드 생성기 테스트 후 품질 평가

// 높은 품질의 비밀번호 조건
// 1. 모음(aeiou)를 하나 이상 반드시 포함
// 2. 모음이 3개 or 자음이 3개 연속 x
// 3. 같은 글자가 연속으로 두번 x, but ee && oo는 OK

// 입력: 각 줄에 패스워드 / end 나오면 끝 (대문자 없음)
// 출력: <> 안에 기존의 패드워드 + " " + "is acceptable." or "is not acceptable."

// 1. 입력 받기
// 1-1. while문으로 입력을 받되, end가 감지되면 stop (리스트 저장)

// 2. list 길이만큼 반복하면서 품질 테스트 -> 하나라도 만족하지 않으면 is not acceptable.로 처리
// 2-1. 모음이 하나 이상 포함되었는지 확인
// 2-2. 모음이 3개 혹은 3음이 3개 연속되지 않았는지 확인
// 2-3. 같은 글자가 두 번 연속으로 오지 않았는지 확인 (ee / oo 제외)

// 3. 결과 출력

public class B_S5_4659_Password {
	static List<String> vowels = Arrays.asList("a", "e", "i", "o", "u"); // *

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 1. 입력 받기
		// 1-1. while문으로 입력을 받되, end가 감지되면 stop (리스트 저장)
		List<String> passwords = new ArrayList<>();
		String currentWord = "";

		while (!currentWord.equals("end")) {
			currentWord = sc.nextLine();
			passwords.add(currentWord);
		}

		passwords.remove(passwords.size() - 1); // 마지막 end는 지우기

		// 2. list 길이만큼 반복하면서 품질 테스트 -> 하나라도 만족하지 않으면 is not acceptable.로 처리
		boolean isPassed = true;

		for (String targetPassword : passwords) {
			// 2-1. 모음이 하나 이상 포함되었는지 확인
			isPassed = hasVowel(targetPassword);

			if (isPassed == false) {
				failedResult(targetPassword);
				continue;
			}

			// 2-2. 모음이 3개 혹은 자음이 3개 연속되지 않았는지 확인
			isPassed = noTriplePattern(targetPassword);

			if (isPassed == false) {
				failedResult(targetPassword);
				continue;
			}

			// 2-3. 같은 글자가 두 번 연속으로 오지 않았는지 확인 (ee / oo 제외)
			isPassed = hasNoDoubleLetters(targetPassword);

			if (isPassed == true) {
				System.out.println("<" + targetPassword + ">" + " " + "is acceptable.");
			} else {
				failedResult(targetPassword);
			}
		}
	}

	// 1번 조건 확인
	private static boolean hasVowel(String targetPassword) {
		if (!vowels.stream().anyMatch(targetPassword::contains)) { // *
			return false;
		}

		return true;
	}

	// 2번 조건 확인
	private static boolean noTriplePattern(String targetPassword) {
		int vowelCnt = 0;// 모음
		int consonantCnt = 0; // 자음

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

	// 3번 조건 확인
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

	// 실패 결과 출력
	private static void failedResult(String targetPassword) {
		System.out.println("<" + targetPassword + ">" + " " + "is not acceptable.");
	}
}
