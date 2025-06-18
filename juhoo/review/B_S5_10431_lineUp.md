# 백준 10431 줄세우기 | 실버 5

[🍋 문제 바로가기](https://www.acmicpc.net/problem/10431)

#### 문제 유형
- 구현/시뮬레이션
- 리스트 삽입 위치 조작
- 정렬과는 무관한 "순차적 조건 기반 삽입"

</br>

#### 핵심 알고리즘 로직 요약
- 앞에 서 있는 학생들 중에서 자기보다 큰 학생이 있으면, 그 중 가장 앞의 학생 바로 앞에 선다.
- 큰 학생이 없다면 그냥 뒤에 선다.
- 삽입 시 뒤로 밀리는 학생 수를 총 걸음 수로 누적 계산한다.

</br>

#### 주요 사용 문법
```java
List<Integer> list = new ArrayList<>();
list.add(index, value); // 특정 위치에 값 삽입
list.indexOf(value); // 값의 인덱스 반환 (없으면 -1)

```

</br>

#### 문법 키워드 정리
| 키워드/함수              | 설명                               |
| ------------------- | -------------------------------- |
| `ArrayList`         | 크기 가변 리스트 자료구조                   |
| `add(index, value)` | 특정 인덱스에 값 삽입                     |
| `indexOf(value)`    | 해당 값의 첫 인덱스 반환 (중복 허용 시 유의)      |
| `Scanner`           | 콘솔 입력 처리                         |
| `for-each loop`     | 리스트 요소 순회 (`for (int x : list)`) |

</br>

### 나의 코드
```java
package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 키 순서대로 번호 부여 (작은 순서대로 1번부터)
// 학생 수 : 20명 (같은 키 x)

// 1. 아무나 한 명을 줄 맨 앞에 세움
// 2. 다음 학생이 맨 뒤에 서면서 규칙 이행
// 2-1. 자기 앞에 더 큰 애가 없으면 멈춤
// 2-2. 자기 앞에 더 큰 애가 한 명이라도 있으면 그 중에 가장 앞에 있는 애의 바로 앞에 섬
// (반복)

// 입력: 케이스 수 P, 케이스 별 순서
// 출력: 케이스 번호, 학생들이 물러난 걸음 수 총합

public class B_S5_10431_lineUp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int caseNum = sc.nextInt();

		for (int i = 0; i < caseNum; i++) {
			int statusCase = sc.nextInt();

			List<Integer> newStanding = new ArrayList<>();
			int backMove = 0;

			// 1. 한 명을 줄 맨 앞에 세움
			newStanding.add(sc.nextInt());

			for (int j = 0; j < 19; j++) {

				int currentStudent = sc.nextInt();

				// 2. 다음 학생이 맨 뒤에 서면서 규칙 이행
				boolean hasBigger = false;
				int tallerIdx = -1;

				for (int s : newStanding) {
					if (s > currentStudent) {
						hasBigger = true;
						tallerIdx = newStanding.indexOf(s);
						break;
					}
				}

				if (hasBigger) {
					// 2-2. 자기 앞에 더 큰 애가 한 명이라도 있으면 그 중에 가장 앞에 있는 애의 바로 앞에 섬
					newStanding.add(tallerIdx, currentStudent);

					// 새로 들어온 애 뒤의 사람 수만큼 물러나야 함
					backMove += newStanding.size() - (tallerIdx + 1);
				} else {
					// 2-1. 자기 앞에 더 큰 애가 없으면 stop
					newStanding.add(currentStudent);
				}
			}

			System.out.println(statusCase + " " + backMove);

		}
	}

}

```

#### 피드백
`개선점`
- **for-each 루프 + indexOf 조합 비효율적**
	indexOf()는 내부에서 선형 탐색이므로 O(n)이 추가 발생
    이미 루프를 돌고 있기 때문에 index를 직접 가져오는게 더 좋음

- **hasBigger 변수 불필요**
	tallerIdx가 -1인지만 검사하면 조건 분기 가능

</br>

### 리팩토링 코드
```java
package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 백준 10431번: 줄세우기
// 학생을 키 순서대로 세우는 과정에서 뒤로 물러난 걸음 수를 계산하는 시뮬레이션 문제

public class B_S5_10431_lineUp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int caseCount = sc.nextInt();

        for (int i = 0; i < caseCount; i++) {
            int caseId = sc.nextInt();

            List<Integer> line = new ArrayList<>();
            int backMove = 0;

            // 첫 번째 학생은 무조건 맨 앞에 선다
            line.add(sc.nextInt());

            // 나머지 19명 처리
            for (int j = 0; j < 19; j++) {
                int current = sc.nextInt();
                int insertIdx = -1;

                // 자신보다 큰 학생을 처음 만나는 위치를 탐색
                for (int k = 0; k < line.size(); k++) {
                    if (line.get(k) > current) {
                        insertIdx = k;
                        break;
                    }
                }

                if (insertIdx != -1) {
                    // 더 큰 학생 앞에 삽입하고, 뒤로 물러난 학생 수 누적
                    line.add(insertIdx, current);
                    backMove += line.size() - insertIdx - 1;
                } else {
                    // 큰 학생이 없으면 맨 뒤에 선다
                    line.add(current);
                }
            }

            System.out.println(caseId + " " + backMove);
        }
    }
}

```