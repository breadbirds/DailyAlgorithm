import java.util.*;

class Solution {
    public int solution(String s){

        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            
            // 첫 번째 값일 경우 무조건 PUSH
            if(i == 0){
                stack.push(ch);
            }else{
                // 두번째 값부터 비교
                if(!stack.empty() && stack.peek() == ch){
                    stack.pop();
                }else{
                    stack.push(ch);
                }
            }
        }

        
        if(stack.empty()){
            return 1;
        }else{
            return 0;
        }

    }
}