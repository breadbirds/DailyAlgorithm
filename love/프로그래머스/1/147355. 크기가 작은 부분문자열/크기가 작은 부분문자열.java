class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        for(int i=0; i<=t.length() - p.length(); i++){
        	long a = Long.parseLong(t.substring(i, i+p.length()));
        	long b = Long.parseLong(p);
            
            if(a <= b) answer++;
        }
        return answer;
    }
}