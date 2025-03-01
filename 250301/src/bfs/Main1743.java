package bfs;
import java.io.*;
import java.util.*;

// 1743 음식물 피하기 
public class Main1743 {
	static int N, M, K;
    static int[][] grid;
    static boolean[][] visited;
    // 상하좌우 이동
    static int[] dx = {-1, 1, 0, 0}; 
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        grid = new int[N][M];
        visited = new boolean[N][M];

        // 음식물 위치 입력
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            // 음식물 표시
            grid[r][c] = 1; 
        }

        int maxSize = 0;
        // 모든 위치에서 BFS 실행
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    maxSize = Math.max(maxSize, bfs(i, j));
                }
            }
        }

        System.out.println(maxSize);
    }

    static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        int size = 1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (grid[nx][ny] == 1 && !visited[nx][ny]) {
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        size++;
                    }
                }
            }
        }
        
        return size;
    }
}
