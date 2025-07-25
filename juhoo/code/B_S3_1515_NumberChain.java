package source_code;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B_S3_1515_NumberChain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] resultNum = sc.nextLine().toCharArray();
		int[] resultNumArray = new int[resultNum.length];

		for (int i = 0; i < resultNum.length; i++) {
			resultNumArray[i] = resultNum[i] - '0';
		}

		int targetIndex = 0;
		int currentN = 1;
		

		while (targetIndex < resultNumArray.length) {

			// 자릿수별로 나눠서 리스트에 저장
			List<Integer> numberList = new ArrayList<>();

			int num = currentN;

			while (num > 0) {
				numberList.add(0, num % 10);
				num /= 10;
			}
			

			// list의 수가 입력과 일치하면 index 옮기기
			for (int n : numberList) {
				if (targetIndex < resultNumArray.length && n == resultNumArray[targetIndex]) {
					targetIndex++;
				}
			}

			currentN++;
		}
		
		System.out.println(currentN - 1);
	}

}
