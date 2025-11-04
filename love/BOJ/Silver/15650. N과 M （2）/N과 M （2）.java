import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int N, M;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] nm = br.readLine().split(" ");
		N = Integer.parseInt(nm[0]); // 1~n까지의 수 조합 
		M = Integer.parseInt(nm[1]); // 길이(조합의 수가) M 이어야 함
		arr = new int[M];
		
		getValues(1, 0);
		
	}

	private static void getValues(int at, int cnt) {
		
		// 기저 부분: 조건을 만족할 경우 바로 출
		if(cnt == M) {
			for(int i=0; i<arr.length; i++)
				System.out.print(arr[i] + " ");
			
			System.out.println();
			return;
		}
		
		// 유도 부분: 재귀함수를 계속 호출하는 부분
		for(int i=at; i<=N; i++) {
			
			// 방문하지 않은 경우 재귀함수 호출 진행
			arr[cnt] = i;
			getValues(i+1, cnt+1);
		}
		
		
	}
}
