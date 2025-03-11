package greedy;
import java.io.*;
import java.util.*;

// 11047 동전 0 
public class Main11047 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 동전 개수
        int N = Integer.parseInt(st.nextToken());  
        // 목표 금액
        int K = Integer.parseInt(st.nextToken());  

        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        // 큰 가치 동전부터 사용
        for (int i = N - 1; i >= 0; i--) {
            if (K >= coins[i]) {
            	// 필요한 동전 개수 추가
                count += K / coins[i];  
                // 남은 금액 갱신
                K %= coins[i];
            }
        }

        System.out.println(count);
    }
}
