import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n) {
    	int answer = 0;
    	
    	int num = 1;
    	while(num <= n) {
    		
    		// num ~ N 까지 더하며 확인
    		int sum = 0;
    		for(int i=num; i<=n; i++) {
    			sum += i;
    			
    			// n 을 초과하면 중단
    			if(sum > n) break;
    			
    			// n 과 일치하면 정답 추가, 중단
    			if(sum == n) {
    				answer++;
    				break;
    			}
    		}
    		// num 증가
    		num++;
    	}
    	
    	// Result
        //System.out.println(answer);
        return answer;
    }
}