import java.io.*;
import java.util.*;

/**
[문제 읽기]
- 암호 규칙
  문자열 s 의 각 알파벳을 index 만큼 뒤의 알파벳으로 바꿔준다.
  index 만큼 뒤의 알파벳이 z를 넘어갈 경우 다시 a로 돌아간다.
  skip 에 있는 알파벳은 제외하고 건너뛴다.
*/
class Solution {
    public String solution(String s, String skip, int index) {
        // 1) skip 집합 만들기 (O(1) 조회)
    	
    	/**
    	 * 1. skip 단어로 구성된 단어 집합 만들기
    	 *    스킵해야할 단어를 매번 continas() 로 찾을 경우 시간 초과 문제가 있기 때문에
    	 *    O(1) 탐색을 위해 사용
    	 */
        boolean[] banned = new boolean[26];
        for (char c : skip.toCharArray()) {
        	banned[c - 'a'] = true;
        }

        // 2) 문자별로 순회하며 이동
        /**
         * 2. 암호 해독하기
         *    - StringBuilder 는 미리 크기를 지정해서 선언하여 효율적으로 사용
         *    - 규칙에 따라 문자 하나씩 변형
         */
        StringBuilder sb = new StringBuilder(s.length());
        for (char ch : s.toCharArray()) {
        	// init
            int moved = 0;
            char cur = ch;
            
            // 반복
            while (moved < index) {
            	// 문자열 하나 증가 했을 때
                cur++;                   // 오른쪽으로 한 칸
                
                // z 를 넘길경우 a로 변경
                if (cur > 'z') cur = 'a';
                
                // skip 에 포함된 문자열일 경우 카운트 증가 없이 진행
                if (banned[cur - 'a']) {
                    continue;
                }
                
                // 카운트 증가
                moved++; 
            }
            
            // 암호문 해독 작업이 하나 끝나면 정답 추가
            sb.append(cur);
        }
        
        // Result
        //System.out.println(sb.toString());
        return sb.toString();

    }
}