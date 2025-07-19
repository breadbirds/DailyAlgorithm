# 백준 13305 주유소 | 실버 3
[👑 문제 바로가기](https://www.acmicpc.net/problem/13305)

### 나의 코드
```java
package source_code;

import java.util.Scanner;

// 1km = 1리터
// 1 도시 = 1 주유소

// 입력: 도시 개수 // 도로의 길이 // 주유소의 리터당 가격
// 출력: 최소 비용

public class B_S3_13305_gasStation {
	public static void main(String[] args) {
		// 1. 입력받기 - 각각 배열
		Scanner sc = new Scanner(System.in);

		int cityCnt = sc.nextInt();
		long[] cityCost = new long[cityCnt];
		int[] loadLength = new int[cityCnt - 1];
		
		for (int i = 0; i < cityCnt - 1; i++) {
			loadLength[i] = sc.nextInt();
		}

		for (int i = 0; i < cityCnt; i++) {
			cityCost[i] = sc.nextInt();
		}

		// 2. 도시 배열을 돌면서 계산하기
		int currentIndex = 0;
		int nextIndex = 1;
		int loadIndex = 1;
		long resultCost = cityCost[0] * loadLength[0];

		while (loadIndex < cityCnt - 1 && nextIndex < cityCnt && currentIndex < cityCnt) {

			if (cityCost[currentIndex] <= cityCost[nextIndex]) {
				resultCost += cityCost[currentIndex] * loadLength[loadIndex];
				nextIndex++;
				loadIndex++;
			} else {
				resultCost += cityCost[nextIndex] * loadLength[loadIndex];
				currentIndex = nextIndex;
				nextIndex++;
				loadIndex++;
			}

		}

		System.out.println(resultCost);
	}

}
```

제일 처음 도시에서 무조건 한 번은 주유를 해야하니,
첫 cost를 설정하고 난뒤에는 next 인덱스를 뒤로 옮겨가면서 current 도시가 더 값이 싸면 여기서 주유를 다 계산하도록 했다. 
만약 next 도시가 더 싸면 거기로 current를 옮기는 방식.

처음에 int로 전부 설정했다가 서브테스크에서 걸려서 long으로 수정하니 100점이 되었다.

#### 코드리뷰
`개선 포인트`

- **불필요한 인덱스 관리**

  - currentIndex, nextIndex, loadIndex가 모두 필요하지는 않다. 하나의 루프 변수만으로 충분히 해결 가능
  - currentIndex가 가장 싼 주유소 위치라는 개념이 애매하게 쓰임
  
- **while문 -> for문으로 단순화 가능**
  - 도시 수가 N일 때, 길이는 N-1이므로 i를 0부터 N-2까지 루프 돌면서 처리하면 더 간결해짐
  
- **가독성 향상**
  - 의미가 중복되는 변수 정리
  
</br>

### 리팩토링 코드
```java
import java.util.Scanner;

public class B_S3_13305_gasStation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // 도시 개수
		int[] distances = new int[n - 1];
		long[] prices = new long[n];

		for (int i = 0; i < n - 1; i++) {
			distances[i] = sc.nextInt();
		}

		for (int i = 0; i < n; i++) {
			prices[i] = sc.nextInt();
		}

		long totalCost = 0;
		long minPrice = prices[0];

		for (int i = 0; i < n - 1; i++) {
			if (prices[i] < minPrice) {
				minPrice = prices[i];
			}
			totalCost += minPrice * distances[i];
		}

		System.out.println(totalCost);
	}
}

```