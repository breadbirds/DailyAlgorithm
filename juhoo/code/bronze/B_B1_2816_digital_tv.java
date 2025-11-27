package source_code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// 여러 채널 중 KBS1, KBS2를 1,2번 채널로 만들려고 함
// 리모콘을 이용해서 리스트의 순서를 바꿈
// 왼쪽의 작은 화살표는 현재 선택 채널
// 가장 처음에 화살표는 첫 채널을 가리킴

// 버튼
// 1. 화살표를 한 칸 아래로 내림(i -> i+1)
// 2. 화살표를 위로 한 칸 올림 (i -> i-1)
// 3. 현재 선택 채널을 한 칸 아래로 내림(i switch i+1 / 화살표는 i+1)
// 4. 현재 선택 채널을 위로 한 칸 올림(i switch i-1 / 화살표는 i-1)

// 입력: 채널 수 N / 채널 이름들
// 출력: 눌러야 하는 버튼들(공백X)


public class B_B1_2816_digital_tv {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 1. 입력 받아서 저장 & kbs1, kbs2 위치 찾기
		int channelNum = sc.nextInt();
		sc.nextLine();
		List<String> channels = new ArrayList<>();
		
		int kbs1Location = -1;
		int kbs2Location = -1;
		
		int arrowNum = 0;
		String result = "";
		
		for(int i = 0; i<channelNum; i++) {
			String channelText = sc.nextLine();
			channels.add(channelText);
			
			if(channelText.equals("KBS1")) {
				kbs1Location = channels.size() - 1;
			} else if(channelText.equals("KBS2")) {
				kbs2Location = channels.size() - 1;
			}
		}
		
		// 2. KBS1 옮기기
		// 2-1. KBS1의 위치만큼 화살표 옮기기
		int idx = channels.indexOf("KBS1");

		for(int i = 0; i<idx; i++) {
			result += "1";
		}
		
		// 2-2. KBS1을 0번째로 옮기기
		while(!channels.get(0).equals("KBS1")) {
			result += "4";
			
			idx = channels.indexOf("KBS1");
			if(idx > 0) {
				Collections.swap(channels, idx, idx - 1);
			}
		}
		
			
		// 3. KBS2 옮기기
		// 2-1. KBS2의 위치만큼 화살표 옮기기
		idx = channels.indexOf("KBS2");

		for(int i = 0; i<idx; i++) {
			result += "1";
		}
		
		// 2-2. KBS2을 1번째로 옮기기
				while(!channels.get(1).equals("KBS2")) {
					result += "4";
					
					idx = channels.indexOf("KBS2");
					if(idx > 0) {
						Collections.swap(channels, idx, idx - 1);
					}
				}
				
				System.out.println(result);

		
	}

}
