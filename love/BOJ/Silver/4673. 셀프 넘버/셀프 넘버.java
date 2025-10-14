import java.io.*;
import java.util.*;


/**
 * 문제 읽기
 * - 양의 정수 n 에 대해서 d(n)을 n과 n의 각 자리수를 더하는 함수
 * 	 ex) d(75) 는 다음과 같이 계산 된다.  75 + 7 + 5 = 87
 * - n을 d(n) 의 생성자라고 한다. => 75는 87의 생성자 이다.
 * - 식 : n = m + (m의 각 자리수 합)
 *
 * - 생성자가 한개 이상인 경우도 있다. 예를 들어 101은 생성자가 2개 이다. (91과 100)
 * - 생성자가 없는 숫자를 '셀프넘버' 라고 한다.
 * 	 100보다 작은 셀프 넘버는 총 13개 (1, 3, 5, 7, 9, 20, 31, 42, 53, 64, 75, 86, 97)
 * 
 * - 10_000 보다 작거나 같은 셀프 넘버를 한 줄에 하나씩 출력하는 프로그램을 작성하시오.
 */
public class Main {


    public static void main(String[] args) throws Exception {
        
    	StringBuffer sb = new StringBuffer();
    	boolean[] nums = new boolean[10_001];
    	
    	// Simulation
    	for(int i=1; i<=10_000; i++) {
    		// n 더하기
    		int result = i;
    		int x = i;
    		
    		// n 의 각 자리수 더하기
    		while (x > 0) {
    			result += x%10;
    			x /= 10;
    		}
    		
    		// 최대값(10_000) 미만인 경우에만 사용(true) 표시
    		if(result <= 10_000) nums[result] = true;
 
    	}
    	
    	// Result
    	for(int i=1; i<10_001; i++) {
    		if(!nums[i]) System.out.println(i);
    	}

    }// ...main



}
