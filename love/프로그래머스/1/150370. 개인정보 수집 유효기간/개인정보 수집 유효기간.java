import java.io.*;
import java.util.*;
/**
 * [문제 읽기]
 * - 고객의 동의를 얻어 수집된 1~n 번으로 분류되는 개인정보 n건
 *   약관마다 개인정보 보관 유효기간이 정해져 있음
 *   개인정보는 유효기간 전까지만 보관 가능하며, 유효기간이 지난 경우 반드시 파기
 * 
 * - 오늘 날짜로 파기해야 할 개인정보 번호를 구해야 한다.
 *   모든 달은 28일 까지 있다고 가정 한다.
 *   
 */

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
    	// 1) 오늘을 총일수로
        int todayDays = toDays(today);
    	
        // 2) 약관: 타입 -> 개월 수
        Map<String, Integer> termMonths = new HashMap<>();
        for (String t : terms) {
            String[] sp = t.split(" ");
            termMonths.put(sp[0], Integer.parseInt(sp[1]));
        }
    	
        // 3) 각 개인정보 검사
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String[] sp = privacies[i].split(" "); // "YYYY.MM.DD TYPE"
            int startDays = toDays(sp[0]); // 약관일자
            int months = termMonths.get(sp[1]); // 약관타입(기간)

            // (수집일 + 개월*28) <= 오늘이면 파기
            int expireThreshold = startDays + months * 28; // 유효기간 마지막날 = start + months*28 - 1
            if (expireThreshold <= todayDays) {
                res.add(i + 1); // 번호는 1부터
            }
        }

        // 이미 privacies를 앞에서부터 검사했으니 res는 오름차순 상태
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private int toDays(String ymd) {
        String[] p = ymd.split("\\.");
        int y = Integer.parseInt(p[0]);
        int m = Integer.parseInt(p[1]);
        int d = Integer.parseInt(p[2]);
        // 한 해 = 12개월, 한 달 = 28일 가정
        return (y * 12 + m) * 28 + d;
    }
}