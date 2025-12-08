import java.io.*;
import java.util.*;



public class Main {

	static int N;
	static Integer[] coins;
    public static void main(String[] args) throws Exception {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken()); // 동전의 종류

    	int[] coins = {25, 10, 5, 1}; // 정해진 동전 금액
    	
    	// i = 횟수
    	for(int i=0; i<N; i++) {
    		int[] answer = new int[4];
    		int price = Integer.parseInt(br.readLine());
    		
    		// 동전 계산하기
    		for(int j=0; j<4; j++) {
    			
    			// 금액을 모두 채우면 중단
    			if(price == 0) break;
    			
    			// 동전 계산하기
    			answer[j] = (int) (price/coins[j]);
    			price = (int) (price%coins[j]);
    		}

    		
        	// Result
        	for(int j=0; j<4; j++) {
        		System.out.print(answer[j] + " ");
        	}
        	System.out.println();
    	}
    }


}
