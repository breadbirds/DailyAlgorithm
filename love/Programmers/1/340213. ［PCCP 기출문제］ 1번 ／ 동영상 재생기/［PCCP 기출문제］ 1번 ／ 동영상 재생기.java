/**
- 기능 : 10초 전 / 10초 후 / 오프닝 건너뛰기
[기능]
- prev : 10초 전으로 이동 : 현재위치에서 10초 전으로. 최소 0분 0초
- next : 10초 후로 이동, 최대 마지막 == 동영상 길이와 같음
- 오프닝 건너뛰기 : 현재 재생 위치가 오프닝 구간(op_start ~ op_end) 일 때, 자동으로 오프닝이 끝나는 시점으로 이동


*/

class Solution {
    
    public static int minuteToSecond(String times){
        String[] time = times.split(":");
        
        return Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
    }
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        
        int s_vedeo_len = minuteToSecond(video_len);
        int s_pos = minuteToSecond(pos);
        int s_op_start = minuteToSecond(op_start);
        int s_op_end = minuteToSecond(op_end);
        
        
        // 0. 사용자 입력만큼 반복한다.
        for(int i=0; i<commands.length; i++){
            
            // 오프닝 구간일 경우 끝나는 시점으로 이동 (이대로 for문을 끝내지 않는 것에 유의)
            if(s_pos >= s_op_start && s_pos <s_op_end){
                s_pos = s_op_end;
            }
            
            // 입력값에 따라 행위
            if(commands[i].equals("next")){
                // next : 10초 이후로 이동
                s_pos = (s_pos + 10) > s_vedeo_len ? s_vedeo_len : (s_pos + 10);
            }else{
                // prev : 10초 이전으로 이동
                s_pos = (s_pos - 10) < 0 ? 0 : (s_pos - 10);
            }
            
            // 오프닝 구간일 경우 끝나는 시점으로 이동 (이대로 for문을 끝내지 않는 것에 유의)
            if(s_pos >= s_op_start && s_pos <s_op_end){
                s_pos = s_op_end;
            }
        }
        
        String minute = String.format("%02d", s_pos/60);
        String second = String.format("%02d", s_pos%60);

        return minute + ":" + second;
    }
}