/**
[문제 읽기]
- 기사는 자신의 기사번호의 약수 개수에 해당하는 공격력을 가진 무기를 구매 하려 한다.
  단, 공격력 제한 수치 정하고, 그 값보다 큰 공격력을 가진 무기를 구매해야하는 기사는 협약기관에서 정한 공격력 무기를 구매해야함한 공격력 무기를 구매해야함
  
[풀이 전략]
- 약수 구하는 공식만 잘 세우면 가능!
 
*/
import java.io.*;
import java.util.*;

class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        // 약수 구하기
        int[] divisorCnt = new int[number+1];
        for (int i = 1; i <= number; i++) {
            for (int j = i; j <= number; j += i) {
                divisorCnt[j]++;
            }
        }
        
        for(int i=1; i<=number; i++){
            // 약수 개수 구하기
            int cnt = divisorCnt[i];
            
            // limit 초과 여부 판단
            if(cnt > limit) cnt = power;
            
            // 결과 누적
            answer += cnt;
        }
        
        return answer;
    }
}