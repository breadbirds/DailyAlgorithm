class Solution {
    public int solution(int[][] sizes) {

        // for 문을 돌면서, 해당 명함의 최소/최대 길이를 기준으로 방향 변경
        int maxWidth = 0;
        int maxHeight = 0;
        for(int[] card: sizes){
            
            // 1. 가장 짧은 쪽과 긴 쪽을 찾는다.
            int w = Math.min(card[0], card[1]);
            int h = Math.max(card[0], card[1]);
            
            // 2. 명함지갑의 최소 사이즈를 구하기 위해 가장 큰값을 계산
            maxWidth = Math.max(maxWidth, w);
            maxHeight = Math.max(maxHeight, h);
        }
        
        return maxWidth * maxHeight;
    }
}