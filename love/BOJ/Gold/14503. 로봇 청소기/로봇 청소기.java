import java.io.*;
import java.util.*;


/**
 * 문제 읽기
 * 
 * - 로봇 청소기가 작동을 시작한 후 작동을 멈출 때까지 청소하는 칸의 개수
 * 
 * - N*M 사이즈 방, 각각의 칸은 빈 칸 or 벽, 동서남북 이동가능
 * - 각 칸은 좌표(r, c) 로 표현, 왼쪽 상단(0, 0), 우측 하단(N-1, M-1)
 * - 처음에 주어지는 빈 칸은 전부 청소되지 않은 상태
 * 
 */

public class Main {
	
	static int N, M;
	static int r, c, dir, answer;
	static int[][] grid;
	static boolean[][] visited;
	
	// 북 동 남 서
	static int[] dxs = {-1, 0, 1, 0};
	static int[] dys = {0, 1, 0, -1};
	
	// 위치정보를 담은 Node 객체
    static class Node{
    	int x;
    	int y;
    	
    	Node(int x, int y){
    		this.x = x;
    		this.y = y;
    	}
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
    	
    	// 청소기 위치 및 방향 정보
    	st = new StringTokenizer(br.readLine());
    	r = Integer.parseInt(st.nextToken());
    	c = Integer.parseInt(st.nextToken());
    	dir = Integer.parseInt(st.nextToken());
    	
    	// 방 정보
    	for(int i=0; i<N; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j=0; j<M; j++) {
    			grid[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	
    	// Simulation
    	simulation(r, c, dir);
    	
    	
    	// Result
    	System.out.println(answer);
    }




    /**
     * r, c 위치에서 dir 방향을 보며 동작 한다.
     * 
     * 0 북, 1 동, 2 남, 3서
     * 
	 * [로봇 청소기 동작 방식]
	 * 1. 현재 칸이 청소되지 않은 경우, 청소
	 * 2. 현재 칸의 주변 4칸 중 청소되지 않은 빈칸이 없는 경우
	 *    2-1. 바라보는 방향을 유지한 채 한칸 후진할 수 있다면 후진 후 1번 복귀
	 *    2-2. 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없으면 작동 멈춤
	 * 3. 현재 칸의 주변 4칸 중 청소되지 않은 빈칸이 있는 경우
	 *    3-1. 반시계 방향으로 90도 회전
	 *    3-2. 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸의 경우 한 칸 전진
	 *    3-3. 1번 되돌아가기
     */
	private static void simulation(int r, int c, int dir) {
		Queue<Node> queue = new LinkedList<>();
		//visited[r][c] = true;
		queue.add(new Node(r, c));
		
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			
			// 1. 청소 여부 결정하기
			if(grid[cur.x][cur.y] == 0 && !visited[cur.x][cur.y]) {
				visited[cur.x][cur.y] = true;
				answer++;
			}
			
			// 청소 가능한 칸이 있는지 없는지 확인
			if(!isCleanRoom(cur)) {
				// 2. 청소되지 않은 빈 칸이 없는 경우
				// 후진이 되는 경우 찾기
				// 반대방향 : (n + 2) % 4
				int nx = cur.x + dxs[(dir+2) % 4];
				int ny = cur.y + dys[(dir+2) % 4];
				
				// 후진되는 경우 방향은 유지하고 뒤로 간다. (청소가 되어있는 여부는 상관 없음)
				if(inRange(nx, ny) && grid[nx][ny] == 0) {
					queue.add(new Node(nx, ny));
					continue;
				}else {
					// queue 에 더이상 이동할 위치를 넣지 않음 => 탐색 종료
					continue;
				}
			}else {
				// 3. 청소되지 않은 빈 칸을 찾은 경우
				// 반시계방향 회전 : dir 변경
				dir = (dir - 1 + 4) % 4;
				
				// 앞쪽 칸이 청소되지 않은 빈 칸일 경우 전진(그 외에 경우는 그대로)
				int nx = cur.x + dxs[dir];
				int ny = cur.y + dys[dir];
				if(inRange(nx ,ny) && grid[nx][ny] == 0 && !visited[nx][ny]) {
					queue.add(new Node(nx, ny));
				}else {
					queue.add(new Node(cur.x, cur.y));
				}
				
				// 이후 1번 복귀 (while 초기로 돌아감)
			}
			

		}
		
	}

	// 2. 청소되지 않은 칸이 없는 경우 찾기
	private static boolean isCleanRoom(Node cur) {
		
		for(int i=0; i<4; i++) {
			int nx = cur.x + dxs[i];
			int ny = cur.y + dys[i];
			
			// 청소되지 않은 빈칸이 하나라도 있는 경우 : 격자 범위 이내 & 아직 방문하지 않은 곳 & 청소 되지 않은 곳(0)
			if(inRange(nx, ny) && !visited[nx][ny] && grid[nx][ny] == 0) return true;
		}
		
		// 청소되지 않은 빈칸이 하나도 없는 경우
		return false;
	}

	private static boolean inRange(int x, int y) {
		return x>=0 && y>=0 && x<N && y<M;
	}
    
}