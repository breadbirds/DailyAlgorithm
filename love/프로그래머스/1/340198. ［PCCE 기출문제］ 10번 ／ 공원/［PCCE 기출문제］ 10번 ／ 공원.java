class Solution {
    public int solution(int[] mats, String[][] park) {
        int N = park.length;
    	int M = park[0].length;
    	
    	boolean[][] map = new boolean[N][M];
    	for(int i=0; i<N; i++) {
    		for(int j=0; j<M; j++) {
    			map[i][j] = "-1".equals(park[i][j]);
    		}
    	}
    	
    	// 1. 전체 탐색을 통해 가능한 가장 넓은 ture 영역을 찾아야 한다.
    	
    	// Maximal Square DP
    	int[][] dp = new int[N][M];
    	int maxSquare = 0;
    	
    	for(int i=0; i<N; i++) {
    		for(int j=0; j<M; j++) {
    			
    			// 예외처리 : False 방문불가일 경우 건너뛰기
    			if(!map[i][j]) {
    				dp[i][j] = 0;
    				continue;
    			}
    			
    			// 그 외
    			if(i==0 || j==0) {
    				dp[i][j] = 1;
    			}else {
    				// 1 + 최소값(위, 왼쪽, 좌상단)
    				dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]) );
    			}
    			
    			// 기타
    			if(dp[i][j] > maxSquare) maxSquare = dp[i][j];
    		}
    	}
    	
    	// 가장 크게 펼칠 수 있는 돗자리 찾기
    	int answer = -1;
    	for(int size: mats) {
    		if(size <= maxSquare && size > answer) answer = size;
    	}


		// Result
    	return answer;
    	//System.out.println();
    }
}