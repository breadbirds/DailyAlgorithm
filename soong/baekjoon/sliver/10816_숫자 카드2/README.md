
# [백준- S4] 10816. 숫자 카드2

## ⏰  **time**
30분

## :pushpin: **Algorithm**
구현

## ⏲️**Time Complexity**
$O(m)$
- `map.getOrDefault(key, 0)` → 평균 $O(1)$
- `map.put(key, value)` → 평균 $O(1)$

## :round_pushpin: **Logic**

수의 개수를 카운트한 후, `findNums`에 맞는 숫자의 개수를 출력하고 없으면 0출력하기

```java
HashMap<Integer, Integer> map = new HashMap<>();

for (int i = 0; i < n; i++) {
    int key = Integer.parseInt(split[i]);
	map.put(key, map.getOrDefault(key, 0) + 1);
}

m = Integer.parseInt(br.readLine());
split = br.readLine().split(" ");
for (int i = 0; i < m; i++) {
	int key = Integer.parseInt(split[i]);
	System.out.print(map.getOrDefault(key, 0) + " ");
}
```

## :black_nib: **Review**
아직 이정도는 쉬운 것 같은데 어떤 걸 더 공부해야하징~

## 📡**Link**
- https://www.acmicpc.net/problem/10816

