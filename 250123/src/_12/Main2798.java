package _12;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

// 2798 블랙잭
public class Main2798 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄 : 카드의 개수 N과 M 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 두 번째 줄 : 카드의 숫자들 입력받기
        int[] cards = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        // 최적의 합을 찾기 위해 탐색
        int maxSum = 0;

        // 3중 루프를 이용해 모든 조합 탐색
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    int sum = cards[i] + cards[j] + cards[k];
                    // 조건 : M을 넘지 않으면서 최대값
                    if (sum <= M && sum > maxSum) { 
                        maxSum = sum;
                    }
                }
            }
        }

        System.out.println(maxSum);
    }
}
