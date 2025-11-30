import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int SIZE = 8;
	static int answer = Integer.MAX_VALUE;
	static boolean[][] board;

	public static void main(String[] args) throws IOException  {
		
		// M*N 보드를 잘라서 8*8 체스판을만들자고 한다.
		// 보드가 체스판 처럼 검-흰-검 칠해져있다는 보장이 없다.
		// 8*8 사이즈를 잘라 일부를 다시 칠해서 만드려고 함. 단 다시 칠하는건 최소가 되었으면 함
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력 & 초기화
		String[] nm = br.readLine().split(" ");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);
		board = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			String[] row = br.readLine().split("");
			for(int j=0; j<m; j++) {
				if(row[j].equals("W")) {
					board[i][j] = true;
				}else {
					board[i][j] = false;
				}
			}
		}
		
		
		// 계산
		answer = Integer.MAX_VALUE;
		
		/**
		 * 풀이 방법 생각하기
		 * 
		 * - 체스 판은 8*8 사이즈로 정해져 있으므로, 전체 배열에서 우선 0번지를 기준으로 판을 만든다.
		 * - 이후 가로로, 세로로 한칸씩 옮겨가며 최대 체스판을 생성해 본다.
		 * - 색칠을 최소로 하기 위해 칸을 만들 때 마다 검사를 한다. (첫칸이 흰/검 두가지 경우 있음)
		 */
		
		// 시작점의 위치를 기준으로 탐색하는 변수를 생성한다.
		for(int i=0; i<n-7; i++) { 		// 가로로 갈 수 있는 최대 값
			for(int j=0; j<m-7; j++) { 	// 세로로 갈 수 있는 최대 값
				findValue(i,j);
			}
		}
		
		// 출력
		System.out.println(answer);
	}

	private static void findValue(int x, int y) {
		int end_x = x+8;
		int end_y = y+8;
		int count = 0;
		
		// 첫번째 칸의 색을 기준의로 체크 무늬 판단하기
		boolean TF = board[x][y];
		
		for(int i=x; i<end_x; i++) {
			for(int j=y; j<end_y; j++) {
				
				// 올바른 색이 아닐경우, 다시 칠해야 함 count 증가
				if(board[i][j] != TF) count++;
				
				// 다음 색은 반대 되어야 하므로 boolean 값 변경
				TF = !TF;
			}
			
			// 가로로 한 줄이 끝나면 그 다음줄의 시작 값은 반대가 되어야 한다 (규칙)
			TF = !TF;
		}
		
		//count = Math.min(count,  64-count);
		
		/**
		 * 첫 번째 칸을 기준으로 할 때 색칠해야 하는 수(count)와
		 * 첫 번째 칸의 색의 반대되는 색을 기준으로 할 때, 색칠 할 개수 (== 즉 첫번째 칸의 값을 바꿔버림)
		 * 중 최솟값을 count 에 저장.
		 * => 특정상황에선 처번째값을 바꿔 계산하는 경우가 최소값이 되는 상황이 생긴다.
		 */
		answer = Math.min(answer, Math.min(count, 64-count));
		
	}
}