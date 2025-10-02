import java.io.*;

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        int idx = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == ' ') {
                answer.append(" ");
                idx = 0; // 공백 만나면 인덱스 초기화
            } else {
                if (idx % 2 == 0) {
                    answer.append(Character.toUpperCase(ch));
                } else {
                    answer.append(Character.toLowerCase(ch));
                }
                idx++;
            }
        }

        return answer.toString();
    }
}