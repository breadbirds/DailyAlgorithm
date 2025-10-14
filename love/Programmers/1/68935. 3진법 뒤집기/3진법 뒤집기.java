class Solution {
    public int solution(int n) {
        
        // 3진법
        String number = Integer.toString(n, 3);
        
        // 앞뒤 반전
        String reversed = new StringBuilder(number).reverse().toString();
        
        // 10진법
        int answer = Integer.parseInt(reversed, 3);
        
        
        return answer;
    }
}