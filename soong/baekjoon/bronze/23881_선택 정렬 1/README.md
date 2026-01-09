## [백준 - B1] 23881. 알고리즘 수업 - 선택 정렬 1

## 시간 복잡도
$O(N²)$

## 선택 정렬이란?

> 배열에서 아직 정렬되지 않은 부분에서 **가장 큰 값** 을 하나 선택해
  그 값을 가장 뒤(`last`)로 보내는 과정을 반복하는 정렬 알고리즘이다.

처음 `last = N - 1`이고 단계를 거듭할 수록 `N - 2`, `N - 3` .. 으로 줄어든다.
`0 ~ last` 구간에서 가장 큰 값을 찾아, 그 값을 맨 뒤(`last`)로 보내는 방식

## 코드

```java
static void selectionSort(int[] nums, int last) {

		if (last <= 0) {
			return;
		}

		int max = nums[0];
		int maxIdx = 0;
		for (int i = 0; i <= last; i++) {
			if (max < nums[i]) {
				max = nums[i];
				maxIdx = i;
			}
		}

		if (maxIdx != last) {
			int tmp = nums[maxIdx];
			nums[maxIdx] = nums[last];
			nums[last] = tmp;
			swapCnt++;
			if (swapCnt == K) {
  				System.out.println(nums[maxIdx] + " " + nums[last]);
  				System.exit(0);
			}
		}
  selectionSort(nums, last - 1);
}
```

## 링크
https://www.acmicpc.net/problem/23881
