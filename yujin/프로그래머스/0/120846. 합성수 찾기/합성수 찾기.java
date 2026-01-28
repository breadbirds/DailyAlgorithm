class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i = 4; i <= n; i++){
            if(countDivisors(i)>=3){
                answer++;
            }
        }
        return answer;
    }
    
    private int countDivisors(int x) {
        int count = 0;
        for (int d = 1; d <= x; d++) {
            if (x % d == 0) count++;
        }
        return count;
    }
}