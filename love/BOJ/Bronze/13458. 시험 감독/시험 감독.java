import java.io.*;
import java.util.*;


/**
 * 문제 읽기
 * 
 * - N 개의 시험장, 각 시험장에는 응시자가 있다.
 *   i 번째 시험장 응시자의 수는 Ai 명
 * - 총감독, 부감독관 있음.
 *   총감독 : 시험장당 감시 가능 응시자수 B명
 *   부감독관 : 시험장당 감시 가능 응시자수 C명
 * - 각 시험장마다 총감독관 1명(최대), 부감독관(여러명)
 *   모든 응시자를 감시한다고 할대, 필요한 감독관 수의 최솟값
 * 
 */

public class Main {
	

    public static void main(String[] args) throws IOException {
    	// init & input
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int[] arr = new int[N];
    	for(int i=0; i<N; i++) {
    		arr[i] = sc.nextInt();
    	}
    	
    	int B = sc.nextInt(); // 총감독관 감시
    	int C = sc.nextInt(); // 부감독관 감시
    	
    	
    	// Simulation : 시험장 arr[i] 번째에 필요한 감독관 수 구하기
    	long answer = 0;
    	for(int i=0; i<N; i++) {
    		
    		// 시험장 하나당 총감독관은 최소 1명 필요
    		answer++;
    		
    		// 총감독관 한명으로 모두 감시할 수 없는 경우, 부감독관 필요
    		if(arr[i] - B > 0) {
    			// 감독받지 못하는 사람이 생기지 않도록 + C
    			// 부감독관이 과하게 필요하지 않도록 - 1
    			answer += ((arr[i] - B) + C - 1) / C;
    		}
    		
    	}

    	
    	// Result
    	System.out.println(answer);
    }
}