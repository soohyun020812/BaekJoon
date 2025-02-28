package bfs;
import java.io.*;
import java.util.*;

// 1012 유기농 배추 
public class Main1012 {
	static int T, M, N, K;
    static int[][] field;
    static boolean[][] visited;
    // 상하좌우 이동
    static int[] dx = {0, 0, -1, 1}; 
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            // 가로 길이
            M = Integer.parseInt(st.nextToken()); 
            // 세로 길이
            N = Integer.parseInt(st.nextToken()); 
            // 배추 개수
            K = Integer.parseInt(st.nextToken()); 

            field = new int[M][N];
            visited = new boolean[M][N];

            // 배추 위치 저장
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                field[x][y] = 1;
            }

            // BFS 실행하여 연결된 배추 그룹 개수 찾기
            int wormCount = 0;
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (field[i][j] == 1 && !visited[i][j]) {
                        bfs(i, j);
                        wormCount++;
                    }
                }
            }

            System.out.println(wormCount);
        }
    }

    // BFS 탐색
    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int curX = pos[0];
            int curY = pos[1];

            // 4방향 탐색
            for (int d = 0; d < 4; d++) {
                int nx = curX + dx[d];
                int ny = curY + dy[d];

                if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
                    if (field[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
