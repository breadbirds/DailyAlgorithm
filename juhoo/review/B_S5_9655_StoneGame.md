# 백준 9655 돌 게임 | 실버 5

[🍋 문제 바로가기](https://www.acmicpc.net/problem/9655)

### 내 코드
```java
package baekjoon;

import java.util.Scanner;

// 탁자 위에 돌 N개
// 턴 번갈아가면서, 돌은 1개 or 3개 가져감
// 마지막 돌을 가져가는 사람이 WIN!
// start는 상근

// 입력: N
// 출력: 상근 win -> SK, 창영 win -> CY

// 홀수: 상근 / 짝수: 창영

public class B_S5_9655_StoneGame {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int gameNum = sc.nextInt();
		if (gameNum % 2 == 1) {
			System.out.println("SK");
		} else {
			System.out.println("CY");
		}
	}

}

```

#### 피드백
`장점`
문제 조건이 명확히 주석으로 정리되어 있어 가독성 좋음.

규칙을 간단하게 홀수/짝수로 판단하여 로직을 아주 깔끔하게 처리함.

Scanner 사용과 조건문 구성 모두 간단하고 안정적.

`개선 포인트`

| 항목    | 제안                                                                         |
| ----- | -------------------------------------------------------------------------- |
| 주석    | 현재 주석도 좋지만, `왜 홀수면 SK가 이기는지`에 대한 간단한 게임 이론적 설명 추가하면 학습적 가치 ↑               |
| 입력 방식 | 문제 크기가 작아서 Scanner 충분하지만, 습관적으로 `BufferedReader`를 써보는 것도 추천 (입력 많을 땐 효율 ↑) |
| 리팩토링  | 조건문을 삼항연산자로 줄이면 한 줄로 가능하지만, 가독성 고려하면 현재 방식도 충분히 좋음                         |

