import java.io.*;
import java.util.*;
/**
 * [문제 읽기] : 공원 산책
 * - 지나다닐 수 있는길(O), 장애물(X), 시작 위치(S) 격자
 * - 명령 : ["방향 거리", "방향 거리", ...]
 *   ex "E 5" : 동쪽으로 5칸 이동
 * 
 * - 명령을 수행하기 전, 다음 두가지 먼저 확인
 *   1-1. 주어진 방향으로 이동할 때 공원을 벗어나는지 확인
 *   1-2. 주어진 방향으로 이동 중 장애물을 만나는지 확인
 *   => 하나라도 해당되면 명령을 무시하고, 다음 명령 수행
 *   
 * - 공원의 가로길이 W, 세로길이 H
 * - 모든 명령을 수행 후 놓인 위치 출력
 */

class Solution {
    static int N, M;

    public int[] solution(String[] park, String[] routes) {
        // M: 세로(행), N: 가로(열)();
        
        M = park.length;
        N = park[0].length();
        
        int x=0;
        int y=0;

        // 장애물 여부만 담는 그리드 (이름은 유지)
        boolean[][] isVisited = new boolean[M][N];

        // 공원 파싱
        for (int i = 0; i < M; i++) {
            
            char[] row = park[i].toCharArray();
            for (int j = 0; j < N; j++) {
                if (row[j] == 'X') {
                    isVisited[i][j] = true; // 장애물
                } else {
                    isVisited[i][j] = false;
                    if (row[j] == 'S') { // 시작 위치
                        x = i;
                        y = j;
                    }
                }
            }
        }

        // 명령 처리
        for (String turn : routes) {
            String[] sp = turn.split(" ");
            String dir = sp[0];
            int step = Integer.parseInt(sp[1]);

            int dx = 0, dy = 0;
            if (dir.equals("E"))      { dx = 0;  dy = 1; }
            else if (dir.equals("S")) { dx = 1;  dy = 0; }
            else if (dir.equals("W")) { dx = 0;  dy = -1; }
            else /* "N" */           { dx = -1; dy = 0; }

            // 전체 경로 사전검증 (가는길에 한번이라도 막히거나 벗어나면 종료되어야 함)
            int nx = x, ny = y;
            boolean ok = true;
            for (int k = 0; k < step; k++) {
                nx += dx;
                ny += dy;
                
                if (!inRange(nx, ny) || isVisited[nx][ny]) {
                    ok = false; // 공원 밖 or 장애물
                    break;
                }
            }

            // 경로가 온전히 가능할 때만 이동 커밋
            if (ok) {
                x = nx;
                y = ny;
            }
        }

        return new int[]{x, y};
    }

    private static boolean inRange(int r, int c) {
        return r >= 0 && c >= 0 && r < M && c < N;
    }
}