import java.io.*;
import java.util.*;

/**
[문제 읽기]
- 귤을 크기별로 분류했을 때, 서로 다른 종류의 수를 최소화
- 판매하고자하는 귤 k, 서로다른 귤의 크기 개수는 최소 몇개 ?

[풀이 방법]
- 귤의 크기별로 개수(빈도) 수를 계산하고, 가장 많이 있는 귤부터 차례대로 담기
*/
class Solution {
    public int solution(int k, int[] tangerine) {
        
        // 귤 크기별로 빈도수 계산
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int t: tangerine) countMap.put(t, countMap.getOrDefault(t, 0) + 1);
        
        // 크기별 개수를 내림차순
        List<Integer> counts = new ArrayList<>(countMap.values());
        counts.sort(Collections.reverseOrder());
        
        // 최적의 답 찾기
        int total = 0;
        int answer = 0;
        
        for(int c: counts){
            total += c;
            answer++;
            
            if(total >= k) break;
        }

        return answer;
    }
}