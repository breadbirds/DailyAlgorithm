class Solution {
    public int[] solution(int money) {
        
        int[] answer = new int[2];
        if(money >= 5500) {
            int coffee = money / 5500;
            int change = money - (coffee*5500);
            answer[0] = coffee;
            answer[1] = change;
        }
        else{
          answer[0] = 0;
            answer[1] = money;
        }
return answer;
 
        // return answer;
    }
}