import java.util.*;
class Solution {
    public String solution(String my_string) {
        String answer = "";
        
        answer = my_string.toLowerCase();
        
        char arr[] = answer.toCharArray();
        
        Arrays.sort(arr);
        
        String result = new String(arr);
        return result;
    }
}