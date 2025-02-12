package implementation;
import java.io.*;
import java.util.*;

// 9017 크로스 컨트리 
public class Main9017 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); 
        int[] answer = new int[T];
        
        for (int i = 0; i < T; i++) {
        	// 선수의 수
            int N = Integer.parseInt(br.readLine()); 
            // 선수들의 팀 정보
            int[] ranks = new int[N]; 
            // 각 팀의 참가자 수 저장
            Map<Integer, Integer> teamCount = new HashMap<>(); 
            // 존재하는 팀의 최대 번호
            int maxTeamNum = 0; 
            
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                int team = Integer.parseInt(st.nextToken());
                teamCount.put(team, teamCount.getOrDefault(team, 0) + 1);
                ranks[j] = team;
                maxTeamNum = Math.max(maxTeamNum, team);
            }
            
            // 팀별 다섯 번째 주자의 점수 저장
            int[] fifthRunner = new int[maxTeamNum + 1]; 
            // 팀별 총점
            Map<Integer, Integer> teamScores = new HashMap<>(); 
            // 각 팀의 완주자 수
            Map<Integer, Integer> teamRankCount = new HashMap<>(); 
            // 점수 (등수)
            int score = 1; 
            
            for (int team : ranks) {
            	// 팀원이 6명 이상인 경우만 점수 계산
                if (teamCount.get(team) == 6) { 
                    teamRankCount.put(team, teamRankCount.getOrDefault(team, 0) + 1);
                    
                    // 상위 4명의 점수만 합산
                    if (teamRankCount.get(team) <= 4) { 
                        teamScores.put(team, teamScores.getOrDefault(team, 0) + score);
                    }
                    
                    // 다섯 번째 주자의 점수 저장
                    if (teamRankCount.get(team) == 5) { 
                        fifthRunner[team] = score;
                    }
                    score++;
                }
            }
            
            int winningTeam = -1;
            int minScore = Integer.MAX_VALUE;
            int minFifthScore = Integer.MAX_VALUE;
            
            for (Map.Entry<Integer, Integer> entry : teamScores.entrySet()) {
                int team = entry.getKey();
                int totalScore = entry.getValue();
                
                // 점수가 낮은 팀을 우승 후보로 선정
                if (totalScore < minScore) { 
                    minScore = totalScore;
                    minFifthScore = fifthRunner[team];
                    winningTeam = team;
                } else if (totalScore == minScore && fifthRunner[team] < minFifthScore) {
                    // 동점일 경우 다섯 번째 주자의 점수가 낮은 팀이 우승
                    minFifthScore = fifthRunner[team];
                    winningTeam = team;
                }
            }
            
            answer[i] = winningTeam;
        }
        
        for (int result : answer) {
        	
            System.out.println(result);
        }
    }
}
