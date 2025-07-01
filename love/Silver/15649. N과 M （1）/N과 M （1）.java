import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static boolean[] used;
    static int[] result;
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		used = new boolean[N + 1];  // 숫자 사용 여부 체크 (1~N)
		result = new int[M];        // 뽑은 결과 저장
	        
        backtrack(0);		
	}


	private static void backtrack(int depth) {
		// 최대 길이!
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(result[i] + " ");
			}
			
			System.out.println();
	        return;
	    }
		
		// 재귀호출
		for (int i = 1; i <= N; i++) {
            if (!used[i]) {
                used[i] = true;
                result[depth] = i;
                backtrack(depth + 1);
                used[i] = false;  // 백트래킹: 원상복구
            }
        }
		
	}
}