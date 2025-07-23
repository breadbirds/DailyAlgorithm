# 백준 2512 예산 | 실버 2
[🐲 문제 바로가기]
(https://www.acmicpc.net/problem/2512)

사실 이 문제는 이분탐색으로 풀어야할지 몰라서 감을 잡기가 어려웠다.

### 나의 코드
```java
package source_code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_S2_2512_budget {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int cityCnt = Integer.parseInt(br.readLine());
		String[] budgets = br.readLine().split(" ");
		int[] cityBudget = new int[cityCnt];

		for (int i = 0; i < cityCnt; i++) {
			cityBudget[i] = Integer.parseInt(budgets[i]);
		}

		int totalBudget = Integer.parseInt(br.readLine());

		// 각 예산 합이 총액보다 작으면 그냥 바로 출력
		int sumBudget = 0;
		int maxBudget = 0;

		for (int i : cityBudget) {
			sumBudget += i;
		}

		if (sumBudget <= totalBudget) {
			maxBudget = getMaxBudget(cityCnt, cityBudget);
		} else { // 그게 아니라면 상한선 찾아서 출력하기
			maxBudget = findMaxLine(cityCnt, cityBudget, totalBudget);
		}

		System.out.println(maxBudget);

	}

	private static int findMaxLine(int cityCnt, int[] cityBudget, int totalBudget) {
		// **
		int left = 0;
		int right = 0;

		for (int i = 0; i < cityCnt; i++) {
			right = Math.max(right, cityBudget[i]);
		}

		int answer = 0;

		while (left <= right) {
			int mid = (left + right) / 2;
			int sum = 0;

			for (int i = 0; i < cityCnt; i++) {
				sum += Math.min(cityBudget[i], mid);
			}

			if (sum <= totalBudget) {
				answer = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return answer;
	}

	private static int getMaxBudget(int cityCnt, int[] cityBudget) {
		int maxBudget = 0;

		for (int i = 0; i < cityCnt; i++) {
			if(cityBudget[i] > maxBudget) {
				maxBudget = cityBudget[i];
			}
		}

		return maxBudget;
	}

}

```

</br>

### 이진 탐색을 왜 쓰는가?
이 문제는 결국 예산 배정 상한선 중에서 가능한 최대 값을 찾아라! 라는 최적화 문제이다.
가능한 상한선은 수직선 위의 연속된 정수 값이다.
즉, 정답이 될 수 있는 범위가 정렬된 상태인 셈
=> 이런 상황에 맞는 것이 이진 탐색!

상한선을 0부터 150까지 하나하나 시도하며 합을 비교하면 시간초과 발생.

이진 탐색을 쓴다면?
- 매번 상한선 후보를 절반으로 나눔
- 조건을 만족하면 상한선을 더 키움
- 조건을 넘으면 상한선 줄임 -> 이렇게 해서 정답을 빠르게 수렴 가능!

</br>

#### 개념
이진 탐색이란 정렬된 데이터에서 원하는 값을 빠르게 찾기 위한 알고리즘
탐색 범위를 매번 절반씩 줄요가며 원하는 것을 찾는 방식이다.
탐색 범위를 매번 절반씩 줄여가며 원하는 값을 찾는 방식이기 때문에 시간복잡도는 O(log N)으로 매우 효율적!

#### 이진 탐색 사용할 때
1. 탐색 대상이 정렬되어 있음
2. 값의 위치를 찾거나, 조건을 만족하는 값 중 최솟값/최댓값을 찾고 싶을 때
	 - 조건을 만족하는 가장 큰 값, 정답이 될 수 있는 최소값 등
     
#### 작동 원리
1. left, right 값을 정해서 탐색 범위 설정
2. mid = (left + right) / 2로 중간값을 구함
3. mid가 원하는 조건을 만족하면 정답 후보로 저장하고 더 나은 값을 찾아 범위 이동
4. 조건을 만족하지 않으면 반대 방향으로 범위 이동
5. left > right가 될 때까지 반복

</br>

### 리팩토링 코드
```java
package source_code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_S2_2512_budget {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		int[] requests = new int[n];

		int totalRequested = 0;
		int maxRequest = 0;

		for (int i = 0; i < n; i++) {
			requests[i] = Integer.parseInt(input[i]);
			totalRequested += requests[i];
			maxRequest = Math.max(maxRequest, requests[i]);
		}

		int totalBudget = Integer.parseInt(br.readLine());

		int result = (totalRequested <= totalBudget)
				? maxRequest
				: getUpperLimit(requests, totalBudget);

		System.out.println(result);
	}

	private static int getUpperLimit(int[] requests, int totalBudget) {
		int left = 0;
		int right = 0;
		for (int req : requests) right = Math.max(right, req);

		int answer = 0;

		while (left <= right) {
			int mid = (left + right) / 2;
			long sum = 0;

			for (int req : requests) {
				sum += Math.min(req, mid);
			}

			if (sum <= totalBudget) {
				answer = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return answer;
	}
}

```

| 변경 전                                   | 변경 후                                       |
| -------------------------------------- | ------------------------------------------ |
| `cityCnt`, `cityBudget`, `maxBudget` 등 | `n`, `requests`, `maxRequest` → 변수 의미 간결하게 |
| `getMaxBudget()` 분리                    | 굳이 함수화 없이 루프 안에서 바로 처리                     |
| `findMaxLine()` → `getUpperLimit()`    | 함수명 의도 명확하게 변경                             |
| sum 자료형 `int`                          | `long`으로 변경해 안전성 확보 (예산 최대합 10억 이상 가능)     |
| 불필요한 if/else 분리                        | 삼항 연산자로 간단하게 처리                            |

</br>

### 이진탐색 연습 문제 추천
**입문 / 기초 개념 익히기
**1920 - 수 찾기
🔗 https://www.acmicpc.net/problem/1920

배열에 특정 수가 있는지 이진 탐색으로 확인

Arrays.binarySearch() 없이 구현 추천

10816 - 숫자 카드 2
🔗 https://www.acmicpc.net/problem/10816

중복된 수가 몇 개인지 이진 탐색으로 개수 세기

lower bound / upper bound 개념 훈련 가능

2805 - 나무 자르기 🌲
🔗 https://www.acmicpc.net/problem/2805

절단기 높이를 이진 탐색으로 조정하는 전형적인 이분 탐색 최적화 문제

**중급 / 최댓값 or 최솟값 구하기 유형
**
1654 - 랜선 자르기 ✂️
🔗 https://www.acmicpc.net/problem/1654

랜선 길이의 최대값을 구하는 이진 탐색

조건 만족하는 최대값 찾기 연습

2110 - 공유기 설치 📶
🔗 https://www.acmicpc.net/problem/2110

공유기 간 최소 거리의 최대값을 이진 탐색

조건 만족 여부를 체크하는 방식 훈련에 좋아

3079 - 입국심사
🔗 https://www.acmicpc.net/problem/3079

시간 기준으로 최소값 구하는 parametric search 유형

