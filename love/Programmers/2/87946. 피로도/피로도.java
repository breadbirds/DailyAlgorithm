import java.io.*;
import java.util.*;

/**
[문제풀이]
- 일정 피로도를 사용해서 던전을 탐험할 수 있다.
  던점 탐험을 시작하기 위한 '최소 필요도' + 던전 탐험을 마쳤을 때 소모되는 '소모 피로도'
- 하루동안 유저가 탐험할 수 있는 최대 던전 수 return
*/
class Solution {
    
    static int maxRound = 0;
    static int answer = 0;
    static boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        
        // init
        maxRound = dungeons.length;
        visited = new boolean[maxRound];
        
        // 완전 탐색 dfs
        dfs(dungeons, k, 0);
        
        return answer;
    }
    
    static void dfs(int[][] dungeons, int hp, int cnt){
        
        // // 0. 종료조건 : 최대치에 도달했거나, 더이상 체력이 없는 경우(0)
        // if(cnt == maxRound || hp == 0){
        //     answer = Math.max(answer, cnt);
        //     return;
        // }
        boolean want = false;
        
        // 완전탐색
        for(int i=0; i<maxRound; i++){
            int needHP = dungeons[i][0];
            int useHP = dungeons[i][1];
            
            if(!visited[i] && hp >= needHP && hp-useHP>=0) {
                // 한번이라도 방문
                want = true;
                
                // 탐색하는 경우 : 방문 처리
                visited[i] = true;
                
                // 다음 호출
                dfs(dungeons, hp-useHP, cnt+1);
                
                // 탐색하지 않는 경우 : 방문 취소
                visited[i] = false;
            }
        }
        
        // 정답 갱신
        /**
        * [정답 갱신]
        기존에는 dfs 상단에 길이나 최대값의 제한을 확인하는 방식으로 중단했지만, 여기서는 boolean 으로 판단한다.
        한 번이라도 던전에 들어간 경우, 그렇지 못한 경우, 혹은 1 & 3 번째만 들어간 경우 모두 다를 수 있기 때문에
        기존 방식처럼 dfs 초기에만 정답을 초기화 하려고 할 경우, 중간에 한번밖에 탐험하지 못한 경우? 답이 갱신되지 않을 수도있음
        */
        if(!want){
            answer = Math.max(answer, cnt);
        }
        
    }
}