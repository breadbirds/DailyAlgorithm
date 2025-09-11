
# [백준- S5] 1193. 분수찾기

## ⏰  **time**
30분

## :pushpin: **Algorithm**
- 시뮬레이션
- 구현

## ⏲️**Time Complexity**
$O(\sqrt{X})$

## :round_pushpin: **Logic**

1. 누적합을 통해 몇 번째 대각선(`line`)에 속하는지 확인
2. 대각선 안에서 몇 번째 항인지 계산하여 `posInLine을` 구함
3. 대각선이 홀수인지 짝수인지에 따라 분자와 분모를 결정

```java
int line = 1;
int sum = 1; // 누적합
while (X > sum) {
	line++;
	sum += line;
}

int posInLine = X - (sum - line);
int a, b;
if (line % 2 == 0) { // 짝수일 때
	a = posInLine;
	b = line - posInLine + 1;

} else { // 홀수 일 때
	a = line - posInLine + 1;
	b = posInLine;
}
```

## :black_nib: **Review**
아니 백준 사이트 왜 안대


## 📡**Link**
- https://www.acmicpc.net/problem/1193

