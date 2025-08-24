import java.io.*;
import java.util.*;


/**
 * https://www.acmicpc.net/problem/1107
 * 
 * 문제 읽기
 * 
 * - 리보컨 구성 : 0 ~9 숫자와, 버튼 2개(+, -)
 * - 0보다 낮은 채널은 없으며, 채널은 무한대 만큼 존재 한다.
 * 
 * - 수빈이가 이동하려고 하는 채널 N번과 고장난 버튼 M 이 주어졌을 때, 채널 N 으로 이동하기 위해 최소 몇 번 버튼을 눌러야하는지 구하여라.
 * 	 여기서 버튼을 누른다는 의미는 +, - 뿐만 아니라 각 숫자버튼이 눌리는 모든 순간을 의미한다.
 *   ex) N = 14124, M = 0 일때 고장난 버튼은 없지만 해당 번호로 이동하기 위해 1 4 1 2 4 총 5개의 숫자 버튼을 눌러야 한다. answer = 5
 * - 수빈이가 현재 보고 있는 채널은 100 이다.
 * 
 * 
 */
public class Main {
	
	static int N, M, answer;
	static boolean[] isBroken;
	
    // x를 숫자버튼만으로 입력 가능하면 자릿수 반환, 불가하면 -1
    static int digitsIfTypable(int x) {
    	
    	// 채널이 0번일때 특별한 예외처리... ~
        if (x == 0) return isBroken[0] ? -1 : 1;
        
        // x(channel)의 자리수를 하나씩 보며, 고장난 것이 있는지 없는지 확인
        // 고장나지 않을 경우 최종적으로 해당 channel 의 길이가 반환된다.
        int len = 0;
        while (x > 0) {
            if (isBroken[x % 10]) return -1;
            len++;
            x /= 10;
        }
        return len;
    }

    public static void main(String[] args) throws Exception {
    	
    	// init & input
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 이동하고자 하는 채널
        M = sc.nextInt(); // 고장난 버튼 수 
        isBroken = new boolean[10];
        answer = Integer.MAX_VALUE;
        
        // 사용이 불가능한 버튼 입력받기 : 고장난 버튼이 있는 경우에만
        if (M > 0) {
            for (int i = 0; i < M; i++) {
                isBroken[sc.nextInt()] = true;
            }
        }

        // 1) +, - 만 사용
        int answer = Math.abs(N - 100);

        // 2) 숫자버튼으로 찍을 수 있는 모든 채널 시도 (상한 1,000,000, N 최대 500,000 → 위아래 여유 감안)
        for (int channel = 0; channel <= 1_000_000; channel++) {
        	
        	// 이동을 시도하는 채널 channel 로, 숫자 버튼만으로 ‘직접 입력’ 가능한지
        	// 숫자번호가 고장나 해당 channel 로 이동할 수 없는 경우, 의미 없는 방문이다.
            int d = digitsIfTypable(channel);
            if (d == -1) continue;                 // 숫자버튼만으로 입력 불가
            
            // d(길이) + (목표 채널 - channel => 절대값 차이 계산)
            int press = d + Math.abs(N - channel);      // 자릿수 + ± 이동
            
            // 이동 최소범위를 구하는 것이 문제
            if (press < answer) answer = press;
        }

        
        // Result
        System.out.println(answer);
    }


}
