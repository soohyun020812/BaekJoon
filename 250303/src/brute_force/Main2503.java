package brute_force;
import java.io.*;
import java.util.*;

// 2503 숫자 야구 
public class Main2503 {
	static class Question {
        int number, strike, ball;

        Question(int number, int strike, int ball) {
            this.number = number;
            this.strike = strike;
            this.ball = ball;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 질문 개수
        int N = Integer.parseInt(br.readLine()); 
        List<Question> questions = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());
            questions.add(new Question(number, strike, ball));
        }

        int count = 0;
        for (int num = 123; num <= 987; num++) {
        	// 1~9의 서로 다른 숫자로 이루어진 수인지 확인
        	if (!isValidNumber(num)) continue; 
            if (isPossibleAnswer(num, questions)) count++;
        }

        System.out.println(count);
    }

    // 숫자가 1~9의 서로 다른 숫자로 이루어졌는지 확인하는 함수
    static boolean isValidNumber(int num) {
    	// 백의 자리
    	int a = num / 100;
    	// 십의 자리
    	int b = (num / 10) % 10; 
    	// 일의 자리
    	int c = num % 10;

        return (a != b && b != c && c != a && a > 0 && b > 0 && c > 0);
    }

    // 주어진 질문들을 모두 만족하는지 확인하는 함수
    static boolean isPossibleAnswer(int candidate, List<Question> questions) {
        for (Question q : questions) {
            if (!checkStrikeBall(candidate, q.number, q.strike, q.ball)) return false;
        }
        return true;
    }

    // 두 숫자를 비교하여 스트라이크 & 볼 개수를 체크하는 함수
    static boolean checkStrikeBall(int num1, int num2, int expectedStrike, int expectedBall) {
        int strike = 0, ball = 0;

        int[] digits1 = { num1 / 100, (num1 / 10) % 10, num1 % 10 };
        int[] digits2 = { num2 / 100, (num2 / 10) % 10, num2 % 10 };

        // 스트라이크 & 볼 계산
        for (int i = 0; i < 3; i++) {
            if (digits1[i] == digits2[i]) {
                strike++;
            } else if (digits1[i] == digits2[(i + 1) % 3] || digits1[i] == digits2[(i + 2) % 3]) {
                ball++;
            }
        }

        return (strike == expectedStrike && ball == expectedBall);
    }
}
