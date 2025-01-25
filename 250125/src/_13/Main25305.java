package _13;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

// 25305 커트라인
public class Main25305 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄 입력 : N과 k
        String[] input = br.readLine().split(" ");
        // 응시자의 수
        int N = Integer.parseInt(input[0]); 
        // 상을 받는 사람의 수
        int k = Integer.parseInt(input[1]); 

        // 두 번째 줄 입력 : 학생들의 점수
        String[] scoreInput = br.readLine().split(" ");
        int[] scores = new int[N];

        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(scoreInput[i]);
        }

        // 점수를 내림차순으로 정렬
        Arrays.sort(scores);

        // 커트라인 점수 계산 (내림차순이므로 N-k 번째 인덱스의 값)
        int cutoff = scores[N - k];

        System.out.println(cutoff);
    }
}
