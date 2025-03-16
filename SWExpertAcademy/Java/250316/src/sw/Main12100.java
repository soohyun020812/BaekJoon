package sw;
import java.io.*;
import java.util.*;

// 12100 2048 (Easy)
public class Main12100 {
	static int N, max = 0;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, board);
        System.out.println(max);
    }

    // DFS로 최대 5번 이동하며 탐색
    static void dfs(int depth, int[][] board) {
        if (depth == 5) {
            max = Math.max(max, getMax(board));
            return;
        }

        // 4방향 이동 (상, 하, 좌, 우)
        for (int i = 0; i < 4; i++) {
            int[][] nextBoard = move(i, board);
            dfs(depth + 1, nextBoard);
        }
    }

    // 보드에서 가장 큰 값 찾기
    static int getMax(int[][] board) {
        int maxVal = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                maxVal = Math.max(maxVal, board[i][j]);
            }
        }
        return maxVal;
    }

    // 보드 이동 로직
    static int[][] move(int dir, int[][] board) {
        int[][] newBoard = new int[N][N];

        for (int i = 0; i < N; i++) {
            int[] line = new int[N];
            int idx = (dir == 0 || dir == 2) ? 0 : N - 1;
            int last = 0;

            for (int j = 0; j < N; j++) {
                int x = (dir == 0) ? j : (dir == 1) ? N - 1 - j : i;
                int y = (dir == 2) ? j : (dir == 3) ? N - 1 - j : i;
                int value = board[x][y];

                if (value == 0) continue;

                if (last == value) {
                    line[idx - ((dir == 0 || dir == 2) ? 1 : -1)] *= 2;
                    last = 0;
                } else {
                    line[idx] = value;
                    last = value;
                    idx += (dir == 0 || dir == 2) ? 1 : -1;
                }
            }

            for (int j = 0; j < N; j++) {
                int x = (dir == 0) ? j : (dir == 1) ? N - 1 - j : i;
                int y = (dir == 2) ? j : (dir == 3) ? N - 1 - j : i;
                newBoard[x][y] = line[j];
            }
        }

        return newBoard;
    }
}
