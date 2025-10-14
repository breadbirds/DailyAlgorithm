class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int zero = 0;
        int cnt = 0;
        
        while(!s.equals("1")){
            // 1. 0 제거하기
            String org = s;
            s = s.replace("0", "");
            zero += org.length() - s.length();
            
            // 2. 현재 문자열 길이로 2진수 만들기
            String temp = Integer.toBinaryString(s.length());
            s = String.valueOf(temp);
            
            // 3. 횟수 증가
            cnt++;
        }
        
        answer[0] = cnt;
        answer[1] = zero;
        
        return answer;
    }
}