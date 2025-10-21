import java.io.*;
import java.util.*;

/**
[문제 읽기]
- 탈락하는 사람의 번호 + 자신의 몇번째 차례에 탈락하는가?
- 탈락자가 생기지 않는다면 0, 0
*/
class Solution {
    public int[] solution(int n, String[] words) {
    	int[] answer = new int[2];
    	char preWord = ' ';
    	Set<String> word = new HashSet<>();
    	
    	for(int i=0; i<words.length; i++) {
    		// 두번째 이상의 경우
    		char curWord = words[i].charAt(0);
    		
    		// 첫번째 턴의 경우 무조건 pass
    		if(i == 0) {
    			preWord = words[i].charAt(words[i].length() - 1);
    			word.add(words[i]);
    			continue;
    		}
    		
    		
    		// 1-1. 단어가 일치하지 않는 경우, 바로 종료
    		if(preWord != curWord) {
    			answer[0] = i%n + 1;
    			answer[1] = i/n + 1;
    			break;
    		}
    		
    		// 1-2. 중복된 단어일 경우
    		if(word.contains(words[i])) {
    			answer[0] = i%n + 1;
    			answer[1] = i/n + 1;
    			break;
    		}else {
    			// 1-3. 중복된 단어도 아니고, 끝말잇기 규칙에 맞는 단어를 말했을 경우
    			word.add(words[i]);
    			preWord = words[i].charAt(words[i].length() - 1);
    		}
    	}


        // Result
    	return answer;
        //System.out.println(answer[0] + " " + answer[1]);
    }
}