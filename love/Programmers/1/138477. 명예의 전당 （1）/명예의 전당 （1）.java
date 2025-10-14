import java.util.*;
import java.io.*;
/**
 * [문제 읽기]
 * 
 * - 매일 1명의 가수가 노래를 부르고, 시청자들이 문자 투표로 가수에 점수 부여
 * - 매일 출연한 가수의 점수가 지금까지 출연한 가수들의 점수 중 상위 k 번째 이내이면 해당 가수의 점수를 명예쩐당 목록에 올려 기념
 *   => 프로그램 시작 이후 초기 k일까지는 모든 출연 가수의 점수가 명에 전당에 오르게됨
 *      k일 이후 부터는 출연 가수의 점수가 기존 명예전당 목록의 k 번째 순위의 가수 점수보다 더 높을 때 전당에 오름. 기존 k번쨰 순위 점수는 명예 전당에서 내려옴
 * 
 * - 매일 "명예의 전당"의 최하위 점수를 발표함.
 * - 매일 발표된 명예의 전당의 최하위 점수를 return 하는 Solution 완성하기
 *
 * [풀이 전략]
 * - sort 된 list 선언 및 사용 (k 사이즈로 매번 검사.)
 */
class Solution {
    public int[] solution(int k, int[] score) {
        
        // init
        int[] answer = new int[score.length];
        
        // 내림 차순 리스트 생성
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0; i<score.length; i++){
            // 값 넣기
            list.add(score[i]);
            list.sort(Comparator.reverseOrder());
            
            // k 개 기준 전/후 출력 기준이 다름
            if(list.size() < k){
                answer[i] = list.get(list.size()-1);
                continue;
            }else{
                answer[i] = list.get(k-1);
            }
        }
        
        
        return answer;
    }
}