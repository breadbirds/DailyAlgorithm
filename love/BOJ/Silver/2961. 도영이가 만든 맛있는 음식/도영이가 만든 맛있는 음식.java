import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long[][] food;     // [i][0] = 신맛(S), [i][1] = 쓴맛(B)
    static long minDiff = Long.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        food = new long[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            food[i][0] = Long.parseLong(st.nextToken()); // S
            food[i][1] = Long.parseLong(st.nextToken()); // B
        }

        dfs(0, 1L, 0L, 0); // idx, 누적 신맛(곱), 누적 쓴맛(합), 선택 개수
        System.out.println(minDiff);
    }

    static void dfs(int idx, long sour, long bitter, int cnt) {
        if (idx == N) {
            if (cnt > 0) { // 공집합 제외
                long diff = Math.abs(sour - bitter);
                if (diff < minDiff) minDiff = diff;
            }
            return;
        }

        // 1) idx 재료 사용
        dfs(idx + 1, sour * food[idx][0], bitter + food[idx][1], cnt + 1);

        // 2) idx 재료 미사용
        dfs(idx + 1, sour, bitter, cnt);
    }
}
