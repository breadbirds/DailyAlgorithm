import java.io.*;
import java.util.*;


/**
 * [문제 읽기]
 * - 상품 2+1 행사 : 3개 구매시 한개 무료 (가장 저렴한 것)
 * - 친구들과 먹을 N 팩의 유제품 구매 : 최소비용으로 구매할 수 있도록 돕기 !
 */
public class Main {

	
    public static void main(String[] args) throws Exception {
    	
    	// input & init
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine()); // 유제품 수
    	
    	int[] arr = new int[N];
    	for(int i=0; i<N; i++) {
    		arr[i] = Integer.parseInt(br.readLine());
    	}
    	Arrays.sort(arr);
    	
    	
    	/**
    	 * Simulation
    	 * - 맨 앞에서 하나 뽑고, 나머지는 뒤에서 2개 뽑기?
    	 */
    	int answer = 0;
    	int cnt = 0;
    	for (int i = N - 1; i >= 0; i--) {
    		// 개수가 3의 배수일 때만 무료 !
    		cnt += 1;
    		
    		if(cnt%3 == 0) continue;
    		else answer += arr[i];
    	}


    	// Result
    	System.out.println(answer);
    
    }


}
