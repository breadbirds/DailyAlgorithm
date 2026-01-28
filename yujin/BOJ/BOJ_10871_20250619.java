package Algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10871_20250619 {
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N, X;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		ArrayList<Integer> answer = new ArrayList<>();
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			if (arr[i] < X) {
				answer.add(arr[i]);
			}
		}

		for (int i = 0; i < answer.size(); i++) {
			System.out.print(answer.get(i));
			if (i < answer.size() - 1) {
				System.out.print(" ");
			}
		}
	}

}
