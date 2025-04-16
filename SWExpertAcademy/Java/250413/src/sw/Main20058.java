package sw;
import java.io.*;
import java.util.*;

// 20058 마법사 상어와 파이어스톰 
public class Main20058 {
	// 전역 변수 선언
	static int N, Q, size;
    static int[][] grid;
    // 상하좌우 방향
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N과 Q 입력
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        // 2^N 크기의 격자
        size = 1 << N;

        grid = new int[size][size];

        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int[] levels = new int[Q];
        for (int i = 0; i < Q; i++) {
            levels[i] = Integer.parseInt(st.nextToken());
        }

        // 각 단계마다 파이어스톰 시전
        for (int l : levels) {
        	// 모든 블록 회전
            rotateAll(1 << l);
            // 얼음 녹이기 
            melt();
        }

        System.out.println(getIceSum());
        System.out.println(getLargestChunk());
    }

    // 모든 블록을 회전시키는 함수 
    static void rotateAll(int len) {
        int[][] newGrid = new int[size][size];
        for (int r = 0; r < size; r += len) {
            for (int c = 0; c < size; c += len) {
                rotateBlock(r, c, len, newGrid);
            }
        }
        grid = newGrid;
    }

    // 하나의 블록을 시계 방향으로 90도 회전 
    static void rotateBlock(int r, int c, int len, int[][] newGrid) {
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                newGrid[r + j][c + len - 1 - i] = grid[r + i][c + j];
            }
        }
    }

    static void melt() {
        int[][] temp = new int[size][size];
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (grid[r][c] == 0) continue;

                int count = 0;
                // 상하좌우 얼음이 있는 칸 세기 
                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if (inBounds(nr, nc) && grid[nr][nc] > 0) {
                        count++;
                    }
                }
                // 얼음 있는 칸이 3개 미만이면 얼음 줄임
                if (count < 3) temp[r][c] = grid[r][c] - 1;
                else temp[r][c] = grid[r][c];
            }
        }
        // 새로 계산한 값으로 갱신 
        grid = temp;
    }

    static boolean inBounds(int r, int c) {
        return r >= 0 && r < size && c >= 0 && c < size;
    }

    static int getIceSum() {
        int sum = 0;
        for (int[] row : grid) {
            for (int val : row) {
                sum += val;
            }
        }
        return sum;
    }

    // 가장 큰 얼음 덩어리 크기 구하기 (BFS)
    static int getLargestChunk() {
        boolean[][] visited = new boolean[size][size];
        int maxSize = 0;

        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (!visited[r][c] && grid[r][c] > 0) {
                    int chunkSize = bfs(r, c, visited);
                    maxSize = Math.max(maxSize, chunkSize);
                }
            }
        }

        return maxSize;
    }

    // 연결된 얼음 덩어리 크기 계산 
    static int bfs(int sr, int sc, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});
        visited[sr][sc] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0], c = cur[1];

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (inBounds(nr, nc) && !visited[nr][nc] && grid[nr][nc] > 0) {
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc});
                    count++;
                }
            }
        }

        return count;
    }
}
