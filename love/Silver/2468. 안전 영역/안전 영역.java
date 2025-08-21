import java.io.*;
import java.util.*;


/**
 * 문제 읽기
 * 
 * - 지역의 높이 정보가 주어지고, 비가 내렸을 때 '물에 잠기지 않는' 안전한 영역이 '최대로 몇 개'가 만들어지는지 조사 (이하도 포함 한다.)
 * - 안전 영역의 범위 : 상하좌우 인접(대각선은 x)
 * - 아무 지역도 물에 잠기지 않을 수 있다!
 * 
 */
public class Main {
	
	static class Node{
		int x, y;
		
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

	static int N, answer, max;
	static int[][] grid;
	static boolean[][] visited;

	static int[] dxs = {-1, 0, 1, 0};
	static int[] dys = {0, 1, 0, -1};
	
    public static void main(String[] args) throws Exception {
    	
    	// init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];
        visited = new boolean[N][N];
        answer = 0;
        max = 0;
        
        
        // input
        for(int i=0; i<N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int j=0; j<N; j++) {
        		grid[i][j] = Integer.parseInt(st.nextToken());
        		max = Math.max(max, grid[i][j]);
        	}
        }
        
        /**
         * Simulation
         * 
         * i = 물의 높이 1~max 까지
         * 매번 모든 visited 초기화 + i 이하인 것들을 하나의 묶음 으로 처리
         */
        for(int high=0; high<=max; high++) {
        	// 방문 변수 초기화
        	visited = new boolean[N][N];
        	int safe = 0;
        	
        	// 물높이가 high 일 때, 물에 잠기지 않는 안전 영역이 몇개인지 탐색
        	for(int i=0; i<N; i++) {
        		for(int j=0; j<N; j++) {
        			
        			if(grid[i][j] > high && !visited[i][j]) {
        				bfs(i, j, high);
        				safe++;
        			}
        		}
        	}
        	
        	answer = Math.max(answer, safe);
        }
        
        
        // Result
        System.out.println(answer);


    }// ...main


	private static boolean inRange(int x, int y) {
		return x>=0 && y>=0 && x<N && y<N;
	}

	private static int bfs(int x, int y, int high) {
		Queue<Node> queue = new LinkedList<>();
		visited[x][y] = true;
		queue.add(new Node(x, y));
		
		while(!queue.isEmpty()) {
			
			Node cur = queue.poll();
			
			for(int i=0; i<4; i++) {
				int nx = cur.x + dxs[i];
				int ny = cur.y + dys[i];
				
				// 탐색 불가조건 : 범위 벗어남 or 해당영역이 기준치 미만 or 이미 탐색을 완료한 지역
				if(!inRange(nx, ny) || grid[nx][ny] <= high || visited[nx][ny]) continue;
				
				visited[nx][ny] = true;
				queue.add(new Node(nx, ny));
			}
		}
		
		
		return 0;
	}





}
