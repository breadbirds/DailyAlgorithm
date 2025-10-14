import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// input
		int N = Integer.parseInt(br.readLine());
		String[] tempScore = br.readLine().split(" ");
		int[] score = new int[tempScore.length];
		for(int i=0; i<tempScore.length; i++) {
			score[i] = Integer.parseInt(tempScore[i]);
		}
		
		// 정렬
		Arrays.sort(score);
		
		// 가장 작은 Group 찾기
		int minValue = Integer.MAX_VALUE;
		for(int i=1; i<=score.length/2; i++) {
			minValue = Math.min(minValue, score[i-1] + score[score.length-i]);
		}
		
		
		// 정답 출력
		System.out.println(minValue);
		
	}

}