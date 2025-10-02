class Solution {
    public long solution(long num) {
        long answer = -1;
        
        // 종료 조건 1
        if(num == 0) return 0;

        for(long i=0; i<500; i++){
            // 종료 조건 2
            if(num == 1){
                answer = i;
                break;
            }
            
            // 계산 조건
            if(num % 2 == 0)
                num /= 2;
            else
                num = (num * 3) + 1;
        }
        
        
        return answer;
    }
}