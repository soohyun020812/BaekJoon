package prefix_sum;
import java.io.*;
import java.util.*;

// 2015 수들의 합 4
public class Main2015 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 배열 길이
        int N = Integer.parseInt(st.nextToken()); 
        // 목표 부분합
        long K = Long.parseLong(st.nextToken()); 

        // 입력 배열
        st = new StringTokenizer(br.readLine());
        long[] A = new long[N];
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }

        // 누적합 + 등장 횟수 저장할 HashMap
        Map<Long, Integer> prefixSumMap = new HashMap<>();
        // 현재 누적합
        long prefixSum = 0; 
        // 부분합이 K인 경우의 수
        long count = 0; 

        // 초기값 설정, 누적합이 0인 경우를 대비
        prefixSumMap.put(0L, 1);

        // 누적 합 계산
        for (int i = 0; i < N; i++) {
        	// 누적 합 업데이트
        	prefixSum += A[i]; 

            // (prefixSum - K)가 존재하면 그 개수만큼 정답에 추가
            count += prefixSumMap.getOrDefault(prefixSum - K, 0);

            // 현재 누적 합을 HashMap에 추가
            prefixSumMap.put(prefixSum, prefixSumMap.getOrDefault(prefixSum, 0) + 1);
        }

        System.out.println(count);
    }
}
