import java.io.*;
import java.util.*;

/**
 * 문제 읽기
 * 
 * - 키와 몸무게로 덩치 표현. 등수를 매길 예정
 * - 덩치 = (몸무게, 키) = (x, y)
 * - 단, 몸무게나 키 둘중 하나만 클 경우엔 덩치가 크다고 볼 수 없음.
 */
class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// 몸무게, 키
		int[][] people = new int[N][2];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			people[i][0] = Integer.parseInt(st.nextToken());
			people[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// Result
		int[] answer = new int[N];
		for(int i=0; i<N; i++) {
			
			int win = 1;
			for(int j=0; j<N; j++) {
				// 자기 자신 제외
				if(i == j) continue;
				
				int weightA = people[i][0];
				int heightA = people[i][1];
				
				int wiehgtB = people[j][0];
				int heightB = people[j][1];
				
				if(weightA < wiehgtB && heightA < heightB) win++;
			}
			answer[i] = win;
		}
		
		
		for(int i=0; i<N; i++)
			System.out.print(answer[i] + " ");
	}
}