import java.io.*;
import java.util.*;

/**
 * 문제 읽기
 * 
 * - 마인크래프트 : 1 * 1 * 1 크기의 블록들로 이루어진 3차원 세계에서 자유롭게 땅을 파거나 집을 지을 수 있는 게임
 * - N*M 크기의 집터 : 맨 왼쪽의 좌표는 (0, 0) => 집 땅의 높이를 일정하게 바꾸고 싶다.
 * 
 * [가능한 작업 2가지]
 * - 2초 소요 : 좌표 (i, j) 의 가장 위에 있는 블록을 제거하여 인벤토리에 넣는다.
 * - 1초 소요 : 인벤토리에 블록을 하나 꺼내어 좌표 (i, j)의 가장 위에 있는 블록 위에 놓는다.
 * 
 * - 기본으로 인벤토리에 B 개의 블록을 가지고 있으며, 땅의 높이는 256 블록을 초과할 수 없으며, 음수가 될 수 없다.
 * - 땅 고르기 작업에 걸리는 최소 시간과 그 경우 땅의 높이를 출력하여라
 * - 답이 여러개라면 땅의 높이가 가장 높은 것으로 출력한다.
 */

public class Main {
	
	static int N, M, B, bestTime, bestHeight;
	static int[][] grid;

    public static void main(String[] args) throws IOException {
    	
    	// init & input
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	B = Integer.parseInt(st.nextToken());
    	grid = new int[N][M];
    	
    	int minH = 256;
    	int maxH = 0;
    	for(int i=0; i<N; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j=0; j<M; j++) {
    			int h = Integer.parseInt(st.nextToken());
    			grid[i][j] = h;
    			if(h > maxH) maxH = h;
    			if(h < minH) minH = h;
    		}
    	}
    	
    	
    	/**
    	 * Simulation
    	 * - 최적의 땅의 높이와 시간, 정해진 가능한 경우의 수
    	 * - 모든 탐색은 시간 초과. 비효율적
    	 */
    	bestTime = Integer.MAX_VALUE;
    	bestHeight = -1;
    	
    	// 모든 높이 h를 전부 시뮬레이션 (0~256 or minH~maxH)
    	for(int h=minH; h<=maxH; h++) {
    		long time = 0;
    		int inventory = B;
    		
    		// 완전 탐색
    		for(int i=0; i<N; i++) {
    			for(int j=0; j<M; j++) {
    				int cur = grid[i][j];
    				
    				// 현재의 기준치(h) 보다 땅을 파거나 쌓는다.
    				if(cur > h) { 
    					// 땅 파기
    					int diff = cur - h;
    					inventory += diff;
    					time += 2L * diff;
    				}else if(cur < h) {
    					int diff = h - cur;
    					inventory -= diff;
    					time += diff;
    				}
    			}
    		}
    		
    		// 블록이 보자랄 경우 불가능 처리
    		if(inventory < 0) continue;
    		
    		// 정답 갱신 조건 : 이전(bestTime) 보다 더 빠르게 쌓을 수 있거나, 시간은 같은데 높이가 높은 경우!
    		if(time < bestTime || (time == bestTime && h > bestHeight)) {
    			bestTime = (int) time;
    			bestHeight = h;
    		}
    		
    	}
    	
    	
    	
    	// Result
    	System.out.println(bestTime + " " + bestHeight);
    }
    
}