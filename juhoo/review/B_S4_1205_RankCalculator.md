# 백준 1205 등수 구하기 | 실버 4
[👾 문제 바로가기](https://www.acmicpc.net/problem/1205)

### 나의 코드
```java
package source_code;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 입력: N(리스트의 점수 개수), 새로운 점수, P(랭킹 리스트에 올라 갈 수 있는 점수 개수)
// 입력: N개의 점수 비오름차순으로 제공
// 출력: 태수의 new 점수의 등수

// 1. 입력받기
// 1-1. 점수 개수, 태수 점수, 리스트 전체 크기 저장
// 1-2. 현재 리스트의 점수들을 리스트에 저장

// 2. 등수 구하기

// 3. 출력하기

public class B_S4_1205_RankCalculator {
	public static void main(String[] args) {
		// 1. 입력받기
		Scanner sc = new Scanner(System.in);

		// 1-1. 점수 개수, 태수 점수, 리스트 전체 크기 저장
		int currentRankNum = sc.nextInt();
		int newScore = sc.nextInt();
		int fullNum = sc.nextInt();

		// 1-2. 현재 리스트의 점수들을 리스트에 저장
		List<Integer> scores = new ArrayList<>();

		for (int i = 0; i < currentRankNum; i++) {
			scores.add(sc.nextInt());
		}

		// 2. 등수 구하기
		// 2-1. 앞에서부터 태수 점수와 비교
		int result = 0;
		int i = scores.size() - 1;
		int lastNum = (currentRankNum != 0) ? scores.get(scores.size() - 1) : 0;

		while (true) {
			// 2-5. 기존 배열에 있는 점수 개수가 0이면 result에 1 저장
			if (currentRankNum == 0 && fullNum > 0) {
				result = 1;
				break;
			}

			// 마지막 숫자와 비교해서 new number보다 크거나 같으면 -1 return (다 찼으면)
			if (lastNum >= newScore && scores.size() >= fullNum) {
				result = -1;
				break;
			}

			// 마지막 숫자와 비교해서 new number보다 작으면 왼쪽으로 이동하면서 count
			if ((scores.size() < fullNum) || (lastNum <= newScore)) {
				while (i >= 0 && scores.get(i) <= newScore) {
					i--;
				}

				if (i >= 0 && scores.get(i) == newScore) {
					result = i + 1;
				} else {
					result = i + 2;
				}

				break;
			}

		}

		// 3. 출력하기
		System.out.println(result);
	}

}

```

구현 문제라 문제 자체가 막 어렵진 않았는데,,, 반례 찾는데 시간을 대부분 사용한 문제.
은근히 반례가 많았고 (내 코드에 구멍이 많았다는 이야기겠지만) 시도를 엄청 많이 한 문제였다.

#### 코드 분석
문제를 요약하자면,
- 점수 리스트는 비오름차순
- 같은 점수는 같은 등수
- 리스트가 가득 찬 경우, 동점 이하이면 못 들어감
- 태수의 점수가 랭킹에 들어가면 그 등수 입력, 못들어가면 -1

예외 처리나 동점 처리, 리스트 꽉 참 처리 등을 적절히 처리했으나 가독성이 떨어져 다소 복잡해보이는 코드인 것 같다.

#### 개선 포인트
현재 나의 로직인 끝에서부터 역순으로 찾는 구조인데, 대부분의 랭킹 문제는 앞에서부터 순방향으로 비교하면 더 명확하다는 피드백을 받았다.

ㄴ 초기 생각은 그저 비오름차순으로 정렬이 이미 되어있기도 하고, 전체 리스트 개수도 비교해야하니 역순으로 비교하는게 좋을 것 같다는 생각을 했었다.

근데 이렇게 하면 진입 여부 판단이 용이하나, 결국 등수는 앞에서부터 세야 하니까 i+1, i+2 등의 보정이 필요하고 이는 결국 가독성을 해친다.

</br>

### 개선 코드
```java
package source_code;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B_S4_1205_RankCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int currentRankNum = sc.nextInt();  // 현재 랭킹 수
        int newScore = sc.nextInt();        // 태수 점수
        int fullNum = sc.nextInt();         // 최대 랭킹 수

        List<Integer> scores = new ArrayList<>();
        for (int i = 0; i < currentRankNum; i++) {
            scores.add(sc.nextInt());
        }

        int rank = 1;
        for (int score : scores) {
            if (score > newScore) {
                rank++;
            } else {
                break; // 동점이거나 낮은 점수 만나면 멈춤
            }
        }

        // 현재 랭킹이 다 찼고, 태수 점수가 마지막 점수 이하라면 못 들어감
        if (currentRankNum == fullNum && rank > fullNum) {
            System.out.println(-1);
        } else {
            System.out.println(rank);
        }
    }
}

```

- 불필요한 반복과 조건 분기 제거
- IndexOutOfBounds 가능성 제거
- 가독성 좋은 등수 계산 방식 적용

굳이 처음부터 예외를 따지기 보다는 rank를 계산하고 마지막에 그 rank가 범위를 넘냐 안넘냐를 따져서 예외 처리해주기.

역시 가독성이 좋은 코드를 짜는건 쉽지 않다.