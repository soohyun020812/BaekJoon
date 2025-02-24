package prefix_sum;
import java.io.*;
import java.util.*;

// 11660 구간 합 구하기 5 
public class Main11660 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 표의 크기 N, 질의 개수 M 입력
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 원본 배열 및 누적 합 배열 선언
        int[][] arr = new int[N + 1][N + 1];
        int[][] prefixSum = new int[N + 1][N + 1];

        // 표 입력 및 누적 합 계산
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] 
                                - prefixSum[i - 1][j - 1] + arr[i][j];
            }
        }

        // M개의 질의 처리
        for (int q = 0; q < M; q++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            // (x1, y1) ~ (x2, y2) 구간 합 계산
            int result = prefixSum[x2][y2] - prefixSum[x1 - 1][y2] 
                       - prefixSum[x2][y1 - 1] + prefixSum[x1 - 1][y1 - 1];
            sb.append(result).append("\n");
        }

        System.out.print(sb);
    }
}
