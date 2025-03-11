package greedy;
import java.io.*;
import java.util.*;

// 20300 서강근육맨 
public class Main20300 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 운동기구 개수
        int N = Integer.parseInt(br.readLine());  
        
        // 근손실 배열
        long[] loss = new long[N];  
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            loss[i] = Long.parseLong(st.nextToken());
        }

        // 정렬
        Arrays.sort(loss);  
        
        long minM = 0;
        // N이 홀수일 때 - 가장 큰 값을 혼자 사용
        if (N % 2 == 1) {  
            minM = loss[N - 1];
            // 나머지 짝수 개수 처리
            N--;  
        }

        for (int i = 0; i < N / 2; i++) {
            minM = Math.max(minM, loss[i] + loss[N - 1 - i]);
        }

        System.out.println(minM);
    }
}
