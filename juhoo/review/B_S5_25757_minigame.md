# 백준 25757 임스와 함께하는 미니게임 | 실버 5

[👾 문제 바로가기](https://www.acmicpc.net/problem/25757)

이 문제는 사실 초반에 시간 초과로 실패했던 문제이다.
쉽게 보고 무심코 비효율적인 자료형을 선택...한 것이 원인.

### 나의 코드
```java
package source_code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

// 윷놀이 Y(2), 같은 그림 찾기 F(3), 원카드 O(4)
// 플레이 신청 횟수 N
// 한 번 같이 플레이 하면 다시 안함

// 입력: 플레이 신청 횟수 / 플레이할 게임의 종류 /// 플레이할 사람의 이름
// 출력: 최대로 몇 번이나 게임할 수 있는지

// 1. 입력 받기
// 1-1. 각 게임 종류와 필요 인원 수를 map 미리 저장 (인원 수는 본인 제외해서 1 뺴고 저장)
// 1-2. 사람 이름 입력 받을 때 이미 list에 있으면 저장 X

// 2. 전체 size를 필요 인원 수로 나누면 결과 도출

public class B_S5_25757_minigame {
	// 1. 입력 받기
	// 1-1. 각 게임 종류와 필요 인원 수를 map 미리 저장 (인원 수는 본인 제외해서 1 뺴고 저장)

	static final Map<String, Integer> games = new HashMap<>();
	static {
		games.put("Y", 1);
		games.put("F", 2);
		games.put("O", 3);
	}

	public static void main(String[] args) {
		// 1-2. 사람 이름 입력 받을 때 이미 list에 있으면 저장 X
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

		// 2. 전체 size를 필요 인원 수로 나누면 결과 도출
		int result = names.size() / games.get(game);
		System.out.println(result);
	}
}

```

비교하려고 기존 코드는 주석으로 남겨놨다.
기존엔 보이다시피 List를 활용해서 이름들을 저장하고, for문 안에서 중복되지 않는 이름만 저장했다.
그런데 간과하고 있었던 것.. 바로 Set은 중복이 자동 제거 된다는 점.

</br>

### List vs Set
| 항목                      | `List` (`ArrayList`) | `Set` (`HashSet`)    |
| ----------------------- | -------------------- | -------------------- |
| **중복 허용**               | O (허용됨)              | X (자동 제거)            |
| **저장 순서 유지**            | O                    | X (`HashSet`은 순서 없음) |
| **`contains()` 시간 복잡도** | O(N)                 | O(1) (평균)            |
| **사용 목적**               | 순서 중요, 중복 허용         | 중복 제거, 빠른 탐색         |

순서가 필요 없고, 중복을 허용하지 않으려면 HashSet을 사용하자!
O(N) -> O(1)으로 시간복잡도를 줄일 수 있다.

기존 코드에서 contains로 매번 리스트를 전체 순회하면 O(N)의 시간복잡도가 생기는데, 이걸 N번 반복하면 전체 시간 복잡도는 O(N²)이 된다.
=> 시간 초과 🚨

</br>

### Java Set 종류 정리
| 종류                      | 특징                      | 순서 보장    | 중복   | 정렬                                | 주요 사용 예             |
| ----------------------- | ----------------------- | -------- | ---- | --------------------------------- | ------------------- |
| `HashSet`               | 가장 기본적인 Set 구현체 (해시 기반) | ❌ 없음     | ❌ 불가 | ❌ 없음                              | 빠른 탐색 / 중복 제거       |
| `LinkedHashSet`         | 입력 순서 유지 + `HashSet` 기반 | ✅ 입력 순서  | ❌ 불가 | ❌ 없음                              | 순서를 유지하며 중복 제거할 때   |
| `TreeSet`               | 자동 정렬 (이진 트리 기반)        | ✅ 정렬 순   | ❌ 불가 | ✅ 정렬됨 (`Comparable`/`Comparator`) | 정렬된 순서로 관리할 때       |
| `EnumSet`               | enum 전용 고성능 Set         | ✅ 정의된 순서 | ❌ 불가 | ✅ Enum 정의 순                       | Enum 타입을 Set으로 다룰 때 |
| `ConcurrentSkipListSet` | 멀티스레드-safe + 정렬         | ✅ 정렬 순   | ❌ 불가 | ✅ 정렬됨                             | 동시성 + 정렬이 필요한 경우    |
| `CopyOnWriteArraySet`   | 멀티스레드-safe + 작은 Set에 적합 | ✅ 입력 순서  | ❌ 불가 | ❌ 없음                              | 읽기 많은 멀티스레드 환경      |

만약 순서가 필요한데 중복 제거를 원한다면 HashSet 대신 LinkedHashSet!!

#### 정리
| 상황               | 추천 Set                                         |
| ---------------- | ---------------------------------------------- |
| 일반적인 중복 제거       | `HashSet`                                      |
| 중복 제거 + 입력 순서 유지 | `LinkedHashSet`                                |
| 중복 제거 + 자동 정렬    | `TreeSet`                                      |
| enum만 다룸         | `EnumSet`                                      |
| 병렬 처리 환경         | `ConcurrentSkipListSet`, `CopyOnWriteArraySet` |
