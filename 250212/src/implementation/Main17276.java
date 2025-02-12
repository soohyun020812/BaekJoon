package implementation;
import java.io.*;
import java.util.*;

// 17276 배열 돌리기
public class Main17276 {
    static int T, n, d;
    static int[][] grid, copy;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        T = Integer.parseInt(br.readLine());

        while(T --> 0) {
            st = new StringTokenizer(br.readLine(), " ");
            // 배열 크기 (n x n, n은 홀수)
            n = Integer.parseInt(st.nextToken());
            // 회전 각도 (45의 배수)
            d = Integer.parseInt(st.nextToken());
            
            // 원본 배열
            grid = new int[n][n];
            // 변경된 값 저장할 배열
            copy = new int[n][n];
 
            for(int i = 0 ; i < n ; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int j = 0 ; j < n ; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());
                    copy[i][j] = grid[i][j];
                }
            }
            
            // 각도 조정 (음수 각도 처리 포함)
            if(d < 0) d += 360;
            if(d >= 360) d -= 360;
            
            // 45도 회전 횟수 계산
            int cnt = d / 45;
            // 회전 횟수만큼 회전 수행
            while(cnt --> 0) {
                rotate();
            }
            
            // 회전한 결과 출력하기
            for(int[] i : grid) {
                for(int j : i) {
                    sb.append(j + " ");
                }
                sb.append("\n");
            }
        }
        
        System.out.println(sb);
    }
    
    // 45도 회전하는 함수
    private static void rotate() {
        for(int i = 0 ; i < n ; i++) {
            // 1. 주 대각선(\)을 가운데 열(|)로 옮김
            copy[i][n / 2] = grid[i][i];
            // 2. 가운데 열(|)을 부 대각선(/)으로 옮김
            copy[n - 1 - i][i] = grid[n - 1 - i][n / 2];
            // 3. 부 대각선(/)을 가운데 행(-)으로 옮김
            copy[n / 2][i] = grid[n - 1 - i][i];
            // 4. 가운데 행(-)을 주 대각선(\)으로 옮김
            copy[i][i] = grid[n / 2][i];
        }
        
        // 45도 회전한 결과 원본 배열에 반영
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                grid[i][j] = copy[i][j];
            }
        }
    }
}
