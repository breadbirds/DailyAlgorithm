package Algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9086_20250623 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			String input = br.readLine();
			for (int k = 0; k < input.length(); k++) {
				System.out.print(input.charAt(0));
				System.out.println(input.charAt(input.length()-1));
				break;
			}
			
		}
		
	}

}
