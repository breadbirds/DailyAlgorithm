import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[][] grid;
	
	static int white, blue, curColor;
	
	static StringBuilder sb = new StringBuilder();
	
	
	public static void main(String[] args) throws Exception {
		
		// init & input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		grid = new int[N][N];
		
		for(int i=0; i<N; i++) {
			String[] st = br.readLine().split("");
			for(int j=0; j<N; j++) {
				grid[i][j] = Integer.parseInt(st[j]);
			}
		}
		

		// Simulation
		solve(0, 0, N);
	
		// Result
		System.out.println(sb.toString());
	}


	private static void solve(int x, int y, int size) {
		
		// 1. 현재 정사격형의 기준색(왼쪽 상단 고정)
		curColor = grid[x][y];
		
		// 2. 주어진 size 만큼 모두 동일한 색상인지 확인하가ㅣ
		for(int i=x; i<x+size; i++) {
			for(int j=y; j<y+size; j++) {
				
				// 색이 다른 경우, 현재 사각형에서 절반 !
				if(grid[i][j] != curColor) {
					int half = size/2;

					sb.append("(");
					solve(x, y, half);
					solve(x, y + half, half);
					solve(x+half, y, half);
					solve(x + half, y+half, half);
					sb.append(")");
					return;
				}
			}
		}
		
		// 3. 위 for 문을 통과했다면 모든 칸이 동일한 색으로 이루어져 있는 경우를 의미함.
		sb.append(curColor);
	}
}
