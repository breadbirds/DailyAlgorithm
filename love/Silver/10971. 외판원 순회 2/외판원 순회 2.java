import java.io.*;
import java.util.*;

/**
 * 문제 읽기
 * 
 * - 1~N 번호가 매겨진 도시
 * - 각 도시들 사이에는 길이 있을수도 있고, 없을 수도 있다.
 * - 어느 한 도시에서 출발해 N개의 도시를 모두 거쳐 다시 원래의 도시로 돌아오는 순회 여행 경로 세우기
 *   단, 한번 갔떤 도시로는 다시 갈 수 없다. (맨 마지막에 여행을 출발했던 도시로 돌아오는 것은 예외)
 *   가장 적은 비용을 들이는 여행 계획을 세울 예정
 * - W[i][j] 는 도시 i에서 도시 j로 가기 위한 비용 (비용은 대칭이 아님 W[i][j] != W[j][i]
 * - W[i][i] 는  항상 0 이다. 이동할 수 없는 경우도 W[i][j] 다.
 * 
 */

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] W;
    static boolean[] visited;
    static int minAnswer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {

        // init & input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        W = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // Simulation
        for (int start = 0; start < N; start++) {
            visited = new boolean[N];
            visited[start] = true;
            dfs(start, start, 1, 0);
        }

        // Result
        System.out.println(minAnswer);
    }

    /**
     * @param start 시작 도시(마지막에 되돌아와야 함)
     * @param cur   현재 도시
     * @param cnt   지금까지 방문한 도시 수
     * @param cost  지금까지 누적 비용
     */
    static void dfs(int start, int cur, int cnt, int cost) {
        // 가지치기: 이미 최소답 이상이면 중단
        if (cost >= minAnswer) return;

        // 모든 도시 방문 완료 → 시작점으로 복귀 가능한지 확인 (원래 도시로 돌아오는 것이 조건)
        if (cnt == N) {
            if (W[cur][start] != 0) {
                minAnswer = Math.min(minAnswer, cost + W[cur][start]);
            }
            return;
        }

        // 다음 도시 고르기
        for (int next = 0; next < N; next++) {
            if (!visited[next] && W[cur][next] != 0) { // 길이 있어야 함
                visited[next] = true;
                dfs(start, next, cnt + 1, cost + W[cur][next]);
                visited[next] = false;
            }
        }
    }
}
