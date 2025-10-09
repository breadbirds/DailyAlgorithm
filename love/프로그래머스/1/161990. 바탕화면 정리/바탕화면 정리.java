class Solution {
    public int[] solution(String[] wallpaper) {
    	int[] answer = new int[4];
    	answer[0] = Integer.MAX_VALUE;
    	answer[1] = Integer.MAX_VALUE;
    
    	for(int i=0; i<wallpaper.length; i++) {
    		
    		char[] row = wallpaper[i].toCharArray();
    		
    		for(int j=0; j<row.length; j++) {
    			if(row[j] == '#') {
    				// 점S 의 x 좌표 갱신
    				answer[0] = Math.min(answer[0], i);
    				
    				// 점S 의 y 좌표 갱신
    				answer[1] = Math.min(answer[1], j);
    				
    				// 점E 의 x 좌표 갱신
    				answer[2] = Math.max(answer[2], i+1);
    				
    				// 점E 의 y 좌표 갱신
    				answer[3] = Math.max(answer[3], j+1);
    			}
    		}
    	}


		// Result
		return answer;
		//System.out.println(answer[0] + ", " + answer[1] + ", " + answer[2] + ", " + answer[3]);
    }
}