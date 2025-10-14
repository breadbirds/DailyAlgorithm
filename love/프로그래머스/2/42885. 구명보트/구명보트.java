import java.io.*;
import java.util.*;

/**
[문제 읽기]
- 사람들을 구출하기 위해 필요한 최소한의 구명보트 개수
- 구명보트는 최대 2명 (limit KG 제한) 이 있음
*/
class Solution {
    public int solution(int[] people, int limit) {
        
        // 1. 최적의 해를 찾기 위한 오름차순 정렬
        Arrays.sort(people);
        
        // 2. 포인터 방식으로 진행
        int answer = 0;
        int left = 0;
        int right = people.length - 1;
        
        while(left <= right){
            
            // 가장 무거운 사람을 기준으로 태우기
            if(people[left] + people[right] <= limit){
                left++;
                right--;
            } else{
                // 같이 못타는 경우 : right가 너무 무거운 경우 혼자 타야함
                right--;
            }
            
            // 무조건 둘이 같이 타거나, 한명만 타는 결과가 나옴
            answer++;
        }
        
        return answer;
    }
}