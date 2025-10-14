class Solution {
    public long solution(long n) {
        long answer = 0;
        
        // 제곱근 구하기 : 만약 제곱근이 구해지지 않을 경우, %1 연산 했을 때 소수점이 나오게 된다.
        double sqrt = Math.sqrt(n);
        
        if(sqrt % 1 == 0)
            answer = (long) Math.pow(sqrt + 1, 2);
        else
            answer = -1;
        
        return answer;
    }
}