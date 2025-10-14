/**
[문제 읽기]
- 사진 속 나오는 인물의 그리움 점수를 모두 합산한 값이 해당 사진의 추억 점수가 된다.
- 사진들의 추억의 점수를 출력하여라
*/
import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        // init
        int[] answer = new int[photo.length];
        
        // Simulation
        for(int i=0; i<photo.length; i++){
            // i번째 사진
            int score = 0;
            for(int j=0; j<photo[i].length; j++){
                // 인물 점수 구하기
                String cur = photo[i][j];
                for(int k=0; k<name.length; k++){
                    if(cur.equals(name[k])){
                        score += yearning[k];
                    }else{
                        continue;
                    }
                }
            }
            
            // 넣기
            answer[i] = score;
        }
        
        // Result
        return answer;
    }
}