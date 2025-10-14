import java.util.*;

class Solution {

    public static int N, M;

    public static int bfs(int row, int col, int[][] land, int[][] group, int groupId) {
        int count = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row, col});
        group[row][col] = groupId;

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        while (!q.isEmpty()) {
            int[] now = q.poll();
            count++;

            for (int d = 0; d < 4; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (land[nx][ny] == 1 && group[nx][ny] == 0) {
                        group[nx][ny] = groupId;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }

        return count;
    }

    public int solution(int[][] land) {
        N = land.length;        // 행 (row)
        M = land[0].length;     // 열 (col)

        int[][] group = new int[N][M]; // group[row][col] → 석유 덩어리 ID
        Map<Integer, Integer> groupSize = new HashMap<>();

        int groupId = 1;

        // Step 1: 모든 석유 덩어리에 ID 부여 + 크기 기록
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                if (land[row][col] == 1 && group[row][col] == 0) {
                    int size = bfs(row, col, land, group, groupId);
                    groupSize.put(groupId, size);
                    groupId++;
                }
            }
        }

        // Step 2: 각 열을 기준으로 시추관을 뚫을 경우 얻을 수 있는 석유량 계산
        int answer = 0;

        for (int col = 0; col < M; col++) {
            Set<Integer> seenGroups = new HashSet<>();
            for (int row = 0; row < N; row++) {
                int id = group[row][col];
                if (id != 0) {
                    seenGroups.add(id);
                }
            }

            int total = 0;
            for (int id : seenGroups) {
                total += groupSize.get(id);
            }

            answer = Math.max(answer, total);
        }

        return answer;
    }
}
