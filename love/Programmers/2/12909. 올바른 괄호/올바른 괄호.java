import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        
        for(char ch: s.toCharArray()){
            if(ch == '('){
                stack.add(ch);
            }else{
                if(!stack.empty() && stack.peek() == '('){
                    stack.pop();
                }else{
                    answer = false;
                    return answer;
                }
            }
        }
        
        if(!stack.empty()) return false;

        return answer;
    }
}