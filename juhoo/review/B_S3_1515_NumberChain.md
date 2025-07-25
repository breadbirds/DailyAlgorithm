# 백준 1515 수 이어 쓰기 | 실버 3
[✈️ 문제 바로가기](https://www.acmicpc.net/problem/1515)

처음에 문제 이해가 잘 안가서 조금 시간이 걸렸던 문제,,

### 나의 코드

```java
package source_code;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B_S3_1515_NumberChain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] resultNum = sc.nextLine().toCharArray();
		int[] resultNumArray = new int[resultNum.length];

		for (int i = 0; i < resultNum.length; i++) {
			resultNumArray[i] = resultNum[i] - '0';
		}

		int targetIndex = 0;
		int currentN = 1;
		

		while (targetIndex < resultNumArray.length) {

			// 자릿수별로 나눠서 리스트에 저장
			List<Integer> numberList = new ArrayList<>();

			int num = currentN;

			while (num > 0) {
				numberList.add(0, num % 10);
				num /= 10;
			}
			

			// list의 수가 입력과 일치하면 index 옮기기
			for (int n : numberList) {
				if (targetIndex < resultNumArray.length && n == resultNumArray[targetIndex]) {
					targetIndex++;
				}
			}

			currentN++;
		}
		
		System.out.println(currentN - 1);
	}

}

```

나는 우선 들어오는 입력을 배열에 저장해두고,
1부터 계속 증가하는 정수를 자릿수별로 cut해서 list에 저장함.
그리고 list에 있는 수들이 현재 pointer가 가리키고 있는 입력의 수와 일치하면 pointer를 옆으로 옮김.
그러면서 반복문 한 번 돌 때마다 숫자 count.
그리고 입력의 끝까지 pointer를 옮겼다면 반복문 종료.

그럼 자동으로 count된 마지막 수가 정답이 됨.

** 각 자릿수별로 cut 하려면 나머지 구하고 나누기를 하기..!

그리고 char를 int로 변환할 때 아무생각 없이 `- 0` 으로 했다가 결과가 이상하게 나왔었다. `- '0'` 따옴표 꼭 붙이기!

#### 코드 리뷰
`잘한 점`
- 자릿수 분해 방식 깔끔
- 부분 수열 비교 로직 정확

`개선 포인트`
- resultNumArray 대신 char를 직접 비교해도 충분함
- 리스트 없이 문자열로 바로 비교 가능

</br>

### 리팩토링 코드
```java
package source_code;

import java.util.Scanner;

public class B_S3_1515_NumberChain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] target = sc.nextLine().toCharArray();

        int targetIndex = 0;
        int currentN = 1;

        while (targetIndex < target.length) {
            String numStr = String.valueOf(currentN);

            for (int i = 0; i < numStr.length(); i++) {
                if (targetIndex < target.length && numStr.charAt(i) == target[targetIndex]) {
                    targetIndex++;
                }
            }

            currentN++;
        }

        System.out.println(currentN - 1);
    }
}

```

