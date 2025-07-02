# 백준 8979 올림픽 | 실버 5

[🍋 문제 바로가기](https://www.acmicpc.net/problem/8979)

### 코드
```java
package baekjoon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// 입력: 국가의 수 N / 등수를 알고 싶은 국가 K // 각 국가는 1~N 사이의 정수로 표현
// 출력: 입력받은 국가 K의 등수

public class B_S5_8979_Olympics {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int countryCnt = sc.nextInt();
		int targetCountry = sc.nextInt();

		List<int[]> medalList = new ArrayList<>();

		for (int i = 0; i < countryCnt; i++) {
			medalList.add(new int[] { sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt() });
		}

		// 금, 은, 동 순으로 내림차순 정렬
		medalList.sort((a, b) -> {
			if (a[1] != b[1])
				return b[1] - a[1];
			if (a[2] != b[2])
				return b[2] - a[2];
			return b[3] - a[3];
		});

		int rank = 1;

		for (int i = 0; i < countryCnt; i++) {
			if (i > 0) {
				int[] prev = medalList.get(i - 1);
				int[] curr = medalList.get(i);

				if (!(prev[1] == curr[1] && prev[2] == curr[2] && prev[3] == curr[3])) {
					rank = i + 1;
				}
			}

			if (medalList.get(i)[0] == targetCountry) {
				break;
			}
		}
		
		System.out.println(rank);
	}

}

```

솔직히 이 문제는 머리로는 알겠는데 정렬을 어떻게 해야할지 몰라서 어려웠다.
정확히 말하자면 문제가 어려운게 아니라 자바를 까먹었다 ...
비슷한 문제를 많이 풀어야할 것 같다.

```java
medalList.sort((a, b) -> {
	if (a[1] != b[1]) return b[1] - a[1];
	if (a[2] != b[2]) return b[2] - a[2];
	return b[3] - a[3];
});

```

특히 이 부분.

1. **List<int[]> 정렬**
	List<int[]>는 요소가 배열이니까, sort() 안에 Comparator를 직접 람다식으로 구현한 형태.
a[1]은 금메달, a[2]는 은메달, a[3]은 동메달

2. **(a, b) -> { ... } : 람다식**
	자바 8부터 도입된 익명 함수 표현식
Comparator<int[]>를 간단하게 작성하는 방식
3. **다중 조건 정렬**
금 > 은 > 동 순서로 우선순위를 지정한 정렬 조건

```
if (금메달 수가 다르면) {
    금메달 수 내림차순으로 정렬
} else if (은메달 수가 다르면) {
    은메달 수 내림차순으로 정렬
} else {
    동메달 수 내림차순으로 정렬
}
```

---

### 람다식 정렬 문법 정리
| 상황          | 코드 예시                                                                |
| ----------- | -------------------------------------------------------------------- |
| 숫자 오름차순     | `list.sort((a, b) -> a - b);`                                        |
| 숫자 내림차순     | `list.sort((a, b) -> b - a);`                                        |
| 문자열 길이순 정렬  | `list.sort((a, b) -> a.length() - b.length());`                      |
| 커스텀 조건 여러 개 | `list.sort((a, b) -> { if (조건1) return ...; else return ...; });`    |
| 클래스일 때 정렬   | `list.sort(Comparator.comparingInt(o -> o.age));` 또는 `Comparable` 구현 |

---

### 비슷한 문제 추천
- 백준 12018번 – Yonsei TOTO

- 백준 10989번 – 수 정렬 3

- 백준 11650번 – 좌표 정렬하기

- 백준 5648번 – 역원소 정렬

- 백준 2910번 – 빈도 정렬

