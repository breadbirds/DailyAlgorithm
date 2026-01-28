class Solution {
    public double solution(int[] numbers) {
        double answer = 0;
        double cnt = 0;
        int sum = 0;
        for(int i = 0; i < numbers.length; i++){
             sum += numbers[i];
             cnt++;
             
        }
        answer = sum / cnt;
        return answer;
    }
}