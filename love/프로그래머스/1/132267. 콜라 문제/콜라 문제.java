class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        while(n >= a) {
			// 받을 수 있는 콜라 예측
			int newCola = (n/a) * b;
			
			// 현재 개수에서 빼기
			n = (n % a) + newCola;
			
			// 몇 병의 콜라를 받았는지 기록하기
			answer += newCola;
		}
        
        return answer;
    }
}