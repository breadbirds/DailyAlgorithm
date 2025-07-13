# 백준 20125 쿠키의 신체 측정 | 실버 4
[🎧 문제 바로가기](https://www.acmicpc.net/problem/20125)

### 나의 코드
```java
package source_code;

import java.util.Scanner;

// 입력: 판의 가로 세로 길이 /// 각 칸의 값 (_ or *)
// 출력: 심장이 위치한 x, y /// 왼쪽 팔, 오른쪽 팔, 왼쪽 다리, 오른쪽 다리 길이

// 1. 입력받기
// 1-1. 배열에 판 저장 - _이면 0, *이면 1로 변환하여 저장하기

// 2. 머리 찾기
// 2-1. 판에서 위에서부터 1이 포함된 첫 열 찾기

// 3. 심장 위치 찾기 - (머리 x값 -1) (머리 y값)

// 4. 팔 길이 계산
// 4-1. 심장 위치를 기준으로 값이 0이 될때까지 왼쪽으로 가면서 count
// 4-2. 심장 위치를 기준으로 값이 0이 될때까지 오른쪽으로 가면서 count

// 5. 다리 길이 계산
// 5-1. 허리 길이 끝 찾기 - 심장 위치를 기준으로 값이 0이 될 때까지 아래로 이동
// 5-2. 왼쪽 다리 길이 count
// 5-3. 오른쪽 다리 길이 count

// 6. 출력하기

public class B_B4_20125_cookie {
	public static void main(String[] args) {
		// 1. 입력받기
		Scanner sc = new Scanner(System.in);

		int boardWidth = sc.nextInt();
		sc.nextLine();

		int[][] board = new int[boardWidth][boardWidth];

		// 1-1. 배열에 판 저장 - _이면 0, *이면 1로 변환하여 저장하기
		for (int i = 0; i < boardWidth; i++) {
			String line = sc.nextLine();

			for (int j = 0; j < boardWidth; j++) {
				char c = line.charAt(j);

				if (c == '_') {
					board[i][j] = 0;
				} else {
					board[i][j] = 1;
				}
			}
		}

		int[] head = new int[2];
		int[] heart = new int[2];
		int leftArm = 0;
		int rightArm = 0;
		int leftLeg = 0;
		int rightLeg = 0;
		int waistLength = 0;

		// 2. 머리 좌표 찾기
		// 2-1. 판에서 위에서부터 1이 포함된 첫 열 찾기

		loop1: for (int i = 0; i < boardWidth; i++) {
			for (int j = 0; j < boardWidth; j++) {
				if (board[i][j] == 1) {
					head[0] = i + 1;
					head[1] = j + 1;
					break loop1;
				}
			}
		}

		// 3. 심장 위치 찾기 - (머리 x값 -1) (머리 y값)
		heart[0] = head[0] + 1;
		heart[1] = head[1];

		// 4. 팔 길이 계산
		// 4-1. 심장 위치를 기준으로 값이 0이 될때까지 왼쪽으로 가면서 count
		for (int j = heart[1] - 2; j >= 0; j--) {
			if (board[heart[0] - 1][j] == 1) {
				leftArm++;
			} else {
				break;
			}
		}

		// 4-2. 심장 위치를 기준으로 값이 0이 될때까지 오른쪽으로 가면서 count
		for (int j = heart[1]; j < boardWidth; j++) {
			if (board[heart[0] - 1][j] == 1) {
				rightArm++;
			} else {
				break;
			}
		}

		// 5. 다리 길이 계산
		// 5-1. 허리 길이 끝 찾기 - 심장 위치를 기준으로 값이 0이 될 때까지 아래로 이동
		for (int i = heart[0] + 1; i < boardWidth; i++) {
			if (board[i - 1][heart[1] - 1] == 1) {
				waistLength++;
			} else {
				break;
			}
		}

		// 5-2. 왼쪽 다리 길이 count
		for (int i = heart[0] + waistLength; i < boardWidth; i++) {
			if (board[i][heart[1] - 2] == 1) {
				leftLeg++;
			} else {
				break;
			}
		}

		// 5-3. 오른쪽 다리 길이 count
		for (int i = heart[0] + waistLength; i < boardWidth; i++) {
			if (board[i][heart[1]] == 1) {
				rightLeg++;
			} else {
				break;
			}
		}

		// 6. 출력하기
		// 출력: 심장이 위치한 x, y /// 왼쪽 팔, 오른쪽 팔, 허리, 왼쪽 다리, 오른쪽 다리 길이
		System.out.printf("%d %d\n", heart[0], heart[1]);
		System.out.printf("%d %d %d %d %d\n", leftArm, rightArm, waistLength, leftLeg, rightLeg);
	}

}

```

솔직히 이 문제는 온전한 구현 문제이기도 했고,,, 사실 큰 아이디어 없이 생각나는대로 코드를 짜서 길고 비효율적인 코드가 완성되었다,,
ㄴ 사실 판의 인덱스 카운트가 당연히 0부터인줄 알았는데 1부터였다.. 그래서 인덱스 카운트가 좀 이상할지도

### 최적화하기
```java
package source_code;

import java.util.Scanner;

public class B_B4_20125_cookie {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        boolean[][] board = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = (line.charAt(j) == '*');
            }
        }

        int headRow = -1, headCol = -1;

        // 머리 위치 찾기
        outer:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j]) {
                    headRow = i;
                    headCol = j;
                    break outer;
                }
            }
        }

        int heartRow = headRow + 1;
        int heartCol = headCol;

        // 팔 길이
        int leftArm = 0;
        for (int j = heartCol - 1; j >= 0 && board[heartRow][j]; j--) leftArm++;

        int rightArm = 0;
        for (int j = heartCol + 1; j < n && board[heartRow][j]; j++) rightArm++;

        // 허리 길이
        int waist = 0;
        int waistEndRow = heartRow + 1;
        for (int i = heartRow + 1; i < n && board[i][heartCol]; i++) {
            waist++;
            waistEndRow = i + 1;
        }

        // 다리 길이
        int leftLeg = 0;
        for (int i = waistEndRow; i < n && board[i][heartCol - 1]; i++) leftLeg++;

        int rightLeg = 0;
        for (int i = waistEndRow; i < n && heartCol + 1 < n && board[i][heartCol + 1]; i++) rightLeg++;

        // 출력
        System.out.printf("%d %d\n", heartRow + 1, heartCol + 1);
        System.out.printf("%d %d %d %d %d\n", leftArm, rightArm, waist, leftLeg, rightLeg);
    }
}

```

| 변경 사항                     | 이유                                      |
| ------------------------- | --------------------------------------- |
| `int[][]` → `boolean[][]` | `*` 여부만 판단하므로 더 직관적이고 공간 절약             |
| `n`을 가로/세로 길이로 통일         | 혼동 줄이고 가독성 개선                           |
| `outer:` 라벨 사용            | 머리 위치 첫 `*` 발견 후 즉시 루프 탈출               |
| 반복문 내 조건 단순화              | `j >= 0 && board[i][j]` 형식으로 불필요한 조건 제거 |
| `waistEndRow` 추적          | 다리 시작 위치를 저장하여 중복 계산 방지                 |

우선 기존에 나는 char 형태로 되어있던 판을 0과 1로 표기하려고 int[][]로 변경해서 저장했다. 그런데 이것도 사실 boolean 형태로 하면 공간이 더 절약된다!

그리고 2중 루프일 때 한 번에 어떻게 break; 하지에 대한 의문이 있었는데 라벨을 넣을 수 있다는걸 처음 알았다.

조건문도 애초에 판이 boolean 형태로 되어 있으니 비교하기가 훨씬 간편해졌다.

### 관련 개념 설명
#### 🤖 라벨 + break
자바는 중첩 루프를 빠르게 탈출할 수 있게 라벨을 지원함
```
outer: for (...) { for (...) { break outer; } }
```

#### 🤖 bloolean 배열
true false만을 저장하므로 메모리와 코드 가독성에 유리

#### 🤖 단일 책임 반복문 구조
각 신체 부위를 한 번씩만 탐색 -> 효율성 및 디버깅 용이

####  🤖 좌표 인덱스 변환
문제의 좌표는 (1,1)부터 시작하기 때문에 최종 출력시 +1 필요

