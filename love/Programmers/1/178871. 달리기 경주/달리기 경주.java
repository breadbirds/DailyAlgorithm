import java.io.*;
import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
    	// 0. players 자체는 그대로 사용한다! 정렬순서가 등수와 동일하기 때문에
    	
    	// 1. 선수이름+등수 조합의 Map 만들기 (등수와 관련없이 선수이름-몇등인지만 기록하기 위하ㅣㅁ)
    	Map<String, Integer> rank = new HashMap<>();
    	for(int i=0; i<players.length; i++) {
    		rank.put(players[i], i); // 1등부터 count 하지만 0으로 해도 상관 없음
    	}
    	
    	// 2. 해설자가 말하는 이름 하나씩 꺼내오기
    	for(String name: callings) {
    		// 해당 선수의 등수 가져오기
    		int i = rank.get(name);
    		
    		// 현재 1등인 경우엔 무시
    		if(i == 0) continue;
    		
    		// 그 외인 경우 : 밀려날 사람
    		String front = players[i-1];
    		
    		// 교환
    		players[i-1] = name;
    		players[i] = front;
    		
    		// 선수정보 갱신 : HashMap 이라 중복없이 갱신
    		rank.put(name, i-1); // 등수 상승
    		rank.put(front, i); // 등수 하락
    	}
    	

		// Result
		return players;
    	//System.out.println();
    }
}