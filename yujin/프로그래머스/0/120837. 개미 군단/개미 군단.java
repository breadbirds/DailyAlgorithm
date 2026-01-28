class Solution {
    public int solution(int hp) {
        int answer = 0;
        
        // 장군 5 병정 3 일 1
        // 최소 병력
        
        int a = 5;
        int b = 3;
        int c = 1;
        
        int yheochi = hp;
        
        answer += yheochi/a;
        yheochi = yheochi%a;
        
        System.out.print(yheochi + answer);
        
        answer += yheochi/b;
        yheochi = yheochi%b;
        
        System.out.print(yheochi + answer);
        
        answer += yheochi/c;
        yheochi = yheochi%c;
        
        System.out.print(yheochi + answer);
        
        return answer;
    }
}