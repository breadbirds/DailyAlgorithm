import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
    	int N = board.length;
    	List<Integer> list = new ArrayList<>();
    	int answer = 0;
    	
    	// 크레인이 이동할 위치 : move
    	for(int move: moves) {
    		int cur = move-1;
    		
    		// 1. 해당 위치를 수직 (위-아래) 로 인형을 만날 때 까지 탐색한다 !
    		int idx = 0;
    		while(idx < N) {
    			if(board[idx][cur] != 0) {
    				
    				// 1. 바구니에 하나도 없는 경우 무조건 넣기
    				if(list.size() == 0) {
    					list.add(board[idx][cur]);
    				}else if(list.get(list.size()-1) == board[idx][cur]) {
    					// 같은 인형 마주침
                        list.remove(list.size()-1);
    					answer += 2;
    				}else {
    					// 서로 다른 인형일 경우
    					list.add(board[idx][cur]);
    				}
    				
    				// 기존 뽑기 기계에 있는 인형 제거
    				board[idx][cur] = 0;
    				break;
    			}else {
    				//System.out.println("((인형이 없으므로 다음 위치 탐색))");
    				idx++;
    			}
    		}
    	}

		// Result
		return answer;
		//System.out.println(answer);
    }
}