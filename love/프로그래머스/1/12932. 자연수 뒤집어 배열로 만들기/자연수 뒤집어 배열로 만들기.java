class Solution {
    public int[] solution(long n) {
        String temp = String.valueOf(n);
        int[] answer = new int[temp.length()];
        
        for(int i=0; i<temp.length(); i++){
            answer[temp.length()-i - 1] = temp.charAt(i) - '0';
        }
        
        return answer;
    }
}