class Solution {
    public String solution(int[] food) {
        
        String answer = "";
        
        // food[0] = 물의 양. 항상 '1' 고정 값
        // food[] 는 칼로리가 작은 순서대로 정렬되어 있음.
        
        // 홀수의개의 음식을 짝수로 만들어주기
        for(int i=1; i<food.length; i++){
            if(food[i]%2 != 0) food[i]--;
        }
        
        // 짝수만 남게된 음식 분배하기
        for(int i=1; i<food.length; i++){
            int num = i;
            int cnt = food[i]/2;
            
            for(int j=0; j<cnt; j++){
                answer += (num + "");
            }
        }
        
        // 가운데 물을 추가하고, 뒤집어서 대칭
        String reversed = new StringBuilder(answer).reverse().toString();
        answer = answer + "0" + reversed;
        
        return answer;
    }
}