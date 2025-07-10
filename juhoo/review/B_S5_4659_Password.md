# 백준 4659 비밀번호 발음하기 | 실버 5
[🛋️ 문제 바로가기](https://www.acmicpc.net/problem/4659)

### 나의 코드
```java
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
```

</br>

### 코드에 사용된 java 개념 정리
#### Arrays.asList()
배열 → List로 변환할 때 사용하는 정적 메서드
java.util.Arrays 클래스에 정의됨

`List<String> vowels = Arrays.asList("a", "e", "i", "o", "u");
`

이런 식으로 활용하면 문자열 배열을 List<String> 으로 바꿔줌
  
**[특징]**
- 고정 크기 리스트 
  - add(), remove() 불가능 - 크기 변경 불가능
  - 원본 배열의 뷰처럼 동작함
- 값 수정은 가능
  - set(index, value)는 가능함
- null 포함 가능

  -> 리스트가 고정된 값들로만 구성될 때, contains(), indexOf()등 간단한 조회용으로 사용하면 좋음
  
</br>

#### 자바 스트림(Stream API) 핵심 문법
`!vowels.stream().anyMatch(targetPassword::contains)
`

- vowels.stream()
  - List를 Stream으로 변환
  - 스트림은 데이터를 하나씩 꺼내서 가공하는 반복 처리 도구!
  - 그래서 리스트에 있는 char를 하나씩 꺼내서 처리 가능함
  `Stream<String> stream = vowels.stream();
`

- anyMatch(...)
  - 스트림 요소 중 하나라도 조건을 만족하면 true 반환
  - 내부적으로 for-each처럼 순회하면서 조건 검사
  `anyMatch(v -> 조건식) // 하나라도 true면 종료
`
- targetPassword::contains
  - 메서드 참조 문법 (람다를 더 간결하게 표현한 것)
  - 다음과 동일함 `v -> targetPassword.contains(v)
`

+) 같은 코드를 람다식으로 풀면 이렇게 됨
```java
boolean hasVowel = false;
for (String v : vowels) {
    if (targetPassword.contains(v)) {
        hasVowel = true;
        break;
    }
}
if (!hasVowel) {
    // 모음 없음!
}
```

</br>

### 개선 코드
```java
package source_code;

import java.util.*;

public class B_S5_4659_Password {
    private static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u');

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> passwords = new ArrayList<>();

        while (true) {
            String input = sc.nextLine();
            if (input.equals("end")) break;
            passwords.add(input);
        }

        for (String password : passwords) {
            if (isAcceptable(password)) {
                printResult(password, true);
            } else {
                printResult(password, false);
            }
        }
    }

    private static boolean isAcceptable(String pw) {
        return hasVowel(pw) &&
               noTriplePattern(pw) &&
               noInvalidDoubleLetters(pw);
    }

    private static boolean hasVowel(String pw) {
        for (char c : pw.toCharArray()) {
            if (VOWELS.contains(c)) return true;
        }
        return false;
    }

    private static boolean noTriplePattern(String pw) {
        int vowelStreak = 0;
        int consonantStreak = 0;

        for (char c : pw.toCharArray()) {
            if (VOWELS.contains(c)) {
                vowelStreak++;
                consonantStreak = 0;
            } else {
                consonantStreak++;
                vowelStreak = 0;
            }

            if (vowelStreak >= 3 || consonantStreak >= 3) {
                return false;
            }
        }

        return true;
    }

    private static boolean noInvalidDoubleLetters(String pw) {
        char prev = 0;

        for (char c : pw.toCharArray()) {
            if (c == prev && c != 'e' && c != 'o') {
                return false;
            }
            prev = c;
        }

        return true;
    }

    private static void printResult(String pw, boolean result) {
        System.out.printf("<%s> is %sacceptable.%n", pw, result ? "" : "not ");
    }
}

```

| 최적화 항목                         | 설명                                                                           |
| ------------------------------ | ---------------------------------------------------------------------------- |
| **1. `Set<Character>`로 변경**    | `List<String>` → `Set<Character>`로 변경하여 `contains()` 시 O(n) → **O(1)** 성능 개선 |
| **2. `isAcceptable()`로 조건 통합** | 조건 3개를 한 메서드로 묶어 **로직 흐름 단순화**, **가독성 향상**                                   |
| **3. `for-each`로 stream 제거**   | 불필요한 Stream API 제거 → 가독성과 성능을 동시에 확보 (`char`는 `stream()` 불필요)                |
| **4. 불필요한 `continue` 제거**      | `if-else` 구조 대신 boolean 결과 한 번에 처리하여 **조건 분기 최소화**                           |
| **5. `char prev = 0;` 사용**     | char는 기본값으로 `0` 사용 가능 → 이전 문자를 비교할 때 null-like로 활용                           |
| **6. 메시지 출력 함수 분리**            | `printResult()` 함수로 **출력 포맷 일관성 유지**, 변경 용이성 ↑                               |
| **7. 상수 선언 (`final`)**         | `VOWELS`는 불변이라 `static final`로 선언 → **의도 명확, 재사용 안전**                        |
