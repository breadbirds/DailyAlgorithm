class Solution {
    
    static int[] dxs = {-1, 0, 1, 0};
	static int[] dys = {0, 1, 0, -1};
	static int x, y;
	
	static public boolean isRange(int nx, int ny) {
		return nx >= 0 && ny >= 0 && nx < x && ny < y; 
	}

    
    public int solution(String[][] board, int h, int w) {
		x = board.length;
		y = board[0].length;
		
		int answer = 0;
		
		for(int i=0; i<4; i++) {
			int nx = h+dxs[i];
			int ny = w+dys[i];
			
			if(isRange(nx, ny) && board[nx][ny].equals(board[h][w])) answer++;
			
		}
		
		// Result
		return answer;
		// System.out.println(answer);
    }
}