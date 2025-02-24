package prefix_sum;
import java.io.*;
import java.util.*;

// 2167 2차원 배열의 합 
public class Main2167 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 배열 크기 N, M 입력
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 원본 배열 및 누적합 배열 선언
        int[][] arr = new int[N + 1][M + 1];
        int[][] prefixSum = new int[N + 1][M + 1];

        // 배열 값 입력 및 누적합 계산
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                prefixSum[i][j] = arr[i][j] 
                                + prefixSum[i - 1][j] 
                                + prefixSum[i][j - 1] 
                                - prefixSum[i - 1][j - 1];
            }
        }

        // 질의 개수 K 입력
        int K = Integer.parseInt(br.readLine());

        // 각 질의 처리
        for (int q = 0; q < K; q++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // (i, j) ~ (x, y) 범위의 합 계산
            int result = prefixSum[x][y] - prefixSum[x][j - 1] - prefixSum[i - 1][y] + prefixSum[i - 1][j - 1];
            sb.append(result).append("\n");
        }

        System.out.print(sb);
    }
}
