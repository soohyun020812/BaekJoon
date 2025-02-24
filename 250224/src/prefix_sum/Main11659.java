package prefix_sum;
import java.io.*;
import java.util.*;

// 11659 구간 합 구하기 4 
public class Main11659 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 수의 개수 N, 질의 개수 M 입력
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 원본 배열 및 누적 합 배열 선언
        int[] arr = new int[N + 1];
        int[] prefixSum = new int[N + 1];

        // 수열 입력 및 누적 합 계산
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        // M개의 질의 처리
        for (int q = 0; q < M; q++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            // (i ~ j) 구간 합 계산
            int result = prefixSum[j] - prefixSum[i - 1];
            sb.append(result).append("\n");
        }

        System.out.print(sb);
    }
}
