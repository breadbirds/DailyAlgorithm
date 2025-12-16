import java.io.*;
import java.util.*;


/**
 * [문제 읽기]
 * - 전체 종이의 크기 N*N
 * - 종이는 흰색(0) or 파란색(1)
 * - 전체영역 or N/2 를 통해 나눠진 정사각형 영역들에 같은색의 종이만 남을 때 까지 나눈다.
 *   모두 하양 또는 파란색으로 칠해져 있거나, 하나의 정사각형 칸이 되어 더 이상 자를 수 없을 때 까지 반복 (최소 정사각형 크기는 2*2)
 * 
 * 
 * - 전체종이가 모두 같은 색으로 칠해져 있는 경우가 있을 수도 있다.
 */
public class Main {
	
	static int N;
	static int[][] grid;
	
	static int white, blue, curColor;
	
	
	public static void main(String[] args) throws Exception {
		
		// init & input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		grid = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		

		// Simulation
		solve(0, 0, N);
	
		// Result
		System.out.println(white);
		System.out.println(blue);
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
					
					solve(x, y, half);
					solve(x, y + half, half);
					solve(x+half, y, half);
					solve(x + half, y+half, half);
					return;
				}
			}
		}
		
		
		// 3. 위 for 문을 통과했다면 모든 칸이 동일한 색으로 이루어져 있는 경우를 의미함.
		if(curColor == 0) white++;
		else blue++;
	}
}
