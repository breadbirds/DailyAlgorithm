# [백준 - S3] 2075. N번째 큰 수

## 알고리즘
우선순위 큐

## 구현 로직
### 1. 최대힙 사용
1. 우선순위 큐 `pq`에 모든 수를 집어 넣고, `Collections.reverse()`를 통해 내림차순 정렬을 한다.
2. N번째 전까지 `poll()`을 통해, 수를 꺼내고
2. N번째 수를 출력한다.

- 시간 복잡도 : $O((N^2) log(N^2))$

```java
for (int i = 0; i < N - 1; i++) {
	pq.poll();
}
System.out.println(pq.poll());
```

### 2. 최소힙 사용

1. 최대 `N`개의 수만 유지한다.
2. 힙의 크기가 `N`을 초과하면, 가장 작은 수인 루트를 제거하며, **항상 N개의 가장 큰 수**만 남긴다.
3. 마지막의 최소 힙의 루트 값이 정답이 된다.

- 최대 힙을 사용하면, NxN개의 모든 수를 큐에 집어넣어야 하기때문에, 메모리 낭비가 심하다. 
- `N`이 1,500까지 가능하므로, 최대 1,500x1,500 = 2,250,000개의 숫자를 넣게 된다.
- 시간 복잡도 : $O((N^2) log(N))$

```java
for (int i = 0; i < N; i++) {
    String[] split = br.readLine().split(" ");
    for (int j = 0; j < N; j++) {
        int num = Integer.parseInt(split[j]);
        pq.add(num);

        // 힙 크기를 N으로 제한
        if (pq.size() > N) {
            pq.poll(); // 가장 작은 수 제거
        }
    }
}

System.out.println(pq.peek()); // N번째 큰 수
```