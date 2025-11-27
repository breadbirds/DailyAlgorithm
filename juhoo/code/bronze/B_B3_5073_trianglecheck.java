package source_code;

import java.util.Scanner;

// 삼각형의 세 변의 길이에 따른 경우의 수
// Equilateral : 세 변의 길이가 모두 같은 경우
// Isosceles : 두 변의 길이만 같은 경우
// Scalene : 세 변의 길이가 모두 다른 경우
// 삼각형 조건 만족 x => Invalid (가장 긴 변의 길이보다 나머지 두 변의 길이 합이 길어야 함)

// 입력: 1000 이하 양의 정수 3개 (막 줄은 0 0 0)
// 출력: 유형 출력

public class B_B3_5073_trianglecheck {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int first = sc.nextInt();
		int second = sc.nextInt();
		int third = sc.nextInt();
		
		while(first != 0) {
			// 조건 확인
			int maxLine = Math.max(Math.max(first, second), third);
			if(maxLine < first + second + third - maxLine) {
				if(first == second && second == third) {
					System.out.println("Equilateral");
				} else if(first == second || second == third || first == third) {
					System.out.println("Isosceles");
				} else {
					System.out.println("Scalene");
				}
			} else {
				System.out.println("Invalid");
			}
			
			first = sc.nextInt();
			second = sc.nextInt();
			third = sc.nextInt();
		}
		
	}

}
