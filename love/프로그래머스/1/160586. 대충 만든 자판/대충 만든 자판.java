import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        // 1) 문자 → 최소 누름 횟수(= 인덱스+1) 맵
        Map<Character, Integer> cost = new HashMap<>();
        for (String key : keymap) {
            for (int i = 0; i < key.length(); i++) {
                char c = key.charAt(i);
                int press = i + 1; // 인덱스+1
                cost.put(c, Math.min(cost.getOrDefault(c, Integer.MAX_VALUE), press));
            }
        }

        // 2) 각 target 계산
        int[] answer = new int[targets.length];
        for (int i = 0; i < targets.length; i++) {
            int sum = 0;
            for (char c : targets[i].toCharArray()) {
                Integer p = cost.get(c);
                if (p == null) { sum = -1; break; } // 하나라도 불가하면 -1
                sum += p;
            }
            answer[i] = sum;
        }
        return answer;
    }
}
