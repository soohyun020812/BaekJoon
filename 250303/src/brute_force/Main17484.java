package brute_force;
import java.io.*;
import java.util.*;

// 17484 진우의 달 여행 (Small)
public class Main17484 {
	static int N, M;
    static int[][] fuel;
    // dp[row][col][direction]
    static int[][][] dp; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        fuel = new int[N][M];
        // DP 배열
        dp = new int[N][M][3]; 

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                fuel[i][j] = Integer.parseInt(st.nextToken());
                // DP 배열 초기화
                Arrays.fill(dp[i][j], Integer.MAX_VALUE); 
            }
        }

        // 첫 번째 행 초기화
        for (int j = 0; j < M; j++) {
            dp[0][j][0] = fuel[0][j];
            dp[0][j][1] = fuel[0][j];
            dp[0][j][2] = fuel[0][j];
        }

        // DP 진행
        for (int row = 1; row < N; row++) {
            for (int col = 0; col < M; col++) {
            	// 왼쪽 대각선 방향 (이전 이동이 1, 2)
            	if (col > 0) { 
                    dp[row][col][0] = Math.min(dp[row - 1][col - 1][1], dp[row - 1][col - 1][2]) + fuel[row][col];
                }
                // 아래 방향 (이전 이동이 0, 2)
                dp[row][col][1] = Math.min(
                        (col > 0 ? dp[row - 1][col][0] : Integer.MAX_VALUE),
                        (col < M - 1 ? dp[row - 1][col][2] : Integer.MAX_VALUE)
                ) + fuel[row][col];

                // 오른쪽 대각선 방향 (이전 이동이 0, 1)
                if (col < M - 1) { 
                    dp[row][col][2] = Math.min(dp[row - 1][col + 1][0], dp[row - 1][col + 1][1]) + fuel[row][col];
                }
            }
        }

        // 마지막 행에서 최소 연료량 찾기
        int minFuel = Integer.MAX_VALUE;
        for (int col = 0; col < M; col++) {
            for (int dir = 0; dir < 3; dir++) {
                minFuel = Math.min(minFuel, dp[N - 1][col][dir]);
            }
        }

        System.out.println(minFuel);
    }
}
