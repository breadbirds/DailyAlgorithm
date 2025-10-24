import java.io.*;
import java.util.*;

/**
[문제 읽기]
- 마트에서 일정한 금액을 지불하면 10일 동안 회원이 될 수 있음
- 매일 한가지 제품을 할인하는 행사 진행, 할인 제품은 하루에 하나씩만 구매 가능
- 정현이는 자시이 원하는 제품의 수량이 할인하는 날짜와 10일 연속으로 일치할 경우에 맞춰서 회원가입을 하려고 함
- 회원등록시 정현이가 원하는 제품을 모두 할인 받을 수 있는 회원등록 날짜의 총 일수는?
*/
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        Map<String, Integer> wants = new HashMap<>();
        for(int i=0; i<want.length; i++){
            wants.put(want[i], number[i]);
        }
        
        
        // 2. discount 의 0번째 날부터 시작해서 1번에 포함된 제품중 하나라도 있는가 본다. 잇음 개수 줄이기(복사본), 그 다음 제품 개수줄이기... (10까지만)
        // 그리고 복제본 cnt가 모두 0이면 ok
        // 만약 복제본 cnt에 하나라도 1이 남아있음 fail
        for(int startDay=0; startDay<=discount.length-10; startDay++){
            // 기존 Map 내용 복사하기
            Map<String, Integer> copys = new HashMap<>();
            copys.putAll(wants);
            
            // start 시작으로 10일까지만 검사
            for(int j=startDay; j<startDay+10; j++){
                
                if(copys.containsKey(discount[j])){
                    copys.put(discount[j], copys.get(discount[j]) - 1);
                } else{
                    // None
                }
            }
            
            
            // 복사된 Map 의 Cnt가 모두 0인지 검사하기
            boolean isZero = true;
            for (Integer value : copys.values()) {
                if(value != 0){
                    isZero = false;
                    break;
                }
            }
            
            // 판단
            if(isZero) answer++;
            
        }
        
        
        
        return answer;
    }
}