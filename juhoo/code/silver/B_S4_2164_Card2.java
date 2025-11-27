package source_code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

// 1. 제일 위의 카드 버리기
// 2. 그 다음 위에 있는 카드를 제일 아래로 옮김

// 입력: N (마지막 카드 숫자)
// 출력: 가장 마지막에 남는 카드 숫자

// 1. 입력 받기
// 1-1. 카드를 순서대로 list에 저장
// 2. 규칙에 따라서 한 개의 카드가 남을 때까지 게임 play
// 3. list의 개수가 하나가 되면 멈추고 출력

public class B_S4_2164_Card2 {
	public static void main(String[] args) {
		// 1. 입력 받기
		Scanner sc = new Scanner(System.in);
		int lastNumber = sc.nextInt();

		// 1-1. 카드를 순서대로 list에 저장
		List<Integer> cards = new LinkedList<>();
		for (int i = 0; i < lastNumber; i++) {
			cards.add(i + 1);
		}

		// 2. 규칙에 따라서 한 개의 카드가 남을 때까지 게임 play
		int lastCard = checkCardsCnt(cards);

		// 3. list의 개수가 하나가 되면 멈추고 출력
		System.out.println(lastCard);
	}

	private static int checkCardsCnt(List<Integer> cards) {
		while (cards.size() > 1) {
			playGame(cards);
		}

		return cards.get(0);
	}

	private static void playGame(List<Integer> cards) {
		// 1번 규칙
		cards.remove(0);
		// 2번 규칙
		int x = cards.get(0);
		cards.remove(0);
		cards.add(x);
	}

}
