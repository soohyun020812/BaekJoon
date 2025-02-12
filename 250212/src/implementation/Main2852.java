package implementation;
import java.io.*;
import java.util.*;

// 2852 NBA 농구 
public class Main2852 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 골이 들어간 횟수 N 
        int N = Integer.parseInt(br.readLine()); 
        
        // 각 팀의 점수
        int score1 = 0, score2 = 0; 
        // 각 팀이 이기고 있던 시간
        int team1Time = 0, team2Time = 0; 
        // 이전 골이 들어간 시간
        int lastTime = 0; 
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            // 득점한 팀 번호 (1 또는 2)
            int team = Integer.parseInt(st.nextToken()); 
            // 득점 시간 분리 (MM:SS)
            String[] timeParts = st.nextToken().split(":"); 
            // 초 단위로 변환
            int currentTime = Integer.parseInt(timeParts[0]) * 60 + Integer.parseInt(timeParts[1]); 
            
            // 이전까지 이기고 있던 팀의 시간을 업데이트
            if (score1 > score2) {
                team1Time += currentTime - lastTime;
            } else if (score2 > score1) {
                team2Time += currentTime - lastTime;
            }
            
            // 현재 골을 득점한 팀의 점수 증가
            if (team == 1) {
                score1++;
            } else {
                score2++;
            }
            
            // 마지막 득점 시간 업데이트
            lastTime = currentTime; 
        }
        
        // 경기가 끝날 때까지 이기고 있는 팀의 시간 추가
        if (score1 > score2) {
            team1Time += 48 * 60 - lastTime;
        } else if (score2 > score1) {
            team2Time += 48 * 60 - lastTime;
        }
        
        // MM:SS 형식 변환 후 출력
        System.out.println(formatTime(team1Time));
        System.out.println(formatTime(team2Time));
    }
    
    // 초 단위 시간을 MM:SS 형식으로 변환하는 함수
    private static String formatTime(int timeInSeconds) {
        int minutes = timeInSeconds / 60;
        int seconds = timeInSeconds % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }
}
