## 골드4 - 거짓말

- https://www.acmicpc.net/problem/1043


## 제출 코드

- Union-Find 비슷하게 더러울지도~~ ㅋㅋ
처음에 그냥 `visited`로 dfs 풀이랑 똑같이 했었는데, 그러니까 union-find 때문에 무조건 더 작은 노드를 부모로 가지게 되서 아래 코드처럼 변경했다.

- 진실은 아는 사람이 3번인데, `parent[3] = 1`인 경우가 발생해서 그 부모와 같을 때 `ans`를 감소시켰다.

```java
int ans = M;
for (int[] party : parties) {
	boolean check = false;
	for (int person : party) {
		for (int t : truth) {
			if (find(person) == find(t)) {
				ans--;
				check = true;
				break;
			}
		}

		if (check) {
			break;
		}
	}
}
```

</br>

```java
public class 거짓말_union_1043 {

	private static int N, M;
	private static int[] parent, truth;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		N = Integer.parseInt(split[0]); // 사람수
		M = Integer.parseInt(split[1]); // 파티수

		// 진실 아는 사람
		split = br.readLine().split(" ");
		int truthN = Integer.parseInt(split[0]);
		if (truthN == 0) { // 아무도 없을 경우, 모든 파티에 참석
			System.out.println(M);
			return;
		}

		truth = new int[N + 1];
		for (int i = 1; i <= truthN; i++) {
			truth[i - 1] = Integer.parseInt(split[i]);
		}

		// 부모 초기화
		parent = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			parent[i] = i;
		}

		// 파티 참가자 저장
		List<int[]> parties = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			split = br.readLine().split(" ");
			int[] party = new int[Integer.parseInt(split[0])];
			for (int j = 0; j < party.length; j++) {
				party[j] = Integer.parseInt(split[j + 1]);
			}

			// union: 파티 내 사람 연결
			for (int j = 0; j < party.length - 1; j++) {
				union(party[j], party[j + 1]);
			}

			parties.add(party);
		}


		int ans = M;
		for (int[] party : parties) {
			boolean check = false;
			for (int person : party) {
				for (int t : truth) {
					if (find(person) == find(t)) {
						ans--;
						check = true;
						break;
					}
				}

				if (check) {
					break;
				}
			}
		}
		System.out.println(ans);
	}

	static void union(int u1, int u2) {

		int a = find(u1);
		int b = find(u2);

		if (a > b) {
			parent[a] = b;
		} else {
			parent[b] = a;
		}
	}

	static int find(int u) {

		if (parent[u] != u) {
			parent[u] = find(parent[u]);
		}
		return parent[u];
	}
}

```
