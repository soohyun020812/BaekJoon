package sw;
import java.io.*;
import java.util.*;

// 15683 감시 
public class Main15683 {
	static int N, M, minBlindSpot = Integer.MAX_VALUE;
    static int[][] office;
    static List<int[]> cctvs = new ArrayList<>();
    
    // 우, 하, 좌, 상 방향 이동 
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    // CCTV 방향 설정, 각 CCTV가 가질 수 있는 방향의 경우의 수
    static int[][][] directions = {
        {}, 
        // 1번 CCTV
        {{0}, {1}, {2}, {3}}, 
        // 2번 CCTV
        {{0, 2}, {1, 3}}, 
        // 3번 CCTV
        {{0, 1}, {1, 2}, {2, 3}, {3, 0}}, 
        // 4번 CCTV
        {{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}},  
        // 5번 CCTV
        {{0, 1, 2, 3}} 
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        office = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                office[i][j] = Integer.parseInt(st.nextToken());
                if (1 <= office[i][j] && office[i][j] <= 5) {
                    cctvs.add(new int[]{i, j, office[i][j]});
                }
            }
        }

        // 백트래킹 시작
        dfs(0, office);
        
        // 최소 사각지대 
        System.out.println(minBlindSpot);
    }

    // 백트래킹을 이용한 CCTV 방향 설정
    static void dfs(int depth, int[][] board) {
        if (depth == cctvs.size()) {
            // 모든 CCTV 설정 후 사각지대 개수 계산
            minBlindSpot = Math.min(minBlindSpot, countBlindSpots(board));
            
            return;
        }

        int[] cctv = cctvs.get(depth);
        int x = cctv[0], y = cctv[1], type = cctv[2];

        for (int[] direction : directions[type]) {
        	// 새로운 배열 복사
            int[][] newBoard = copyBoard(board); 
            for (int d : direction) {
                mark(newBoard, x, y, d);
            }
            dfs(depth + 1, newBoard);
        }
    }

    // 특정 방향으로 감시 영역 표시
    static void mark(int[][] board, int x, int y, int d) {
        int nx = x, ny = y;
        while (true) {
            nx += dx[d];
            ny += dy[d];
            if (nx < 0 || ny < 0 || nx >= N || ny >= M || board[nx][ny] == 6) break;
            // 감시 영역 표시
            if (board[nx][ny] == 0) board[nx][ny] = -1; 
        }
    }

    // 사각지대 개수 계산
    static int countBlindSpots(int[][] board) {
        int count = 0;
        for (int[] row : board) {
            for (int cell : row) {
                if (cell == 0) count++;
            }
        }
        
        return count;
    }

    // 2차원 배열 복사
    static int[][] copyBoard(int[][] board) {
        int[][] newBoard = new int[N][M];
        for (int i = 0; i < N; i++) {
            newBoard[i] = board[i].clone();
        }
        
        return newBoard;
    }
}
