import java.io.*;
import java.util.*;

/**
 * 문제 읽기
 * 
 * 폴리오미노란?
 * - 크기가 1*1 인 정사각형을 열 ㅓ개 이어 붙인 도형
 *   서로 겹치지 않을 것 & 도형은 모두 연결(상하좌우 인접) 되어 있을 것
 *   정사각형의 변끼리 연결되어 있을 것(꼭짓점만 맞닿은 경우 불인정)
 *   정사각형 4개를 이어 붙인 폴리오미노 => 테트로미노
 *   
 *   
 * N*M 종이 위, '테트로미노' 하나를 놓으려고 한다.
 * 각 칸에는 정수가 쓰여 잇음.
 * 테트로미노 하나를 적절히 놓아서 테트로미노가 놓인 칸에 쓰여 있는 수들의 합을 최대로 하는 프로그램을 작성하시오
 * 회전이나 대칭도 허용!
 */

public class Main {
	
	static int N, M, answer, maxCell;
	static int[][] grid;
    static boolean[][] visited;
	
    static final int[] dxs = {1, -1, 0, 0};
    static final int[] dys = {0, 0, 1, -1};
	
	static boolean inRange(int x, int y) {
		return x>=0 && y>=0 && x<N && y<M;
	}

	
    public static void main(String[] args) throws IOException {
    	// init & input
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	
    	grid = new int[N][M];
        visited = new boolean[N][M];
        answer = 0;
        maxCell = 0;
    	
    	for(int i=0; i<N; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j=0; j<M; j++) {
    			grid[i][j] = Integer.parseInt(st.nextToken());
    			if (grid[i][j] > maxCell) maxCell = grid[i][j]; // 가지치기용
    		}
    	}
    	
    	
    	/**
    	 * Simulation
    	 * - 문제에서 주어진 테트로미노 5가지 도형을 종이 판에 대입 해본다.
    	 * - 테트로미노 하나를 놓았을 때, 얻을 수 있는 최대 점수를 구하여야 한다.
    	 * - 모든 도형은 회전 및 대칭이 가능 하다. => 이 경우의 수를 어떻게 구할 것인가가 관건으로 보여짐.
    	 * 
    	 * => 격자안에서 서로 인접한 4개의 직사각형을 적절히 고르면 테트로미노 모양이 나온다. 'ㅗ' 모양 제외
    	 * => 초기엔 문제에 주어진 그림에 집착해서 모양을 정의하고 구해야 하나 했는데 결국 각 모양은 인접한 4개 도형끼리 뭉친것과 동일! ㅗ만 빼고!
    	 */
    	for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, grid[i][j]); // DFS로 대부분 모양 커버
                visited[i][j] = false;

                checkT(i, j);             // ‘ㅗ’ 계열 예외 처리
            }
        }
    	
    	
    	
    	// Result
    	System.out.println(answer);
    }
    
    
    // 깊이 4까지 경로를 확장하는 DFS
    static void dfs(int x, int y, int depth, int sum) {
        // 가지치기: 남은 칸(4 - depth) 모두가 maxCell이어도 answer를 못 넘으면 중단
        if (sum + maxCell * (4 - depth) <= answer) return;

        if (depth == 4) {
            if (sum > answer) answer = sum;
            return;
        }

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dxs[dir];
            int ny = y + dys[dir];
            
            // 탐색 불가 조건
            if (!inRange(nx, ny) || visited[nx][ny]) continue;

            // 탐색 가능
            visited[nx][ny] = true;
            dfs(nx, ny, depth + 1, sum + grid[nx][ny]);
            visited[nx][ny] = false; // 백트래킹
        }
    }
    
    
    // 'ㅗ' (및 회전/대칭: ㅜ, ㅏ, ㅓ) 전용 처리
    static void checkT(int x, int y) {
        int wings = 0;                   // 존재하는 이웃 수
        int sum = grid[x][y];            // 중심 값 포함 합
        int minWing = Integer.MAX_VALUE; // 가장 작은 날개 값 (4방 모두 있을 때 뺄 용도)

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dxs[dir];
            int ny = y + dys[dir];
            if (!inRange(nx, ny)) continue;

            wings++;
            int v = grid[nx][ny];
            sum += v;
            if (v < minWing) minWing = v;
        }

        if (wings >= 3) {
            // 이웃 3개: 그대로 'ㅗ' 완성
            // 이웃 4개: 가장 작은 날개를 하나 빼서 3개 형태를 만들기
            int candidate = (wings == 3) ? sum : (sum - minWing);
            if (candidate > answer) answer = candidate;
        }
        // wings <= 2면 'ㅗ' 불가 -> 아무 것도 안 함
    }
    

}