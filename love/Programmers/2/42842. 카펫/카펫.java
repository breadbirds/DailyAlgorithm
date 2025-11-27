import java.io.*;
import java.util.*;

/**
[문제읽기]
- 카펫의 중앙은 노란색, 테두리 한줄은 갈색!
- 가로, 세로의 크기를 return 하기
*/
class Solution {
    public int[] solution(int brown, int yellow) {
        
        int total = brown + yellow;
        
        // 규칙 : 노란색의 최소값은 1이므로, H의 최소값 또한 3이상이 된다는 의미
        for(int H=3; H<=Math.sqrt(total); H++){
            
            if(total % H == 0){
                int W = total / H;
                
                if((W-2) * (H-2) == yellow){
                    return new int[]{W, H};
                }
            }
        }
        
        return new int[0];
    }
}