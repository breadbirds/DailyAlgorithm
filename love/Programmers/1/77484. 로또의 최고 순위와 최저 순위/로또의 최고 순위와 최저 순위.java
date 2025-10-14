import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
    	
    	// Simulation
    	HashMap<Integer, Integer> RANK = new HashMap<>() {
    		{
    			// put(일치한 번호 수, 등수)
    			put(6, 1);
    			put(5, 2);
    			put(4, 3);
    			put(3, 4);
    			put(2, 5);
    			put(1, 6);
    		}
    	};
    	
    	int[] answer = new int[2]; // 최고 순위, 최저 순위
    	boolean[] winNums = new boolean[46];
    	for(int i=0; i<win_nums.length; i++) {
    		winNums[win_nums[i]] = true;
    	
    	}
    	
    	int zero = 0; // 채워야 하는 숫자 수
    	int myWin = 0; // 내가 현재까지 맞힌 숫자
    	for(int num: lottos) {
    		if(num == 0) zero++;
    		if(winNums[num]) myWin++;
    	}
    	
    	// 채워넣기
    	answer[0] = RANK.get(myWin + zero) == null ? 6 : RANK.get(myWin+zero); // 최고 순위
    	answer[1] = RANK.get(myWin) == null ? 6 : RANK.get(myWin); // 최저 순위
    	
    	// Result
    	return answer;
    	//System.out.println(answer[0] + ", " + answer[1]);
    }
}