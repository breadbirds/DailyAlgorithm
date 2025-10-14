import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] ingredient) {
        StringBuilder sb = new StringBuilder();
        int answer = 0;

        for (int v : ingredient) {
            // 숫자를 문자(char) 로 변환해서 저장
            sb.append((char)('0' + v));

            int len = sb.length();
            if (len >= 4 &&
                sb.charAt(len-4) == '1' &&
                sb.charAt(len-3) == '2' &&
                sb.charAt(len-2) == '3' &&
                sb.charAt(len-1) == '1') {
                sb.delete(len-4, len);
                answer++;
            }
        }
        return answer;
    }
}