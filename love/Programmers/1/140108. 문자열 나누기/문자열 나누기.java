import java.io.*;
import java.util.*;

class Solution {
    public int solution(String s) {
    	// Simulation
        char x = ' ';
        
        int answer = 0;
        int idx = 0;
        int xCnt = 0;
        int notXCnt = 0;
        
        while(idx < s.length()) {
        	
        	// 1. 처음일때 or 문자열이 분리되고 난 이후
        	if(xCnt == 0 && notXCnt == 0) {
        		x = s.charAt(idx);
        		xCnt++;
        		idx++;
        		continue;
        	}
        	
        	// 2. x 와 현재 문자가 동일한 경우
        	if(x == s.charAt(idx)) {
        		xCnt++;
        		idx++;
        		continue;
        	}
        	
        	// 3. x와 현재 문자가 동일하지 않은 경우
        	notXCnt++;
        	idx++;
        	
        	// 3-1. 현재 cnt 수가 같은 경우
        	if(xCnt == notXCnt) {
        		xCnt = 0;
        		notXCnt = 0;
        		answer++;
        	}
        }
        
        // 마지막 덩어리 처리하기 (초기화 되지 못했다 ==> 처리되지 못하고 남은 나머지)
        if (xCnt != 0 || notXCnt != 0) answer++;
        
    	// Result
    	return answer;
    	//System.out.println(answer);
    }
}