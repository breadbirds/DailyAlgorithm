class Solution {
    public int solution(String s) {
        String[] numberWords = {
            "zero", "one", "two", "three", "four", 
            "five", "six", "seven", "eight", "nine"
        };
        
        StringBuilder temp = new StringBuilder(); // 누적할 문자열
        StringBuilder result = new StringBuilder(); // 최종 숫자 결과
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            
            // 숫자면 바로 추가 : 별도로 temp 에 누적하거나 초기화할 필요 없음 !
            if(Character.isDigit(ch)) { 
                result.append(ch);
            }else {
                // 알파벳일 경우 누적 검사
                temp.append(ch);
                
                // ** 영어 - 숫자 비교!
                for(int j=0; j<numberWords.length; j++){
                    if(temp.toString().equals(numberWords[j])){
                        result.append(j);
                        temp.setLength(0);
                        break;
                    }
                }
            }
        }
        

        return Integer.parseInt(result.toString());
    }
}