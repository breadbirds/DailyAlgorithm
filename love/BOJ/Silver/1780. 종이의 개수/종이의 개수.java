import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[][] grid;
	
	static int curColor;
	static int a, b, c;
	static int[] answer = new int[3];
	
	public static void main(String[] args) throws Exception {
		
		// init & input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		grid = new int[N][N];
		
		a = -1;
		b = 0;
		c = 1;
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// Simulation
		solve(0, 0, N);
	
		// Result
		System.out.println(answer[0]);
		System.out.println(answer[1]);
		System.out.println(answer[2]);
	}


	private static void solve(int x, int y, int size) {
		
		// 1. 현재 정사격형의 기준색(왼쪽 상단 고정)
		curColor = grid[x][y];
		
		// 2. 주어진 size 만큼 모두 동일한 색상인지 확인하가ㅣ
		for(int i=x; i<x+size; i++) {
			for(int j=y; j<y+size; j++) {
				
				// 색이 다른 경우, 현재 사각형에서 절반 !
				if(grid[i][j] != curColor) {
					int third = size/3;
					
					solve(x, y, third);
					solve(x, y+third, third);
					solve(x, y+third*2, third);
					
					solve(x+third, y, third);
					solve(x+third, y+third, third);
					solve(x+third, y+third*2, third);
					
					solve(x+third*2, y, third);
					solve(x+third*2, y+third, third);
					solve(x+third*2, y+third*2, third);
					return;
				}
			}
		}
		
		// 3. 위 for 문을 통과했다면 모든 칸이 동일한 색으로 이루어져 있는 경우를 의미함.
		if(curColor == a) answer[0]++;
		else if(curColor == b) answer[1]++;
		else answer[2]++;
	}
}
