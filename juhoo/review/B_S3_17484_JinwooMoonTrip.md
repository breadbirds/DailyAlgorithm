# 백준 17484 진우의 달 여행 | 실버 3

[🏎️ 문제 바로가기](https://www.acmicpc.net/problem/17484)

### 나의 코드
```java
package source_code;

import java.util.Scanner;

// 최소 연료 사용
// 왼, 정면, 우 이동 가능

public class B_17484_JinwooMoonTrip {
	static int[] dx = { -1, 0, 1 };
	static int N = 0;
	static int M = 0;
	static int result = Integer.MAX_VALUE;
	static int[][] space;

	public static void main(String[] args) {
		// 입력 받기
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		space = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				space[i][j] = sc.nextInt();
			}
		}

		// DFS 깊이 탐색 실시
		for (int j = 0; j < M; j++) {
			dfs(0, j, space[0][j], -1);
		}

		System.out.println(result);

	}

	private static void dfs(int y, int x, int sum, int prevDir) {
		if (y == N - 1) {
			result = Math.min(result, sum);
			return;
		}

		for (int dir = 0; dir < 3; dir++) {
			if (dir == prevDir)
				continue; // 같은 방향 연속 불가능

			int ny = y + 1;
			int nx = x + dx[dir];

			if (nx < 0 || nx >= M)
				continue;

			dfs(ny, nx, sum + space[ny][nx], dir);
		}
	}

}

```

정말 오랜만에 푼 DFS.. 

### 문제 개요
지구와 달 사이는 N x M 크기의 연료 맵으로 구성
진우는 가능한 한 연료를 적게 소모해서 달에 도착해야 함

단, 연속해서 같은 방향으로 이동 불가능

### DFS로 풀이하기
이 문제는 한 칸씩 내려가면서 세 방향 중 하나를 선택해야 하므로, 모든 경로를 완전 탐색하는 방식이 적합.

-> 이럴 때 사용하는 탐색이 DFS(깊이 우선 탐색)

### 구조 설명
`private static void dfs(int y, int x, int sum, int prevDir)`

- y, x: 현재 위치
- sum: 지금까지 경로의 누적 연료
- prevDir: 직전에 선택한 방향

#### 핵심 조건
1. 방향은 왼쪽 아래, 아래, 오른쪽 아래로만 이동 가능
2. 같은 방향 연속 두 번 불가능
3. 맵을 벗어나면 안됨

### 코드 핵심 로직
```java
for (int j = 0; j < M; j++) {
    dfs(0, j, space[0][j], -1); // 첫 행 모든 열에서 출발 가능
}

```

- 첫 행의 모든 열에서 출발
- 시작 시에는 이전 방향이 없으므로 -1로 전달

```java
if (y == N - 1) {
    result = Math.min(result, sum); // 마지막 행에 도착하면 최소값 갱신
    return;
}

```
- 마지막 행에 도달하면 연료 소비량 sum을 최소값으로 갱신함

#### DFS + 방향제한 처리
```java
for (int dir = 0; dir < 3; dir++) {
    if (dir == prevDir) continue; // 같은 방향 연속 이동 금지
    int ny = y + 1;
    int nx = x + dx[dir];
    
    if (nx < 0 || nx >= M) continue; // 범위 밖이면 스킵

    dfs(ny, nx, sum + space[ny][nx], dir);
}

```

- 방향은 dx = {-1, 0, 1}로 설정
- 이전 방향과 같으면 건너 뜀
- 재귀 호출로 다음 칸으로 이동

</br>

### 요약
- DFS는 모든 경로를 탐색하고 그 중 최소/최대 값을 구할 때 유용
- 방향 제약이 있는 경우, prevDir처럼 상태를 기억하는 인자를 함께 넘기는 것이 핵심!
- 방문 배열이 꼭 필요한 게 아니라면, 현재 상태만으로 조건 처리 가능


---

알고리즘은 역시 계속 풀어야한다. 안푸니까 까먹어서 이 문제 푸는데 너무 어려웠다..
DFS 문제를 기초부터 여러 개 풀면서 다시 감을 되찾을 예정이다.
알고리즘은 왜 풀어도 풀어도 어려울까!
면접 주간을 맞이하여 소홀했던 연습 패턴을 다시 얼른 되찾아야겠다. 열심히 단련하자..!

