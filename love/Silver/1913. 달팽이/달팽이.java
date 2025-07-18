import java.util.*;
import java.io.*;


public class Main {

	// 북 동 남 서
	public static final int[] dxs = {-1, 0, 1, 0};
	public static final int[] dys = {0, 1, 0, -1};

	public static int N, K;
	public static int[][] grid;

	private static boolean isRange(int nx, int ny) {
		return nx >= 0 && ny >= 0 && nx < N && ny < N;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		grid = new int[N][N];
		
		// 시작 설정
		int x = N/2;
		int y = N/2;
		int num = 1;
		grid[x][y] = num++;
		
		int len = 1;
		int dir = 0;
		
		
		int answer_x = 0;
		int answer_y = 0;
		if (K == 1) {
		    answer_x = x;
		    answer_y = y;
		}
		
		while(num <= N * N) {
			
			for(int d=0; d<2; d++) {
				for(int l=0; l<len; l++) {
					x += dxs[dir];
					y += dys[dir];
					
					if(!isRange(x, y)) continue;
					if(num == K) {
					    answer_x = x;
					    answer_y = y;
					}
					grid[x][y] = num++;
				}
				// 방향전환
				dir = (dir + 1 + 4) % 4;
			}
			len++;
		}
		
		
		// 출력
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sb.append(grid[i][j]);
				if(j != N-1) sb.append(" ");
			}
			sb.append("\n");
		}
		
		sb.append(answer_x+1).append(" ").append(answer_y+1);
		
		System.out.println(sb);
	}
}
