
# [백준 - S3] 1018. 체스판 다시 칠하기

## ⏰  **time**
60분


## ⏲️**Time Complexity**
$O(N^2)$

## 풀이 

- `(i + j) % 2` 를 기준으로 나누기

```java
static int check(int x, int y) {
	int repaintW = 0; // 왼쪽 위가 W인 체스판 기준
	int repaintB = 0; // 왼쪽 위가 B인 체스판 기준

	for (int i = x; i < x + 8; i++) {
		for (int j = y; j < y + 8; j++) {
			char current = map[i][j];
			// (i+j) % 2 == 0 → 왼쪽 위와 같은 색
			if ((i + j) % 2 == 0) {
				if (current != 'W')
					repaintW++;
				if (current != 'B')
					repaintB++;
			} else { // (i+j) % 2 == 1 → 왼쪽 위와 반대 색
				if (current != 'B')
					repaintW++;
				if (current != 'W')
					repaintB++;
			}
		}
	}
	return Math.min(repaintW, repaintB);
}
```

## :black_nib: **Review**


## 📡**Link**
- https://www.acmicpc.net/problem/1018

