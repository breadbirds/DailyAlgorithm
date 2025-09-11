
# [백준- S5] 4659. 비밀번호 발음하기

## ⏰  **time**
30분

## :pushpin: **Algorithm**
- 시뮬레이션
- 구현

## ⏲️**Time Complexity**
$O(N * L)$ => 최악의 경우 $o(N^2)$

- 문자열 길이 `L`
- 입력 개수 `N`

## :round_pushpin: **Logic**

1. 모음이 존재하는 지 확인하는 함수
2. 연속으로 모음이나 자음이 3번씩 등장하는 지 확인하는 함수
3. 같은 문자가 연속으로 2번 나타나는지 확인하는 함수(e와 o 제외)

```java
static boolean checkAEIOU(String input) {

	for (char ch : input.toCharArray()) {
		if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
			return true;
		}
	}

	return false;
}
```
```java
static boolean checkContinuous(String input) {

	char[] chars = input.toCharArray();
	for (int i = 0; i < chars.length - 2; i++) {
		if (checkAEIOU(chars[i] + "") && checkAEIOU(chars[i + 1] + "") && checkAEIOU(chars[i + 2] + "")) {
			return false;
		}
		if (!checkAEIOU(chars[i] + "") && !checkAEIOU(chars[i + 1] + "") && !checkAEIOU(chars[i + 2] + "")) {
			return false;
		}
	}

	return true;
}
```
```java
static boolean checkSameChar(String input) {

	char[] chars = input.toCharArray();
	for (int i = 0; i < chars.length - 1; i++) {
		if (chars[i] != 'e' && chars[i] != 'o' && chars[i] == chars[i + 1]) {
			return false;
		}
	}

	return true;
}
```

## :black_nib: **Review**
모음인지 확인할 때, `"aeiou".indexOf(c) != -1` 를 활용하면 더 간결하게 가는ㅇ하다.


## 📡**Link**
- https://www.acmicpc.net/problem/4659

