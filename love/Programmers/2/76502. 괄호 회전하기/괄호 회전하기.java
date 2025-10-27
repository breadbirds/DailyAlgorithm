import java.io.*;
import java.util.*;
/**
 * [문제 읽기]
 * - () [] {} : 올바른 괄호 문자열
 * - 소괄호, 중괄호, 대활호로 이루어진 문자열 s
 *   s를 왼쪽으로 x 칸만큼 회전시켰을 때, s가 올바른 괄호 문자열이 되게 하는 x의 개수를 return 하여라
 */

class Solution {
    public int solution(String s) {
    	// Simulation
    	int answer = 0;
    	int n = s.length();
    	
    	for(int i=0; i<n; i++) {
    		// s.substring(a) : a 부터 끝까지
    		// s.substring(a, b) : a 부터 b 직전까지
    		String rotated = s.substring(i) + s.substring(0, i);
    		if(isValid(rotated)) answer++;
    	}

    	return answer;
    	//System.out.print();
    }

    // 괄호 유효성 검사
	private static boolean isValid(String str) {
		Stack<Character> stack = new Stack<>();
		
		for(char ch: str.toCharArray()) {
			// 시작 괄호가 나오면 무조건 Push
			if(ch == '(' || ch == '{' || ch == '[') {
				stack.push(ch);
			}else {
				// 닫는 괄호 : stack 에 넣지 않고, 짝이 되는지만 확인한다.
				
				if(stack.isEmpty()) return false;
				
				char top = stack.pop();
				if ((ch == ')' && top != '(') ||
	                (ch == '}' && top != '{') ||
	                (ch == ']' && top != '[')) return false;
			}
		}
		
		// 닫는 괄호와 여는 괄호가 올바르게 짝지어져 있다면 최종 stack 은 비어있는 상태가 된다.
		return stack.isEmpty();
	}

}