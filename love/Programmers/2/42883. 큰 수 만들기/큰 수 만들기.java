import java.io.*;
import java.util.*;

/*
[문제읽기]
- 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 수 구하기
*/
class Solution {
    public String solution(String number, int k) {

        Stack<Character> stack = new Stack<>();
        
        for(char ch: number.toCharArray()){
            
            // 스택이 비어있을 때 & k==0
            if(stack.isEmpty() || k == 0){
                stack.push(ch);
                continue;
            }
            
            // while : 맨 앞이 가장 큰수가 될 때 까지 반복
            while(!stack.isEmpty() && k > 0 && stack.peek() < ch){
                stack.pop();
                k--;
            }
            
            stack.push(ch);
        }
        
        
        // 만약, number 가 모두 같은 수(ex. 1111) 로 되어있어서 하나도 제거 하지 못했을 때
        while(k > 0){
            stack.pop();
            k--;
        }
        

        // Stack to String
        StringBuilder sb = new StringBuilder();
        for(char c: stack) sb.append(c);
        
        return sb.toString();
    }
}