class Solution {
    public String solution(String my_string) {
        String answer = "";
        char[]arr = my_string.toCharArray();
        for(int i = 0; i<arr.length;i++){
            if(answer.indexOf(arr[i])==-1){
                answer+=arr[i];
            }
        }
        return answer;
    }
}