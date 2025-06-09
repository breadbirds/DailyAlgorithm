package source_code;

import java.util.Scanner;

// 테이블: W개씩 H행
// 모든 참가자는 세로로 N or 가로로 M칸 이상 비우고 앉아야 함
// = 다른 참가자와 세로줄 번호의 차가 N보다 크거나 가로줄 번호 차가 M보다 큰 곳에만 앉을 수 있음
// => 강의실이 거리두기 수칙을 지키면서 최대 몇 명을 수용할 수 있는가?

// 입력: H(세로 길이), W(가로 길이), N(세로 띄움), M(가로 띄움)
// 출력: 수용 가능한 최대 인원 수 

// 1. H / (1 + N) => 세로로 들어가는 최대 사람 수 
// 2. W / (1 + M) => 가로로 들어가는 최대 사람 수
// 3. 1번 * 2번 => 최대 수용 가능 인원 수

public class B_B3_23971_ZOAC {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int height = sc.nextInt();
		int width = sc.nextInt();
		int spaceNum_height = sc.nextInt();
		int spaceNum_width = sc.nextInt();
		
		// 1. 세로로 들어가는 최대 사람 수
		int heightNumCal1 = height % (1 + spaceNum_height);
		int heightNumCal2 = height / (1 + spaceNum_height);
		
		int maxHeightNum = 0;
		if(heightNumCal1 == 0) { 
			maxHeightNum = heightNumCal2;
		}else {
			maxHeightNum = heightNumCal2 + 1;
		}
		
		// 2. 가로로 들어가는 최대 사람 수 
		int maxWidthNum = 0;
		int widthNumCal1 = width % (1 + spaceNum_width);
		int widthNumCal2 = width / (1 + spaceNum_width);
		
		if(widthNumCal1 == 0) { 
			maxWidthNum = widthNumCal2;
		}else {
			maxWidthNum = widthNumCal2 + 1;
		}

		// 3. 최대 수용 가능 인원 수
		int maxNum = maxHeightNum * maxWidthNum;
		
		//System.out.println("maxHeightNum: " + maxHeightNum + " " + "maxWidthNum: " + maxWidthNum);
		
		System.out.println(maxNum);
	}

}
