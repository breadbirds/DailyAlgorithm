# 백준 1182 부분수열의 합 | 실버 2
[🏁 문제 바로가기](https://www.acmicpc.net/problem/1182)

-  재귀와 백트래킹 개념 및 문제 추천 : [Velog 링크](https://velog.io/@bluemango0312/%EC%9E%AC%EA%B7%80%EC%99%80-%EB%B0%B1%ED%8A%B8%EB%9E%98%ED%82%B9)

### My Code
```java
package source_code;

import java.util.Scanner;

public class B_S2_1182_subSequenceSum {
	static int N;
	static int S;
	static int result;
	static int[] numList;
	static int[] visited;
	static int turnCnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		S = sc.nextInt();
		numList = new int[N];
		visited = new int[N];

		for (int i = 0; i < N; i++) {
			numList[i] = sc.nextInt();
		}

		result = 0;
		turnCnt = 0;

		if (N == 1 && S == numList[0]) {
			result = 1;
		} else {
			findSubSequence(0, -1);
		}

		System.out.println(result);
	}

	private static void findSubSequence(int sum, int prevIndex) {
		if (sum == S && turnCnt != 0) {
			result++;
			turnCnt = 0;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i] == 1 || i <= prevIndex)
				continue;

			visited[i] = 1;
			turnCnt++;

			findSubSequence(sum + numList[i], i);
			visited[i] = 0;
		}
	}

}
```

#### 코드리뷰
`핵심 문제점`
- **전역 turnCnt:**
공집합 배제용으로 썼는데, 분기마다 증감/복원이 없어서 상태가 꼬임. 
한 번 `sum == S`가 되어도 다른 가지에 영향을 주게 됨

- **visited + prevIndex 조합:**
부분수열(부분집합) 문제에 불필요
포함/미포함 두 갈래로만 타면 됨

- **종료 조건 부족**
"끝까지 갔을 때 (picked > 0 && sum == S)"만 세거나, 선택 즉시(next==S) 세면 명확함

#### 개선 코드
`포함/미포함 DFS`
```java
import java.io.*;
import java.util.*;

public class Main {
    static int N, S;
    static int[] a;
    static int ans;

    static void dfs(int idx, int sum, int picked) {
        if (idx == N) {
            if (picked > 0 && sum == S) ans++;
            return;
        }
        // 현재 원소 포함
        dfs(idx + 1, sum + a[idx], picked + 1);
        // 현재 원소 미포함
        dfs(idx + 1, sum, picked);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        a = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) a[i] = Integer.parseInt(st.nextToken());

        dfs(0, 0, 0);
        System.out.println(ans);
    }
}

```

-> 내가 기존에 풀이했던 순서대로 더하는 것 대신 이 원소를 포함하고 안포함하는 각각의 경우를 재귀로 풀어나가며 코드를 간소화한 경우

</br>

`조합 (시작 인덱스만 전진)`
```java
import java.io.*;
import java.util.*;

public class Main {
    static int N, S, ans;
    static int[] a;

    static void comb(int start, int sum) {
        for (int i = start; i < N; i++) {
            int next = sum + a[i];
            if (next == S) ans++;   // 비어있지 않은 경우만 카운트
            comb(i + 1, next);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        a = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) a[i] = Integer.parseInt(st.nextToken());

        comb(0, 0);
        System.out.println(ans);
    }
}
```

-> 전부 for문 돌리되 그 안에서 인덱스로 걸러내지 말고 start 포인트 자체를 옮겨서 코드를 간소화 한 케이스

---

나의 코드에서는 turnCnt나 visited 같이 불필요한 상태를 추가하다 보니 흐름이 복잡해지고 버그가 생기거나 예외가 생길 가능성이 생기는 것 같다.
아직 정석 패턴이 익숙한 틀로 자리잡지 않아서 그런 것 같으니 더 많이 풀어봐야지!
