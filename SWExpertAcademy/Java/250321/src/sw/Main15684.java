package sw;
import java.io.*;
import java.util.*;

// 15684 사다리 조작 
public class Main15684 {
	static int N, M, H;
    static boolean[][] ladder;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        ladder = new boolean[H + 1][N + 1];

        // 기존 가로선 추가
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ladder[a][b] = true;
        }

        // 백트래킹 실행, 0~3개의 추가 가로선으로 시도
        for (int i = 0; i <= 3; i++) {
            dfs(0, i);
            // 최소 개수 찾으면 종료
            if (result != Integer.MAX_VALUE) break; 
        }

        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    // 백트래킹으로 가로선 추가
    static void dfs(int depth, int maxDepth) {
        if (depth == maxDepth) {
            if (checkLadder()) {
                result = Math.min(result, depth);
            }
            
            return;
        }

        // 가능한 모든 위치에 가로선 추가 시도
        for (int i = 1; i <= H; i++) {
            for (int j = 1; j < N; j++) {
                // 가로선 추가 가능 여부 확인
                if (!ladder[i][j] && !ladder[i][j - 1] && !ladder[i][j + 1]) {
                    ladder[i][j] = true;
                    dfs(depth + 1, maxDepth);
                    // 백트래킹, 원상 복구
                    ladder[i][j] = false; 
                }
            }
        }
    }

    // 사다리 결과 검사
    static boolean checkLadder() {
        for (int start = 1; start <= N; start++) {
            int line = start;
            for (int i = 1; i <= H; i++) {
            	// 오른쪽 이동
                if (ladder[i][line]) line++; 
                // 왼쪽 이동
                else if (ladder[i][line - 1]) line--; 
            }
            // i번이 i로 끝나야 함
            if (line != start) return false; 
        }
        
        return true;
    }
}
