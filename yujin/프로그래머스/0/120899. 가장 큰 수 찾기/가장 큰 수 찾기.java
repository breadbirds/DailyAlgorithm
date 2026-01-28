class Solution {
    public int[] solution(int[] array) {
        int[] answer = new int[2];
        int largest = 0;
        int idx = 0;
        for(int i = 0; i < array.length;i++){
            if(array[i]>largest){
                largest=array[i];
                idx = i;
            }
        }
        answer[0] = largest;
        answer[1] = idx;
        return answer;
    }
}