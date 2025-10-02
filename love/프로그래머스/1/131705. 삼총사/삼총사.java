class Solution {
    public int solution(int[] number) {
        // 다른사람의 DFS 풀이 버전 참고
        
        int answer = 0;
        for(int i=0; i<number.length-2; i++){
            for(int j=i+1; j<number.length-1; j++){
                for(int k=j+1; k<number.length; k++){
                    if(number[i] + number[j] + number[k] == 0) answer++;
                }
            }
        }
        return answer;
    }
}