package brute_force;
import java.io.*;

// 15721 번데기 
public class Main15721 {
	static int A, T, target;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 게임을 진행하는 사람 수
        A = Integer.parseInt(br.readLine()); 
        // 찾을 T번째 구호
        T = Integer.parseInt(br.readLine()); 
        // 찾을 구호 (0 = "뻔", 1 = "데기")
        target = Integer.parseInt(br.readLine()); 

        System.out.println(playGame());
    }

    static int playGame() {
    	// "뻔"과 "데기"의 누적 횟수
    	int countB = 0, countD = 0; 
    	// 게임 진행 회차
    	int gameRound = 2; 
    	// 현재 외치는 사람 (0번부터 시작)
    	int person = 0; 

        while (true) {
            // 기본 패턴 : "뻔 - 데기 - 뻔 - 데기"
            for (int i = 0; i < 4; i++) {
            	// "뻔"
            	if (i % 2 == 0) { 
                    countB++;
                    if (countB == T && target == 0) return person;
                // "데기"
            	} else { 
                    countD++;
                    if (countD == T && target == 1) return person;
                }
            	// 다음 사람으로 이동
                person = (person + 1) % A; 
            }

            // 추가 "뻔(n번)"
            for (int i = 0; i < gameRound; i++) {
                countB++;
                if (countB == T && target == 0) return person;
                person = (person + 1) % A;
            }

            // 추가 "데기(n번)"
            for (int i = 0; i < gameRound; i++) {
                countD++;
                if (countD == T && target == 1) return person;
                person = (person + 1) % A;
            }

            // 다음 회차로 진행
            gameRound++; 
        }
    }
}
