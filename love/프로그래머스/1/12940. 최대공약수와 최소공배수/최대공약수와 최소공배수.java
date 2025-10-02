class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        int a = n;
        int b = m;
        
        // 최대 공약수
        int gcd = 0;
        while(m != 0){
            int temp = m;
            m = n % m;
            n = temp;
        }
        gcd = n;
        
        // 최소 공배수
        int lcm = 0;
        lcm = a*b / gcd;
        
        answer[0] = gcd;
        answer[1] = lcm;
        return answer;
    }
}