package sw;
import java.io.*;
import java.util.*;

// 17822 원판 돌리기 
public class Main17822 {
	// 원판 개수(N), 원판 내 숫자 개수(M), 회전 횟수(T)
	static int N, M, T; 
	// 원판을 저장하는 2차원 배열
	static int[][] board; 
	// 상하좌우 이동을 위한 배열
	static int[] dx = {0, 0, -1, 1}; 
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        
        board = new int[N][M];
        
        // 원판 값 입력 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // T번의 회전 수행
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            
            rotateDisks(x, d, k);
            if (!removeAdjacent()) {
                adjustNumbers();
            }
        }
        
        // 최종 원판 숫자들의 합 출력
        System.out.println(getSum());
    }
    
	// @param x 회전할 원판의 배수
	// @param d 회전 방향 (0 : 시계방향, 1 : 반시계방향)
	// @param k 회전 횟수
    static void rotateDisks(int x, int d, int k) {
        for (int i = x - 1; i < N; i += x) {
            int[] temp = new int[M];
            for (int j = 0; j < M; j++) {
                int newIdx = (d == 0) ? (j + k) % M : (j - k + M) % M;
                temp[newIdx] = board[i][j];
            }
            board[i] = temp;
        }
    }

	// 인접한 숫자를 제거하는 메서드
    // @return 제거된 숫자가 있는 경우 true, 없으면 false
    static boolean removeAdjacent() {
        boolean[][] toRemove = new boolean[N][M];
        boolean found = false;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0) continue;
                
                for (int d = 0; d < 4; d++) {
                    int ni = i + dx[d];
                    int nj = (j + dy[d] + M) % M;
                    
                    if (ni >= 0 && ni < N && board[ni][nj] == board[i][j]) {
                        toRemove[i][j] = toRemove[ni][nj] = true;
                        found = true;
                    }
                }
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (toRemove[i][j]) board[i][j] = 0;
            }
        }
        
        return found;
    }
    
	// 인접한 숫자가 없을 때 평균을 기준으로 숫자를 조정하는 메서드
    static void adjustNumbers() {
        int sum = 0, count = 0;
        
        for (int[] row : board) {
            for (int num : row) {
                if (num > 0) {
                    sum += num;
                    count++;
                }
            }
        }
        
        if (count == 0) return;
        
        double avg = (double) sum / count;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0) continue;
                if (board[i][j] > avg) board[i][j]--;
                else if (board[i][j] < avg) board[i][j]++;
            }
        }
    }
    
    // 최종 원판 숫자의 합을 계산하는 메서드
    // @return 남아있는 숫자들의 총합
    static int getSum() {
        int sum = 0;
        for (int[] row : board) {
            for (int num : row) {
                sum += num;
            }
        }
        
        return sum;
    }
}
