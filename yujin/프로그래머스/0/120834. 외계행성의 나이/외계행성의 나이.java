class Solution {
    public String solution(int age) {
    String answer = "";
    char arr[] = String.valueOf(age).toCharArray();
    char c[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'};
    for(int i = 0; i < arr.length; i++) {
    	int digit = arr[i] -'0';
    	answer +=c[digit];
    }
    
    return answer;
}

}