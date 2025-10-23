import java.io.*;
import java.util.*;

/**
 * [문제 읽기]
 * - 지도 크기 N * M
 * - 지도의 좌표는 (r, c) : r 북쪽으로부터 떨어진 칸의 개수, c 서쪽으로부터 떨어진 칸의 개수
 * 
 * - 처음 주사위의 모든 면에는 0으로 표시
 * - 주사위를 굴렸을 때 이동한 칸에 쓰인 수가 0이면, 주사위 바닥면에 쓰여 있는 수가 칸에 복사
 *                 				     0이 아니면, 칸에 쓰여있는 수가 주사위의 바닥면에 복사 (칸에 쓰여 있는 수는 0이 됨)
 * - K개의 명령: 동(1), 서(2), 북(3), 남(4)
 */
public class Main {
	
	static int N, M, x, y, K;
	static int[][] map;
	static int[][] dice = new int[4][3];
	
	// 방향 (1동, 2서, 3북, 4남)
    static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, 1, -1, 0, 0};


    public static void main(String[] args) throws Exception {
    	// Simulation
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	x = Integer.parseInt(st.nextToken());
    	y = Integer.parseInt(st.nextToken());
    	K = Integer.parseInt(st.nextToken());

  	   // 지도 입력
    	map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    	
        // 명령 입력
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < K; i++) {
            int dir = Integer.parseInt(st.nextToken());
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            // 범위 밖이면 명령 무시
            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

            // 주사위 굴리기
            roll(dir);

            // 지도 ↔ 주사위 값 복사
            if (map[nx][ny] == 0) {
                map[nx][ny] = dice[3][1]; // 주사위 바닥 → 칸
            } else {
                dice[3][1] = map[nx][ny]; // 칸 → 주사위 바닥
                map[nx][ny] = 0;
            }

            // 위치 갱신
            x = nx;
            y = ny;

            // 윗면 출력
            sb.append(dice[1][1]).append('\n');
        }

        System.out.print(sb);
    }
    
    
    // 주사위 회전 함수
    static void roll(int dir) {
        int temp;
        switch (dir) {
            case 1: // 동쪽
                temp = dice[1][2];
                dice[1][2] = dice[1][1];
                dice[1][1] = dice[1][0];
                dice[1][0] = dice[3][1];
                dice[3][1] = temp;
                break;
            case 2: // 서쪽
                temp = dice[1][0];
                dice[1][0] = dice[1][1];
                dice[1][1] = dice[1][2];
                dice[1][2] = dice[3][1];
                dice[3][1] = temp;
                break;
            case 3: // 북쪽
                temp = dice[0][1];
                dice[0][1] = dice[1][1];
                dice[1][1] = dice[2][1];
                dice[2][1] = dice[3][1];
                dice[3][1] = temp;
                break;
            case 4: // 남쪽
                temp = dice[3][1];
                dice[3][1] = dice[2][1];
                dice[2][1] = dice[1][1];
                dice[1][1] = dice[0][1];
                dice[0][1] = temp;
                break;
        }
    }
}
