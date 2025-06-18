import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// N번째 종말의 수가 될 값을 찾아야 한다. => '666' 이 포함된 N번째 값
		int N = Integer.parseInt(br.readLine());
		
		int num = 666;
		int cnt = 1;
		
		while(cnt != N) {
			num++;
			
			// 666이 포함될 때 마다, 사용자가 찾는 N번째 종말의 수에 가까워진다.
			if(String.valueOf(num).contains("666")) cnt++;
		}
		
		System.out.println(num);
		
	}
}