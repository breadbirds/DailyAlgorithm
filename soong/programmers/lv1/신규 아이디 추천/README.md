
# [프로그래머스 - lv1] 2019 2021 KAKAO BLIND RECRUITMENT. 신규 아이디 추천

## ⏰  **time**
30분

## ⏲️**Time Complexity**

## :round_pushpin: **Logic**

단계별로 차례로 조건을 적용해준다
그냥 String 보다는 StringBuilder를 활용하는 것이 좀더 간편하다
- `deleteCharAt(index)` : 인덱스의 문자 제거
- `charAt(인덱스)` : sb의 인덱스에 해당하는 문자

```java
class Solution {
    public String solution(String new_id) {

        // 1단계
        new_id = new_id.toLowerCase();

        // 2단계
        StringBuilder sb = new StringBuilder();
        for (char c : new_id.toCharArray()) {
            if ((c >= 'a' && c <= 'z') ||  
                (c >= '0' && c <= '9') ||   
                c == '-' || c == '_' || c == '.') {
                sb.append(c);
            }
        }
        
        // 3단계
        boolean check = false;
        StringBuilder sb2 = new StringBuilder();
        for(int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c == '.') {
                if (!check) {
                    sb2.append(c);
                    check = true;
                }
            } else {
                check = false;
                sb2.append(c);
            }           
            
        } 
        
        // 4단계
        if (sb2.length() > 0 && sb2.charAt(sb2.length() - 1) == '.') {
            sb2.deleteCharAt(sb2.length() - 1);
        }
        if (sb2.length() > 0 && sb2.charAt(0) == '.') {
            sb2.deleteCharAt(0);
        }
        
        // 5단계
        if (sb2.length() == 0) sb2.append("a");
        // 6단계
        if (sb2.length() >= 16) {
            sb2.setLength(15);
            if (sb2.charAt(sb2.length() - 1) == '.') {
                sb2.deleteCharAt(sb2.length() - 1);
            }
        }
        // 7단계
        if (sb2.length() <= 2) {
            while(sb2.length() <= 2) {
                sb2.append(sb2.charAt(sb2.length() - 1));
            }
        }
        
        
        return sb2.toString();
    }
}
```


## :black_nib: **Review**


## 📡**Link**
- https://school.programmers.co.kr/learn/courses/30/lessons/72410?language=java
