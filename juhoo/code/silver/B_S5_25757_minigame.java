package source_code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

// 윷놀이 Y(2), 같은 그림 찾기 F(3), 원카드 O(4)
// 플레이 신청 횟수 N
// 한 번 같이 플레이 하면 다시 안함

// 입력: 플레이 신청 횟수 / 플레이할 게임의 종류 /// 플레이할 사람의 이름
// 출력: 최대로 몇 번이나 게임할 수 있는지

// 1. 입력 받기
// 1-1. 각 게임 종류와 필요 인원 수를 map 미리 저장 (인원 수는 본인 제외해서 1 뺴고 저장)
// 1-2. 사람 이름 입력 받을 때 이미 list에 있으면 저장 X

// 2. 전체 size를 필요 인원 수로 나누면 결과 도출

public class B_S5_25757_minigame {
	// 1. 입력 받기
	// 1-1. 각 게임 종류와 필요 인원 수를 map 미리 저장 (인원 수는 본인 제외해서 1 뺴고 저장)

	static final Map<String, Integer> games = new HashMap<>();
	static {
		games.put("Y", 1);
		games.put("F", 2);
		games.put("O", 3);
	}

	public static void main(String[] args) {
		// 1-2. 사람 이름 입력 받을 때 이미 list에 있으면 저장 X
		Scanner sc = new Scanner(System.in);

		int applyNum = sc.nextInt();
		String game = sc.next();
		// List<String> names = new ArrayList<>();
		Set<String> names = new HashSet<>();

		for (int i = 0; i < applyNum; i++) {
			names.add(sc.next());

//			String currentName = sc.next();
//
//			if (!names.contains(currentName)) {
//				names.add(currentName);
//			}
		}

		// 2. 전체 size를 필요 인원 수로 나누면 결과 도출
		int result = names.size() / games.get(game);
		System.out.println(result);
	}
}
