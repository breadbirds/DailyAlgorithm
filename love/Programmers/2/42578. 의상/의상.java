import java.io.*;
import java.util.*;

/**
[문제풀이]
- 각 종류별 최대 1가지 의상 착용 가능
- 의상의 일부가 겹치더라도, 한가지라도 다른 경우 서로 다른 방법으로 옷을 착용한 것으로 계산
- 하루에 최소 한 개의 의상을 입니다.
- 같은 이름을 가진 의상은 존재하지 않는다.
*/
class Solution {
    public int solution(String[][] clothes) {
        
        // 1. Set 을 선언 후, clothes[n][1](착장 부위) 의 개수를 count
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<clothes.length; i++){
            String key = clothes[i][1];
            
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        
        // 2. 단순 수학 연산
        int answer = 1;
        for(int cnt: map.values()){
            answer *= (cnt + 1);
        }
        
        answer -= 1;
        
        return answer;
    }
}