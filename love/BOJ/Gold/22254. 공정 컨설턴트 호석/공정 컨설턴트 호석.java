import java.io.*;
import java.util.*;

/**
 * BOJ 22254 공정 컨설턴트 호석
 * - 목표: 모든 작업을 시간 X 이내에 끝내기 위해 필요한 최소 공정 라인 수 K
 * - 방법: K에 대한 "가능 여부"가 단조(true/false) → 이분 탐색
 *         각 K의 검증은 최소 힙으로 작업 분배 시뮬레이션(O(N log K))
 */
public class Main {
    static int N;      // 작업(선물) 개수
    static long X;     // 제한 시간
    static int[] arr;  // 각 작업의 소요 시간

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Long.parseLong(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 이분 탐색: 최소 K (1 ~ N)
        int lo = 1, hi = N, ans = N;
        while (lo <= hi) {
            int mid = (lo + hi) / 2; // 가정한 공정 라인 수 K
            if (able(mid)) {         // mid개로 X 이내 완료 가능?
                ans = mid;           // 가능 → 더 작은 K 탐색
                hi = mid - 1;
            } else {
                lo = mid + 1;        // 불가능 → 더 큰 K 필요
            }
        }

        System.out.println(ans);
    }

    /**
     * able(cnt):
     *  - cnt개의 라인으로 작업을 X 이내에 끝낼 수 있는지 검증
     *  - 최소 힙(pq)에 각 라인의 "현재 누적 작업 완료 시각"을 저장
     *  - 매 작업을 "가장 빨리 끝나는 라인"에 배치(그리디)
     *  - 모든 배치 후 라인들의 완료 시각 중 최대가 X 이하인지 확인
     *  복잡도: O(N log cnt)
     */
    static boolean able(int cnt) {
        PriorityQueue<Long> pq = new PriorityQueue<>(); // 라인별 누적 완료 시각 (최소 힙)
        for (int i = 0; i < cnt; i++) pq.add(0L);       // 초기: 모든 라인 0시각에서 시작

        for (int t : arr) {
            long curr = pq.poll();  // 가장 빨리 끝나는 라인
            curr += t;              // 해당 라인에 작업 배치
            pq.add(curr);           // 갱신 후 다시 힙에 삽입
        }

        // 모든 라인의 최종 완료 시각이 X 이하인지 확인 (진행 중 최대값을 따로 추적해도 되지만, 여기선 단순히 확인)
        while (!pq.isEmpty()) {
            if (pq.poll() > X) return false;
        }
        return true;
    }
}
