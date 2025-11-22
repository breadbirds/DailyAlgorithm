import java.io.*;
import java.util.*;

/**
- h 번 이상 인용된 논문이 최소 h 편 있어야 한다.
- 가능한 최대 h 값을 찾아야 한다.
*/
class Solution {
    public int solution(int[] citations) {
        
        // 오름차순으로 정렬해놓기
        Arrays.sort(citations);
        int n = citations.length;
        
        int h = 0;
        for(int i=0; i<n; i++){
            // 끝(큰값부터 비교하기
            int cited = citations[n-1-i]; // 논문의 인용 수
            int papers = i+1; // 논문 개수
            
            if(cited >= papers){
                h = papers;
            }else{
                break;
            }
        }
        
        
        // Result
        return h;
    }
}