import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		int N = 9;
		
		int[] arr = new int[N];
		int sum = 0;
		for(int i=0; i<N; i++) {
			int temp = Integer.parseInt(br.readLine());
			sum += temp;
			arr[i] = temp;
		}
		
		// 반복문으로 100이 되는 경우 찾기
		loofOut:
		for(int i=0; i<N-1; i++) {
			for(int j=i+1; j<N; j++) {
				int v = arr[i] + arr[j];
				
				if(100 == (sum-v)) {
					arr[i] = 0;
					arr[j] = 0;
					break loofOut;
				}
			}
		}
		
		Arrays.sort(arr);
		for(int i=2; i<N; i++) {
			System.out.println(arr[i]);
		}
		
	}
}