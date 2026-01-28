class Solution {
    public int solution(int order) {
        int answer = 0;
        char[]arr = String.valueOf(order).toCharArray();
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == '3' ||arr[i] =='6' ||arr[i]=='9'){
                answer++;
            }
        }
        
        return answer;
    }
}