import java.io.*;
import java.util.*;

/**
[문제 읽기]
- 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는가?
- 중복된 전화번호는 주어지지 않음
- 접두어가 있으면 false, 접두어가 없으면 true

*/
class Solution {
    public boolean solution(String[] phone_book) {
        
        // 1. 정렬 후 인접 번호를 비교하는 방법 : Hash 미사용
        /**
        Arrays.sort(phone_book);
        for(int i=0; i<phone_book.length-1; i++){
            if(phone_book[i+1].startsWith(phone_book[i])){
                return false;
            }
        }
        return true;
        */
        
        
        // 2. Hash를 사용한 방법
        Set<String> set = new HashSet<>();
        for(String number: phone_book){
            set.add(number);
        }
        
        // 전화번호를 하나씩 불러오고, '한 글자씩'  prefix에 더하며 일치하는 접두어가 있는지 확인한다.
        for(String number: phone_book){
            
            // i번째 문자열 마다 초기화 되는 존재 : i 번째 글자의 0번째 인덱스부터 하나씩 가져온다.
            StringBuilder prefix = new StringBuilder();
            for(int i=0; i<number.length()-1; i++){
                
                // 접두어 한글자씩 추가하기
                prefix.append(number.charAt(i));
                
                // 접두어가 일치하는 경우가 있다면 바로 시스템 종료
                if(set.contains(prefix.toString())) return false;
            }
        }
        
        // 접두어 일치하는 경우가 없을 때
        return true;
    }
}