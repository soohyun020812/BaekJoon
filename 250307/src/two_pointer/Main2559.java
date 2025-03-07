package two_pointer;
import java.io.*;
import java.util.*;

// 2559 수열 
public class Main2559 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] temp = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            temp[i] = Integer.parseInt(st.nextToken());
        }

        // 초기 K일 합 구하기
        int sum = 0;
        for (int i = 0; i < K; i++) {
            sum += temp[i];
        }

        // 최댓값 저장
        int maxSum = sum; 

        // 슬라이딩 윈도우 이동
        for (int i = K; i < N; i++) {
        	// 윈도우 이동 (왼쪽 값 빼고, 오른쪽 값 추가)
            sum = sum - temp[i - K] + temp[i]; 
            // 최댓값 갱신
            maxSum = Math.max(maxSum, sum); 
        }

        System.out.println(maxSum);
    }
}
