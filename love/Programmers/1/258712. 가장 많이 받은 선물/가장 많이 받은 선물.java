import java.io.*;
import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;
        
        // <유저이름, 유저 key> 생성하기 : 이 key 값을 통해서 빠르게 유저를 찾을 수 있다.
        Map<String, Integer> idx = new HashMap<>();
        for (int i = 0; i < n; i++) idx.put(friends[i], i);

        // - 기록 : a, b 유저의 고정된 key(==index) 값을 가져와서 선물을 주고 받은 기록 갱신하기
        // - 
        int[][] cnt = new int[n][n];
        int[] given = new int[n];
        int[] recv  = new int[n];
        
        for (String g : gifts) {
            String[] sp = g.split(" ");
            int a = idx.get(sp[0]); // giver
            int b = idx.get(sp[1]); // receiver
            
            // 누가 누구한테 줬는지 기록하기 위함
            cnt[a][b]++;
            
            // 누구한테 주거나, 받았는지 상관없이 총합계만 보기 위함
            given[a]++;    // a가 준 총합 += 1
            recv[b]++;     // b가 받은 총합 += 1
        }

        // 선물지수 계산하기 : 이번 달까지 자신이 친구들에게 준 선물의 수에서 받은 선물의 수를 뺸 값
        int[] giftIndex = new int[n];
        for (int i = 0; i < n; i++) giftIndex[i] = given[i] - recv[i];

        // 다음 달 받을 개수 계산
        int[] nextReceive = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int a2b = cnt[i][j];
                int b2a = cnt[j][i];
                if (a2b > b2a) {
                    // 더 많이 준 사람(i)이 다음 달 받는다
                    nextReceive[i]++;
                } else if (a2b < b2a) {
                    nextReceive[j]++;
                } else {
                    // 같다면 선물지수 비교
                    if (giftIndex[i] > giftIndex[j]) nextReceive[i]++;
                    else if (giftIndex[i] < giftIndex[j]) nextReceive[j]++;
                    // 같으면 아무도 못 받음
                }
            }
        }

        // 최댓값
        int answer = 0;
        for (int x : nextReceive) answer = Math.max(answer, x);
        return answer;
    }
}