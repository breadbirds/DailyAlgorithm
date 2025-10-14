import java.util.*;
import java.io.*;

/**
* 문제 읽기
  - 시전시간(t) 동안 1초마다 x 체력 회복 가능
  - t 초 연속으로 붕대를 감는데 성공하면, y만큼의 추가 체력 회복 (체력은 최대치 제한 있음)
  
  - 붕대를 감는 도중, 몬스터에게 공격을 받으면 기술 취소 (연속 성공시간 0 초기화), 체력 줄어듬
  - 체력이 0이 될경우 캐릭터 사망
  
  - 기술을 취소당하거나, 붕대감기 기술을 끝까지 할 경우 기술은 다시 사용


* 최종 줄력
  - 모든 공격이 끝난 이후, 남은 체력
  - 캐릭터가 죽은 경우엔 -1 return
  
* int[] bandage : t(시전시간), x(초당회복력), y(추가 회복량)
  int health : 체력
  int[][] attacks : [ [공격시간1, 피해량1], [공격시간2, 공격시간2] ]
    - 공격시간을 기준으로 오름차순 정렬된 상태. (공격시간은 겹치지 않는다.)
*/
class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int life = health; // 현재 체력
        int attackIdx = 0; // 공격배열 인덱스 (for문은 시간 단위로 동작하므로 별도 관리)
        int heal = 0; // 시전 시간
        
        // 1초 ~ 마지막 공격시간까지 진행
        for (int time = 1; time <= attacks[attacks.length-1][0]; time++){
            
            if (time != attacks[attackIdx][0]){
                // 붕대감기를 하는 경우 : 초당 회목이기 때문에 무조건 life가 증가한다.
                life += bandage[1];
                
                // 연속으로 몇 번 붕대를 감앗는지 체크(시전 시간 증가)
                // 기준(시전시간)과 동일해지면 체력을 추가 회복하고, 초기화
                heal++;
                if (heal == bandage[0]){
                    life += bandage[2];
                    heal = 0;
                }
                
                // 체력은 최대치를 넘을 수 없으므로 확인 작업 필요
                if (life > health) life = health;
            } else {
                // 붕대감기 초기화 & 체력 저하
                heal = 0;
                life -= attacks[attackIdx][1];
                attackIdx++;
                if (life <= 0) return -1;
            }
        }
        return life;
    }
}