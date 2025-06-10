## 백준 삼각형과 세 변 | 브론즈 3

[🍃 문제 바로가기](https://www.acmicpc.net/problem/5073)

### 나의 코드
```java
package source_code;

import java.util.Scanner;

// 삼각형의 세 변의 길이에 따른 경우의 수
// Equilateral : 세 변의 길이가 모두 같은 경우
// Isosceles : 두 변의 길이만 같은 경우
// Scalene : 세 변의 길이가 모두 다른 경우
// 삼각형 조건 만족 x => Invalid (가장 긴 변의 길이보다 나머지 두 변의 길이 합이 길어야 함)

// 입력: 1000 이하 양의 정수 3개 (막 줄은 0 0 0)
// 출력: 유형 출력

public class B_B3_5073_trianglecheck {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int first = sc.nextInt();
		int second = sc.nextInt();
		int third = sc.nextInt();
		
		while(first != 0) {
			// 조건 확인
			int maxLine = Math.max(Math.max(first, second), third);
			if(maxLine < first + second + third - maxLine) {
				if(first == second && second == third) {
					System.out.println("Equilateral");
				} else if(first == second || second == third || first == third) {
					System.out.println("Isosceles");
				} else {
					System.out.println("Scalene");
				}
			} else {
				System.out.println("Invalid");
			}
			
			first = sc.nextInt();
			second = sc.nextInt();
			third = sc.nextInt();
		}
		
	}

}
```

#### 코드 피드백
`좋은 점`

- 조건 분기 명확: 최대 길이 계산 → 삼각형 조건 판별 → 세 변 비교 → 출력 순서가 명확하게 잘 구성됨
- 입력 반복 처리: while (first != 0)로 종료 조건을 깔끔하게 처리함

`개선 포인트`

1. **입력 반복 로직 개선**
	현재 while 루프 내에 first = sc.nextInt();가 두 번 존재
	반복 코드 없이 while(true)와 break를 활용하면 더 깔끔하게 구성할 수 있음
    </br>
2. **입력값 배열화로 가독성 향상**
	세 변을 배열로 처리하면 최대값 계산, 총합 계산이 간결해짐
        </br>

3. **입력값 정렬하면 더 직관적**
  Arrays.sort()를 통해 가장 긴 변이 항상 마지막에 오도록 하면, 삼각형 조건 검사 (a + b > c)가 더 명확해짐

</br>

### 개선 코드
```java
import java.util.*;

public class B_B3_5073_trianglecheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int[] sides = new int[3];
            sides[0] = sc.nextInt();
            sides[1] = sc.nextInt();
            sides[2] = sc.nextInt();

            if (sides[0] == 0 && sides[1] == 0 && sides[2] == 0) break;

            Arrays.sort(sides);

            if (sides[0] + sides[1] <= sides[2]) {
                System.out.println("Invalid");
            } else if (sides[0] == sides[2]) {
                System.out.println("Equilateral");
            } else if (sides[0] == sides[1] || sides[1] == sides[2]) {
                System.out.println("Isosceles");
            } else {
                System.out.println("Scalene");
            }
        }
    }
}
```

