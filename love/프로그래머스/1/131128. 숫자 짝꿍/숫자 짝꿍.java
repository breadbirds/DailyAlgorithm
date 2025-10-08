import java.io.*;
import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        int[] cntX = new int[10];
        int[] cntY = new int[10];
        for (char ch : X.toCharArray()) cntX[ch - '0']++;
        for (char ch : Y.toCharArray()) cntY[ch - '0']++;
    	
    	// 큰 수가 되도록 9 → 0 순서로 붙이기
        StringBuilder sb = new StringBuilder();
        for (int d = 9; d >= 0; d--) {
            // 양쪽에 수가 있어야 짝궁수로 인정되기 때문에 max가 아닌 min 값 선택
            int k = Math.min(cntX[d], cntY[d]);
            
            // min 값 만큼 반복하며 누적
            for (int t = 0; t < k; t++) sb.append((char)('0' + d));
        }
    	
		// Result
        if(sb.length() == 0) return "-1";
        if(sb.charAt(0) == '0') return "0";
        return sb.toString();
    }
}