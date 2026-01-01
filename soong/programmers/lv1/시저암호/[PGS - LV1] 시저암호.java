class Solution {
    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();

        for(char ch: s.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                answer.append((char) ('a' + (ch - 'a' + n) % 26));
            } 
            else if (ch >= 'A' && ch <= 'Z') {
                answer.append((char) ('A' + (ch - 'A' + n) % 26));
            } else {
                answer.append(" ");
            }
        }
        
        return answer.toString();
    }
}
