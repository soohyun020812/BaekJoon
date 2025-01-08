package four;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

// 1546 평균
public class Main1546 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 과목의 개수 N
        int N = Integer.parseInt(br.readLine());

        // 세준이의 현재 성적 배열 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        double[] scores = new double[N];
        double maxScore = 0;

        // 점수를 배열에 저장하고 최댓값 계산
        for (int i = 0; i < N; i++) {
            scores[i] = Double.parseDouble(st.nextToken());
            if (scores[i] > maxScore) {
                maxScore = scores[i];
            }
        }

        // 점수 조작과 새로운 점수 합 계산
        double newSum = 0;
        for (int i = 0; i < N; i++) {
        	// 점수 조작
            scores[i] = (scores[i] / maxScore) * 100; 
            newSum += scores[i];
        }

        // 새로운 평균 계산
        double newAverage = newSum / N;

        System.out.println(newAverage);
    }
}
