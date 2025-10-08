import java.io.*;
import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
    	Map<Integer, Integer> matching = new HashMap<>() {
    		{
    			put(1, 3); // 매우 비동
    			put(2, 2); // 비동
    			put(3, 1); // 약간 비동
    			put(4, 0); // 모르겠음
    			put(5, 1); // 약간 동의
    			put(6, 2); // 동의
    			put(7, 3); // 매우동의
    		}
    	};
    	
    	Map<Character, Integer> score = new HashMap<>() {
    		{
    			put('R', 0);
    			put('T', 0);
    			
    			put('C', 0);
    			put('F', 0);
    			
    			put('J', 0);
    			put('M', 0);
    			
    			put('A', 0);
    			put('N', 0);
    		}
    	};
    	
    	for(int i=0; i<choices.length; i++) {
    		// 모르겠음을 선택하는 경우
    		if(choices[i] == 4) continue;
    		
    		// 비동의 하는 쪽
    		char select = ' ';
    		if(choices[i] < 4) {
    			select = survey[i].charAt(0);
    		}else {
    			// 동의 하는 쪽
    			select = survey[i].charAt(1);
    		}

			score.put(select, score.get(select) + matching.get(choices[i]));
    	}
    	
    	
    	// 결과 유형 선택하기
    	String answer = "";
    	if(score.get('R') >= score.get('T')) answer += 'R';
    	else answer += 'T';
    	
    	if(score.get('C') >= score.get('F')) answer += 'C';
    	else answer += 'F';
    	
    	if(score.get('J') >= score.get('M')) answer += 'J';
    	else answer += 'M';
    	
    	if(score.get('A') >= score.get('N'))answer += 'A';
    	else answer += 'N';
    
		// Result
	    return answer;
		//	System.out.println(answer);
    }
}