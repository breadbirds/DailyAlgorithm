class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int maxX = -1, maxY = -1;
        
        for(int[] pos: sizes) {
            int w = Math.max(pos[1], pos[0]);
            int h = Math.min(pos[0], pos[1]);
            
            maxX = Math.max(maxX, w);
            maxY = Math.max(maxY, h);
        }
        
        answer = maxX * maxY;
        return answer;
    }
}
