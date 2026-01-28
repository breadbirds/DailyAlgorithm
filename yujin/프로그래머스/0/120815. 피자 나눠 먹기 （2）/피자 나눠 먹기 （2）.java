class Solution {
    public int solution(int n) {
        int pizza = 1;
        
        while((pizza*6)%n != 0){
            pizza++;
        }
        
        return pizza;
    }
}