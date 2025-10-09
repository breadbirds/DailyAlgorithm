import java.io.*;
import java.util.*;
/**
 * [문제 읽기]
 * - 각자 설정한 출근 희망 시각에 늦지 않고 출근한 직원들에게 상품 증정 이벤트 진행
 * - 자신이 설정한 '출근 희망 시각 + 10분' 까지 출근해야 함
 *   단, 토요일/일요일 출근 시간은 이벤트 영향 X
 * - 직원들은 매일 한 번씩만 어플로 출근, 모든 시각은 시에 100을 곱하고, 분을 더한 정수로 표현
 *   ex) 10시 13분 => 1013, 9시 58분 => 958
 * 
 * - 상품을 받은 직원은 몇명일까 ?
 *   
 */
class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
    	/**
    	 * Simulation
    	 * - 주말 제외, 평일 기준 (출근 예정시간+10) 이전에 출근했는가?
    	 * - 시와 분을 모두 minute 단위로 표시하기
    	 */
    	int answer = 0;
    	
    	for(int i=0; i<schedules.length; i++) {
    		
    		// 근로자가 정한 출근시간
    		int limit = toMinute(schedules[i]) + 10;
    		
    		// 일주일 출근시간 체크
    		int cnt = 0;
    		for(int j=0; j<7; j++) {

    			// 주말 제외
    			int dayIdx = ((startday - 1) + j) % 7;
                if (dayIdx >= 5) continue;
    			
    			// 출근 시간 변환
                int arrive = toMinute(timelogs[i][j]);
    			if (arrive <= limit) cnt++;
    		}
    		
    		// 평일동안 잘 지켰는지!
    		if(cnt >= 5) answer++;
    	}
    	
		// Result
		return answer;
    	//System.out.println(answer);
    }
    
    private static int toMinute(int times) {
    	int hour = times / 100;
    	int minute = times % 100;

    	return hour*60 + minute;
    }

}