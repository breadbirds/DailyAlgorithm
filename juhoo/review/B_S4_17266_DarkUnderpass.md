# 백준 17266 어두운 굴다리 | 실버 4
[🐲 문제 바로가기](https://www.acmicpc.net/problem/17266)

### 나의 코드
```java
package source_code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// 최소한의 높이로 굴다리를 밝히자
// 최소한의 예산이 들 높이 구하기 (but 가로등은 높이 모두 동일)
// 높이가 H : 왼쪽 H, 오른쪽 H만큼 밝혀짐

// 입력: 굴다리 길이 // 가로등 개수 // 설치할 수 있는 가로등 위치
// 출력: 굴다리 길이를 모두 비출 수 있는 가로등 최소 높이

public class B_S4_17266_DarkUnderpass {
	static List<Integer> lightDistance;

	public static void main(String[] args) {
		// 1. 입력받기
		Scanner sc = new Scanner(System.in);
		int underpassLength = sc.nextInt();
		int lightCnt = sc.nextInt();
		int[] lightLocation = new int[lightCnt];

		for (int i = 0; i < lightCnt; i++) {
			lightLocation[i] = sc.nextInt();
		}

		// 2. 가로등 사이의 간격 계산 후 저장
		lightDistance = new ArrayList<>();
		calculateLightDistance(lightLocation);

		// 3. 전체 가로등 앞 뒤 간격 계산
		lightDistance.add(lightLocation[0]);
		lightDistance.add(underpassLength - lightLocation[lightCnt - 1]);

		// 4. 간격들 중 가장 큰 값이 최소 높이
		int result = Collections.max(lightDistance);

		System.out.println(result);

	}

	private static void calculateLightDistance(int[] lightLocation) {
		for (int i = 1; i < lightLocation.length; i++) {
			int d = (lightLocation[i] - lightLocation[i - 1]) / 2;
			
			if ((lightLocation[i] - lightLocation[i - 1]) % 2 == 0) {
				lightDistance.add(d);
			} else {
				lightDistance.add(d + 1);
			}
		}
	}

}

```

그냥 .. 종이에 몇 번 끄적이고 풀었던 문제.
딱히 반례나 어려울 내용이 없어서 금방 해결했다.

다른 분들은 어떤 식으로 접근했는지는 모르겠으나 나는 일단 처음과 끝, 가로등 사이의 간격을 계산했다.

여기서 주의점은 가로등 사이의 간격은 물리적 간격을 그대로 적용하면 안되고, 조명이 이중으로 적용되니 절반만 적용해야한다. 그런데 무조건 거리는 정수이니 2로 나눠떨어지지 않으면 겹쳐지도록 1을 더해주었다.

그걸 전부 list에 넣고 Collections.max()를 이용해서 최대 거리를 구한다. 그럼 그게 가장 넓게 퍼져야 할 거리가 되는 것이고, 곧 가로등의 높이가 되는 것!

#### 코드리뷰
1. **메소드 책임 분리**
	- 현재 main()에서 너무 많은 일을 하고 있다.
    - 가독성과 테스트 용이성을 높이기 위해 구조를 나누자!

2. 산술 처리 간소화
	`int d = (gap + 1) / 2;`
    나는 짝수인지 홀수인지 판단해서 그에 따라 각각 대응하는 방식으로 짰는데, 그냥 일단 1 더해서 2로 나눠도 되는 것이었다!

3. 기타 개선 사항
	- lightDistance를 전역 필드로 둘 이유가 없음 -> 지역변수로 바꾸기
    - Scanner 닫는 습관 권장 (sc.close();)
    
</br>

### 리팩토링 코드
```java
public class B_S4_17266_DarkUnderpass {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int underpassLength = sc.nextInt();
        int lightCnt = sc.nextInt();
        int[] positions = new int[lightCnt];

        for (int i = 0; i < lightCnt; i++) {
            positions[i] = sc.nextInt();
        }

        System.out.println(getMinimumRequiredHeight(underpassLength, positions));
        sc.close();
    }

    private static int getMinimumRequiredHeight(int length, int[] positions) {
        List<Integer> heights = new ArrayList<>();
        heights.add(positions[0]);
        heights.add(length - positions[positions.length - 1]);

        for (int i = 1; i < positions.length; i++) {
            int gap = positions[i] - positions[i - 1];
            heights.add((gap + 1) / 2);
        }

        return Collections.max(heights);
    }
}

```