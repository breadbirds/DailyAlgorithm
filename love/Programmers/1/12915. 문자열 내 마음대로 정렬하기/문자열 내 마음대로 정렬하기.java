import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (s1, s2) -> {
            // 기준 : n 번째 문자를 기준으로 비교!
            if(s1.charAt(n) != s2.charAt(n)){
                return Character.compare(s1.charAt(n), s2.charAt(n));
            }else{
                // 같은 문자일 경우 사전순
                return s1.compareTo(s2);
            }
            
        });
        
        return strings;
    }
}