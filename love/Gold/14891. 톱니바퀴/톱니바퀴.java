import java.io.*;
import java.util.*;


/**
 * 문제 읽기
 * 
 * - 8개의 톱니를 가지고 있는 "톱니바퀴 4개(1~N 번호를 가짐)" 일렬로 정렬 되어 있음
 * - 톱니는 N극 또는 S극중 하나
 * - 톱니바퀴를 총 K 번 회전 시키려고 한다.
 *   톱니바퀴의 회전은 '한 칸을 기준'으로 함. 회전(시계방향 or 반시계방향)
 *   회전시킬 톱니바퀴와 회전 시킬 방향을 결정 해야함. 톱니바퀴가 회전할 때, 서로 맞닿은 극에 따라 옆에 톱니 바퀴를 회전시킬 수도 있음
 *   => A 톱니바퀴가 회전할때 맞닿은 B 톱니바퀴의 톱니 극이 다르면 B는 A가 회전한 방향과 "반대방향" 으로 회전
 * 
 * - 맞닿는 부분이란 오른쪽-왼쪽에 해당됨
 * 
 * 
 * - 톱니바퀴의 초기 상태와 톱니바퀴를 회전시킨 방법이 주어질 때, 초치종 톱니바퀴의 상태를 구하여라
 * 
 */

import java.io.*;
import java.util.*;

public class Main {
    static String[] wheel = new String[4]; // 각 톱니의 8자리 문자열(0,1) 이 기록될 배열
    static int[] wheelTop = new int[4];    // 각 톱니의 12시 가 몇번째인지 기록될 인덱스(톱니방향은 총 8개 0~7)

    
    /**
     * rightWheel / leftWheel
     * - 톱니바퀴의 휠은 총 8개로 되어있다.
     * - 그중 각 휠의 양쪽(맞닿은 부분)에 해당되는 휠은 순서대로 인덱스를 부여하면 2번재, 6번째에 해당된다.
     * - wheel 은 초기 휠 방향성을 가지고 있기 때문에 wheelTop 을 이용해 k 번째 휠의 12시 방향(가장 Top)을 먼저 찾고
     *   이후 +2, +6 %8 을 통해 rightWheel leftWheel 이 몇번째 index 인지 찾아내는 과정이다.
     */
    static char rightWheel(int i) { 
    	return wheel[i].charAt((wheelTop[i] + 2) % 8); 
    } 
    static char leftWheel(int i) { 
    	return wheel[i].charAt((wheelTop[i] + 6) % 8); 
    } 
    
    // d=1 시계, d=-1 반시계
    // wheelTop[] => 톱니의 12시 방향 값 변경 
    static void rotate(int i, int d) {
        if (d == 1) {
        	wheelTop[i] = (wheelTop[i] + 7) % 8;
        }else {
        	wheelTop[i] = (wheelTop[i] + 1) % 8;
        }
    }

    static int[] buildRot(int idx, int dir) {
    	// 각 톱니바퀴를 어떤 방향으로 돌릴지 기록(-1, 0, 1), 0 회전 안함
        int[] rot = new int[4];
        rot[idx] = dir;
        
        // 톱니가 맞물리면 '반대 방향' 으로 돈다. 때문에 -1을 항상 곱해 -1로 만들거나 1로 만들어야 한다.

        // 왼쪽 전파
        for (int i = idx - 1; i >= 0; i--) {
            if (rightWheel(i) != leftWheel(i + 1)) rot[i] = -rot[i + 1];
            else break;
        }
        
        // 오른쪽 전파
        for (int i = idx + 1; i < 4; i++) {
            if (rightWheel(i - 1) != leftWheel(i)) rot[i] = -rot[i - 1];
            else break;
        }
        
        return rot;
    }

    
    static void simulation(int idx, int dir) {
    	// 각 K번째 톱니바퀴가 어떤 방향으로 돌지 결정 (맞물리는 경우가 있다면 방향이 바뀜)
        int[] rot = buildRot(idx, dir);
        for (int i = 0; i < 4; i++)
            if (rot[i] != 0) rotate(i, rot[i]); // 일괄 회전
    }

    public static void main(String[] args) throws Exception {
    	
    	// init & input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 4; i++) wheel[i] = br.readLine().trim(); // 문자열로 한번에 저장 : 개별 값으로 저장하지 않아도 괜찮음
        int K = Integer.parseInt(br.readLine().trim()); // 회전수
        
        // 회전수 k 번째 일 때 : 회전시킨 방법(톱니바퀴 번호 0~3, 방향(1 시계방향, -1 반시계)
        for (int k = 0; k < K; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());
            
            simulation(idx, dir);
        }

        // Result
        int answer = 0;
        for (int i = 0; i < 4; i++) {
        	// 1~4 번재 톱니의 12시 방향이 N 이면 무조건 0점, S일 경우 1/2/4/8 점이다.
        	// wheel[i] 번째는 i==k 번째 휠을 의미하며, wheelTop 에는 해당 톱니바퀴의 12시 방향이 기록되어있으므로, 문자열을 매번 변경하지 않아도 된다.
            if (wheel[i].charAt(wheelTop[i]) == '1') answer += 1 << i; // 1,2,4,8 가중치 
        }
        System.out.println(answer);
    }
}
