import java.io.*;
import java.util.*;

/**
[문제읽기]
- 단어의 구성은 A E I O U
- 첫단어 AA, 다음 단어 AA, 마지막은 UUUUU
- word 가 주어질때, 사전에서 몇 번째 단어인지 return 하기
*/
class Solution {
    public int solution(String word) {
        
        int answer = 0;
        char[] alpha = {'A', 'E', 'I', 'O', 'U'};
        
        // 가중치 : 첫글자에서 앞 글자 1개가 스킵시키는 단어 수, ...
        /**
        weight : 가중치
        - A 에서 시작해서 AEEEE 까지 확인이 되어야 'E' 라는 글자를 찾을 수 있다.
          이때 그렇다면 E가 사전에 나오기전에 A로 시작하는 모-든 단어가 몇개인지 알아야하는데 그값이 781개이다.
          1글자 A(1개), 2글자 A(AA, AE.. 5개), 3글자 a(AAA, AAE... AUU, 25개)...
          
          781 = 1 + 5 + 25 + 125 + 625 + 781
        */
        int[] weight = {781, 156, 31, 6, 1};
        
        // Simulation
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            
            // 현재 문자가 몇 번째 모음인지 찾기
            int idx = 0;
            for(int j = 0; j<5; j++){
                if(alpha[j] == c){
                    idx = j;
                    break;
                }
            }
            
            //
            answer += idx * weight[i];
            answer += 1;
        }
        
        return answer;
    }
}