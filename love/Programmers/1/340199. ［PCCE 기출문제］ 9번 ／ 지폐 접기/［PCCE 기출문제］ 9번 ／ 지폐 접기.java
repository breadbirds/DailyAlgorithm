class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        // 조건이 충족될 때 까지 반복 한다.
        while(true){
            
            // 종료 조건 검사 : 지폐를 정방향 or 회전 했을 때 지갑에 들어가는가 ?
            if((wallet[0] >= bill[0] && wallet[1] >= bill[1])
               || wallet[0] >= bill[1] && wallet[1] >= bill[0]){
                break;
            }
            
            // 지폐 접기
            if(bill[0] > bill[1]){
                bill[0] /= 2;
            }else{
                bill[1] /= 2;
            }
            
            // 접기 회수 증가
            answer++;
            
        }
        return answer;
    }
}