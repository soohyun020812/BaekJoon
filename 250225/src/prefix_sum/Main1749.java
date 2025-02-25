package prefix_sum;
import java.io.*;
import java.util.*;

// 1749 점수따먹기 
public class Main1749 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 행의 개수
        int N = Integer.parseInt(st.nextToken()); 
        // 열의 개수
        int M = Integer.parseInt(st.nextToken()); 
        int[][] matrix = new int[N][M];

        // 행렬 입력 
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 최대 부분합 변수
        int maxSum = Integer.MIN_VALUE;

        // 왼쪽 열(left)부터 오른쪽 열(right)까지 확장하는 방식
        for (int left = 0; left < M; left++) {
        	// 해당 열 범위에서 각 행의 합을 저장하는 배열
        	int[] temp = new int[N]; 

            for (int right = left; right < M; right++) {
                // temp 배열에 현재 열(right)을 추가한 누적합 생성
                for (int i = 0; i < N; i++) {
                    temp[i] += matrix[i][right];
                }

                // 1D 배열에서 Kadane's Algorithm을 이용하여 최대 부분합을 구함
                int currentMax = kadane(temp);
                maxSum = Math.max(maxSum, currentMax);
            }
        }

        System.out.println(maxSum);
    }

	// Kadane's Algorithm (카데인 알고리즘)
    // 1차원 배열에서 최대 연속 부분합을 찾는 Kadane's Algorithm
    private static int kadane(int[] arr) {
    	// 최댓값 저장 변수, 초기값은 가장 작은 정수
        int maxSum = Integer.MIN_VALUE;
        // 현재 부분합을 저장하는 변수
        int currentSum = 0;

        for (int num : arr) {
        	// 현재 값(num)과 기존 부분합 + 현재 값 중 더 큰 값을 선택하여 부분합 갱신
            currentSum = Math.max(num, currentSum + num);
            // 현재까지의 최댓값 갱신
            maxSum = Math.max(maxSum, currentSum);
        }

        // 최대 연속 부분합 반환
        return maxSum;
    }
}
