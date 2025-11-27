package source_code;

import java.util.Scanner;

// 육각형
// 중앙 1부터 시작해서 이웃하는 방에 돌아가면서 1씩 증가하는 번호를 매김
// 중앙 1에서 N번 방까지 최소 개수 방을 지나서 갈 때 몇 개의 방을 지나가는가?

// 입력: N
// 출력: 최소 개수 방을 지나서 갈 때 몇 개의 방을 지나는지

// 규칙: depth 증가 (1 -> 2 -> 8 - > 201 -> 38) -> 6의 배수씩 커짐

public class B_B2_2292_Honeycomb {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int targetRoom = sc.nextInt();
		
		int cntNum = 0;
		int calculate = 1;
		

		while(true) {			
			if(calculate <= targetRoom) {
				if(calculate == 1) {
					calculate++;
					cntNum++;
				} else {
					calculate += 6*cntNum;
					cntNum++;
				}
			} else {
				break;
			}
		}
		
		System.out.println(cntNum);
	}

}
