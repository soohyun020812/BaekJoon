package sw;
import java.io.*;
import java.util.*;

// 14501 퇴사 
public class Main14501 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        // 상담 기간
        int[] T = new int[N + 1];  
        // 상담 금액
        int[] P = new int[N + 1];  
        // dp 배열, N+1일까지 고려
        int[] dp = new int[N + 2]; 

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        int maxProfit = 0;
        
        for (int i = 1; i <= N; i++) {
        	// 현재까지의 최대 수익 갱신
            maxProfit = Math.max(maxProfit, dp[i]); 

            // 상담이 끝나는 날짜
            int nextDay = i + T[i]; 
            // N+1일을 초과하지 않는 경우
            if (nextDay <= N + 1) { 
                dp[nextDay] = Math.max(dp[nextDay], maxProfit + P[i]);
            }
        }

        System.out.println(Math.max(maxProfit, dp[N+1]));
    }
}
