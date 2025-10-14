class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        for(char ch: s.toCharArray()){
            
            // 공백처리
            if(ch == ' '){
                answer += " ";
            }else{
                // 문자 이동
                char shifted = (char) (ch + n);
                
                // 기존 문자의 대, 소문자 구분을 통해 a~z 사이 값들만 나오도록
                // z, a 와 같이 끝값이 나오는 경우엔 -= 26 과정은 필요 없기 때문에 if 문 조건 사용
                if (Character.isUpperCase(ch) && shifted > 'Z') {
                    shifted -= 26;
                } else if (Character.isLowerCase(ch) && shifted > 'z') {
                    shifted -= 26;
                } 
                
                answer += shifted;
            }
        }
         
        
        return answer;
    }
}