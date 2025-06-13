# 백준 11723 집합 | 실버 5

[🍋 문제 바로가기](https://www.acmicpc.net/problem/11723)

### 내 코드
```java
package source_code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

// 공집합 S
// add x: x를 추가 
// remove x: x 제거
// check x: x가 있으면 1, 없으면 0
// toggle x: x가 있으면 제거, 없으면 추가
// all: {1,2,..,20}으로 바꿈
// empty: 공집합으로 바꿈

// 입력: 수행할 연산 수 / 연산들(string, int)
// 출력: check 연산 실행 시 결과 출력(1 or 0)

public class B_S5_setManager {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int calNum = Integer.parseInt(br.readLine());

		Set<Integer> result = new HashSet<Integer>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < calNum; i++) {
			// List<Character> nextList = new ArrayList<>();
			String nextLine = br.readLine();
			String[] parts = nextLine.split(" ");

			String cal = parts[0];
			int num = 0;

			if (!parts[0].equals("empty") && !parts[0].equals("all")) {
				num = Integer.valueOf(nextLine.split(" ")[1]);
			}

			calculation(cal, num, result, sb);

		}

		System.out.println(sb);

	}

	private static void calculation(String cal, int num, Set<Integer> result, StringBuilder sb) {
		if (cal.equals("add")) { // 1번: add
			result.add(num);

		} else if (cal.equals("remove")) { // 2번: remove
			result.remove(num);

		} else if (cal.equals("check")) { // 3번: check
			if (result.contains(num)) {
				sb.append(1).append('\n');
			} else {
				sb.append(0).append('\n');
			}

		} else if (cal.equals("toggle")) { // 4번: toggle
			if (result.contains(num)) {
				result.remove(num);
			} else {
				result.add(num);
			}

		} else if (cal.equals("all")) { // 5번: all
			result.clear();
			for (int i = 0; i < 20; i++) {
				result.add(i + 1);
			}

		} else { // 6번: empty
			result.clear();
		}
	}
}

```

처음에 시간 초과가 나서 바꾼 것
1. Scanner를 BufferedReader로 변경
2. check가 나오면 그때그때 출력하던 로직에서 한 번에 출력하는 방식으로 변경

</br>

#### 코드 피드백
`장점`
- BufferedReade + StringBuilder를 사용해서 빠른 입출력 처리 
- 명령 분기 처리 함수로 분리 -> 메인 로직과 분리되어 가독성 높음
- 명령어 종류에 따라 조건 분기 정확
	- 인자 없는 명령도 예외 처리 잘 함
    
`개선점`
- Integer.valueOf() 대신 Integer.parseInt() 사용 권장

| 항목    | `parseInt()`        | `valueOf()`                   |
| ----- | ------------------- | ----------------------------- |
| 반환 타입 | `int` (기본형)         | `Integer` (객체형)               |
| 목적    | 숫자만 필요할 때           | 객체 캐싱 등 활용 시                  |
| 오토박싱  | 없음                  | 있음 (int → Integer 자동 변환)      |
| 성능    | 더 빠름 (불필요한 객체 생성 X) | 느릴 수 있음 (캐싱 활용하지만 박싱 오버헤드 있음) |

- nextLine.split(" ")[1] -> 이미 parts가 있으므로 중복 연산 제거하기
- Set<Integer> 대신 비트마스크 사용 시 속도 더 향상 가능 -> 특히 HashSet은 내부적으로 해시 처리하므로 연상량이 높음!
 
</br>
  

### 개선 코드

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class B_S5_setManager {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int calNum = Integer.parseInt(br.readLine());
		Set<Integer> result = new HashSet<>();

		for (int i = 0; i < calNum; i++) {
			String[] parts = br.readLine().split(" ");
			String cal = parts[0];
			int num = 0;

			if (parts.length == 2) {
				num = Integer.parseInt(parts[1]);
			}

			calculation(cal, num, result, sb);
		}

		System.out.print(sb);
	}

	private static void calculation(String cal, int num, Set<Integer> result, StringBuilder sb) {
		switch (cal) {
			case "add":
				result.add(num);
				break;
			case "remove":
				result.remove(num);
				break;
			case "check":
				sb.append(result.contains(num) ? 1 : 0).append('\n');
				break;
			case "toggle":
				if (result.contains(num)) result.remove(num);
				else result.add(num);
				break;
			case "all":
				result.clear();
				for (int i = 1; i <= 20; i++) result.add(i);
				break;
			case "empty":
				result.clear();
				break;
		}
	}
}

```