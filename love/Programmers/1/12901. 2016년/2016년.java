class Solution {
    public String solution(int a, int b) {
        String answer = "";
    	int[] days = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    	String[] week = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
    	
    	// Simulation : 월-일을 모두 days 로 변환한다.
    	int total = b;
    	for(int i=1; i<a; i++) {
    		total += days[i];
    	}

    	// Result
       	return week[(total-1) % 7];
    }
}