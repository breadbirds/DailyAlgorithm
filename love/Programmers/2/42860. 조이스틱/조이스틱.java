import java.io.*;
import java.util.*;

/*
[문제읽기]
- 맨 처음 구성 : 알파벳 'A' 구성 * 길이만큼 / 커서는 가장 앞에 위치함
- 조이스틱 조작 횟수를 최소화 하였을 때의 값을 구하여라
*/
class Solution {
    public int solution(String name) {
        
        int answer = 0;
        int minMove = name.length();
        
        for(int i=0; i<name.length(); i++){
            // 0. 목표로 하는 문자
            char after = name.charAt(i);
            
            // 1. 문자를 바꾸기 위한 조작
            answer += Math.min(after - 'A', 'Z' - after + 1);
            
            // 2. 커서 이동의 최소화 (* after가 A 라면 바꿀 필요가 없음!)
            int j = i + 1;
            while(j < name.length() && name.charAt(j) == 'A') j++;
            
            // minMove = Math.min(minMove, j);
            minMove = Math.min(minMove, 2*i + (name.length() - j));
            minMove = Math.min(minMove, i + 2*(name.length() - j));
        }
        
        
        return answer + minMove;
    }
}