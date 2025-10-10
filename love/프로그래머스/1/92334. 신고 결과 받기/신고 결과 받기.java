import java.io.*;
import java.util.*;
/**
 * [문제 읽기] : 신고 결과 받기
 * - 불량 이용자를 신고하고 처리 결과를 메일로 발송하는 시스템 개발
 * 
 * - 각 유저는 한 번에 한 명의 유저를 신고 할 수 있음
 *   신고 횟수에 제한은 없다. 서로 다른 유저를 계속 신고 가능
 *   한 유저 여러번 신고도 가능, 그러나 동일 유저에 대한 신고 횟수는 1회 처리
 * - k번 이상 신고된 유저는 게시판 이용 정지, 해당 유저를 신고한 모든 유저에게 정지 사실 메일 발송
 *   유저가 신고한 모든 내용을 취합하여 마지막에 한꺼번에 게시판 이용 정지를 시키면서 메일 발송
 */
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int n = id_list.length;

        // 이름 -> 인덱스
        Map<String, Integer> idx = new HashMap<>();
        for (int i = 0; i < n; i++) idx.put(id_list[i], i);

        // 피신고자 -> 신고자 집합 (중복 제거)
        Map<String, Set<String>> reportedBy = new HashMap<>();
        for (String id : id_list) {
        	reportedBy.put(id, new HashSet<>());
        }

        // 전역 중복 제거 (같은 신고자->피신고자 다중 신고 무시)
        Set<String> unique = new HashSet<>(Arrays.asList(report));
        for (String r : unique) {
            String[] sp = r.split(" ");
            String from = sp[0]; // 신고자
            String to   = sp[1]; // 피신고자
            
            reportedBy.get(to).add(from);
        }

        // 정지 대상 선정 및 메일 카운트
        int[] answer = new int[n];
        for (String bad : id_list) {
            Set<String> reporters = reportedBy.get(bad);
            if (reporters.size() >= k) {
                for (String from : reporters) {
                    answer[idx.get(from)]++; // 신고자에게 메일 1통
                }
            }
        }
        
		// Result
    	return answer;
    }
}