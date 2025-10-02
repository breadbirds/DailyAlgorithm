class Solution {
    /*
    * diffs[] = 퍼즐의 난이도
    * times[] = 퍼즐 소요 시간
    * limit = 전체 제한 시간
    
    * ** 제한 시간 내에 퍼즐을 모두 해결하기 위한 숙련도의 '최솟값'
    */
    
    public static long getTime(int now_level, int[] diffs, int[] times){
        // 처음 퍼즐은 무조건 통과
        long total = 0;
        total += times[0];
        
        for(int i=1; i<diffs.length; i++){
            if(diffs[i] <= now_level){
                total += times[i];
            }else{
                int fail = diffs[i] - now_level;
                total += (long)(times[i] + times[i-1]) * fail + times[i];
            }
        }
        return total;
    }
    
    public int solution(int[] diffs, int[] times, long limit) {
        
        int left = 1;
        int right = 100_000;
        int answer = right;
        
        while(left <= right){
            int mid = (left + right) / 2;
            if(getTime(mid, diffs, times) <= limit){
                answer = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        
        
        return answer;
    }
}