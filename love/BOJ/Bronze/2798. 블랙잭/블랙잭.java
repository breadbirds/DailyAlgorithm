import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] nm = br.readLine().split(" ");
		int N = Integer.parseInt(nm[0]);
		int M = Integer.parseInt(nm[1]);
		
		String[] arr = br.readLine().split(" ");
		int[] cards = new int[N];
		for(int i=0; i<N; i++) 
			cards[i] = Integer.parseInt(arr[i]);
		
		// 계산
		int ans = 0;
		
		loopOut:
		for(int i=0; i<N-2; i++) {
			for(int j=i+1; j<N-1; j++) {
				for(int k=j+1; k<N; k++) {
					
					int temp = cards[i] + cards[j] + cards[k];
					

					// 체크
					if(temp > ans && temp <= M)
						ans = temp;
				}
			}
		}
		
		
		// 출력
		System.out.println(ans);
		
	}
}