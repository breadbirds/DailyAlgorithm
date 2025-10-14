class Solution {
    public String solution(int[] numbers, String hand) {
    	StringBuilder sb = new StringBuilder();
    	int rightHand = 10; // *
    	int leftHand =  12; // #
    	
    	for(int num: numbers) {
    		if(num==7 || num==4 || num==1) { 
    			// 왼쪽 키패드 : 1, 4, 7
    			leftHand = num;
    			sb.append('L');
    		}else if(num==9 || num==6 || num==3) { 
    			// 오른쪽 키패드 : 9, 6, 3
    			rightHand =  num;
    			sb.append('R');
    		}else {
    			// 숫자가 0인 경우 키패트 위치를 11로 변환
    			if(num == 0) num = 11;
    			
    			// 가운데 키패드 : 8, 5, 2, 0
    			int moveRight = Math.abs(num - rightHand)/3 + Math.abs(num - rightHand)%3;
    			int moveLeft = Math.abs(num - leftHand)/3 + Math.abs(num - leftHand)%3;
    			
    			// 오른손 왼손 모두 동일할 경우, 어느손을 더 우선시 하는지로 판단
    			if(moveRight == moveLeft) {
    				if(hand.equals("right")) {
        				sb.append('R');
        				rightHand = num;
        			}else {
        				sb.append('L');
        				leftHand = num;
        			}
    			}else if(moveRight < moveLeft) {
    				sb.append('R');
    				rightHand =  num;
    			}else {
    				sb.append('L');
    				leftHand = num;
    			}
    		}
    	}// ...for
    	
		// Result
		return sb.toString();
		//System.out.println(sb.toString());
    }
}