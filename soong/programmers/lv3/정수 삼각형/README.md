# [프로그래머스 - Lv3] 정수 삼각형

## ⏰  **time**
60분

## :pushpin: **Algorithm**
DP

## ⏲️**Time Complexity**
$O(N^2)$


## :round_pushpin: **Logic**

가장 바닥 부터 시작해서 대각선 방향으로 한 칸 오른쪽 또는 왼쪽의 수와 더해 둘 중 큰 값을 `result`에 더한다.
- `result[i][j]`는 `(i, j)` 위치에서 시작해 바닥까지 내려갈 수 있는 최대 합을 의미한다.

- 점화식
```java
result[i][j] = triangle[i][j]
             + Math.max(result[i + 1][j], result[i + 1][j + 1]);
```

```java
int n = triangle.length;
int[][] result = new int[n][n];
// 가장 바닥 숫자 
for (int i = 0; i < triangle[n - 1].length; i++) {
	result[n - 1][i] = triangle[n - 1][i];
}

for (int i = n - 2; i >= 0; i--) {
	for (int j = 0; j < triangle[i].length; j++) {
		int num = triangle[i][j];
		result[i][j] = num + Math.max(result[i + 1][j], result[i + 1][j + 1]);
	}
}
```

## :black_nib: **Review**



## 📡**Link**
- https://school.programmers.co.kr/learn/courses/30/lessons/43105
