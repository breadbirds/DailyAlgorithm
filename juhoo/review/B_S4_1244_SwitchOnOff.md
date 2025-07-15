# 백준 1244 스위치 켜고 끄기 | 실버 4
[👾 문제 바로가기](https://www.acmicpc.net/problem/1244)

### 나의 코드
```java
package source_code;

import java.util.Scanner;

// 남: 받은 수의 배수인 스위치 상태 바꿈 (1)
// 여: 받은 수를 기준으로 그 수 포함, 양쪽으로 뻗어나가면서 같은 수면 다 바꿈 (2)

// 입력: 스위치 개수 // 스위치 각 상태들 // 학생 수 // 한 학생의 성별, 학생이 받은 수
// 출력: 스위치의 마지막 상태 (한 줄에 20개씩)

// 1. 입력받기
// 1-1. 배열에 스위치 상태 저장
// 1-2. 배열에 학생 정보 저장

// 2. 스위치 변경하기
// 2-1. 여자인지 남자인지 판별
// 2-2. 남자라면, 받은 수의 배수인 스위치 상태 변경
// 2-3. 만약 받은 수의 배수가 스위치 배열 크기보다 크다면 넘어감
// 2-4. 여자라면, 같은 수의 스위치 인덱스를 찾아 스위치 변경
// 2-5. 그 인덱스를 기준으로, 좌우로 동시 이동하면서 값이 같으면 스위치 변경
// 2-6. 값이 다르거나, 배열 인덱스를 벗어나면 멈춤

// 3. 최종 상태 출력하기

public class B_S4_1244_SwitchOnOff {
	static int[] switchStatus;

	public static void main(String[] args) {
		// 1. 입력받기
		Scanner sc = new Scanner(System.in);

		int switchCnt = sc.nextInt();
		switchStatus = new int[switchCnt];

		// 1-1. 배열에 스위치 상태 저장
		for (int i = 0; i < switchCnt; i++) {
			switchStatus[i] = sc.nextInt();
		}

		int studentCnt = sc.nextInt();
		int[][] student = new int[studentCnt][2];

		// 1-2. 배열에 학생 정보 저장
		for (int i = 0; i < studentCnt; i++) {
			for (int j = 0; j < 2; j++) {
				student[i][j] = sc.nextInt();
			}
		}

		// 2. 스위치 변경하기
		for (int i = 0; i < studentCnt; i++) {
			// 2-1. 여자인지 남자인지 판별
			int gender = student[i][0];
			int num = student[i][1];

			// 2-2. 남자라면, 받은 수의 배수인 스위치 상태 변경
			if (gender == 1) {
				int multiple = num;
				int n = 2;

				// 2-3. 만약 받은 수의 배수가 스위치 배열 크기보다 크다면 넘어감
				while (multiple <= switchCnt) {
					convertValue(multiple);
					multiple = num * n;
					n++;
				}
			} else if (gender == 2 && num <= switchCnt) { // 2-4. 여자라면, 같은 수의 스위치 인덱스를 찾아 스위치 변경
				convertValue(num);

				// 2-5. 그 인덱스를 기준으로, 좌우로 동시 이동하면서 값이 같으면 스위치 변경
				// 2-6. 값이 다르거나, 배열 인덱스를 벗어나면 멈춤
				int left = num - 1;
				int right = num + 1;

				while (left > 0 && right <= switchCnt && (switchStatus[left - 1] == switchStatus[right - 1])) {
					convertValue(left);
					convertValue(right);

					left--;
					right++;
				}
			}
		}

		// 3. 최종 상태 출력하기
		int i = 1;

		while (i <= switchCnt) {
			System.out.print(switchStatus[i-1] + " ");
			
			if(i % 20 == 0) {
				System.out.println();
			}

			i++;
		}
	}

	// 값을 반전시키는 함수
	private static void convertValue(int num) {
		switchStatus[num - 1] = (switchStatus[num - 1] == 1) ? 0 : 1;
	}

}
```

SSAFY 계절 학기 때 배운 상단에 풀이 과정 먼저 서술하고 코드 적기를 열심히 실천하고 있는 나..

#### 코드 리뷰
`개선 포인트`
- 남학생 루프(배수인 스위치 변경) -> 간결하게 정리 가능 `for (int m = num; m <= switchCnt; m += num)`
- 인덱스 -> 0-based 정리하면 -1 보정 반복을 줄일 수 있음
- 메서드 분리 -> processStudent()로 학생 처리를 분기하면 가독성 up

지난 문제와 마찬가지로.. 0-based를 쓰려고 하니 문제에서는 1-based로 계산해서 풀다가 나도 모르게 꼬여서 복잡해지는 것을 이번도 반복해버렸다.
앞으로는 문제의 인덱스가 0-based인지 1-based인지 먼저 체크하고 시작하자.

</br>

### 코드 최적화하기
```java
package source_code;

import java.util.Scanner;

public class B_S4_1244_SwitchOnOff {
    static int[] switchStatus;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int switchCount = sc.nextInt();
        switchStatus = new int[switchCount];

        for (int i = 0; i < switchCount; i++) {
            switchStatus[i] = sc.nextInt();
        }

        int studentCount = sc.nextInt();
        for (int i = 0; i < studentCount; i++) {
            int gender = sc.nextInt();
            int number = sc.nextInt();
            processStudent(gender, number - 1); // 0-based 인덱스
        }

        for (int i = 0; i < switchCount; i++) {
            System.out.print(switchStatus[i] + " ");
            if ((i + 1) % 20 == 0) System.out.println();
        }
    }

    private static void processStudent(int gender, int index) {
        if (gender == 1) { // 남학생
            for (int i = index; i < switchStatus.length; i += index + 1) {
                toggle(i);
            }
        } else { // 여학생
            toggle(index);
            int left = index - 1;
            int right = index + 1;
            while (left >= 0 && right < switchStatus.length && switchStatus[left] == switchStatus[right]) {
                toggle(left);
                toggle(right);
                left--;
                right++;
            }
        }
    }

    private static void toggle(int i) {
        switchStatus[i] ^= 1;
    }
}

```

우선 나는 삼항 연산자로 복잡하게 값을 switch했는데 최적화 예시에서는 **^= 연산자**로 훨씬 간단하게 바꾼게 인상적이었다.

#### ^= 복합 대입 연산자로 값 반전시키기
`^` -> XOR 비트연산자
`^=` -> 복합 대입 연산자

[비교]
```java
switchStatus[i] = (switchStatus[i] == 1) ? 0 : 1; // if문 방식
switchStatus[i] = 1 - switchStatus[i];           // 덧셈/뺄셈 방식
switchStatus[i] ^= 1;                             // XOR 방식 ← 가장 빠르고 짧음
```

이런 다양한 표현을 알아놓는게 도움이 될 것 같다.

