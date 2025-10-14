import java.io.*;
import java.util.*;

/**
문제 읽기
- 카드를 순서대로 한 장씩 사용 (재사용 불가능)
- 카드를 사용하지 않고 다음 카드로 넘어갈 수 없음
- 카드 뭉치 순서 변경 불가능

- cards1, cards2, goal 값이 주어질 때, card1, cards2 에 적힌단어들을 규칙에 맞게 활용하며 goal을 만들 수 있을 경우 Yes or No
*/
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        int idxA = 0;
        int idxB = 0;
        
        for(int i=0; i<goal.length; i++){
            String cur = goal[i];
            
            // cards1 로 만들 수 있는 경우
            if(idxA < cards1.length && cards1[idxA].equals(cur)){
                idxA++;
                continue;
            }
            
            // cards2 로 만들 수 있는 경우
            if(idxB < cards2.length && cards2[idxB].equals(cur)){
                idxB++;
                continue;
            }
            
            // 둘다 가능한 경우?
            return "No";
        }
        
        return "Yes";
    }
}