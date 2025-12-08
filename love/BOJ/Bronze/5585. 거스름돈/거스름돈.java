import java.io.*;
import java.util.*;



public class Main {

	static int N;
	static int[] coins = {500, 100, 50, 10, 5, 1}; // 정해진 동전 금액
	
    public static void main(String[] args) throws Exception {
    	
    	// input & init
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken()); // 동전의 종류

    	// Simulation : 1000엔 지폐를 냈을 때, 잔돈에 포함된 잔돈의 개수 구하기
		int price = 1000 - N;
    	int answer = 0;
    	
    	for(int i=0; i<coins.length; i++) {
    		// 종료조건
    		if(price == 0) break;
    	
    		// 잔돈 계산
    		answer += price/coins[i];
    		price = price%coins[i];
    	}
    	
    	
    	// Result
    	System.out.println(answer);
    
    }


}
