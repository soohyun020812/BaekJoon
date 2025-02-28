package bfs;
import java.io.*;
import java.util.*;

public class Main2178 {
	static int N, M;
    static int[][] maze;
    static int[][] distance;
    static boolean[][] visited;
    // 상하좌우 이동
    static int[] dx = {0, 0, -1, 1}; 
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // N, M 입력
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new int[N][M];
        visited = new boolean[N][M];

        // 미로 입력
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0, 0));
    }

    static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        // 거리 저장 배열
        int[][] distance = new int[N][M]; 
        // 시작점 거리
        distance[x][y] = 1; 

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int curX = pos[0];
            int curY = pos[1];

            // 4방향 탐색
            for (int d = 0; d < 4; d++) {
                int nx = curX + dx[d];
                int ny = curY + dy[d];

                // 미로 범위 내 & 방문 X & 이동 가능(1)
                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (!visited[nx][ny] && maze[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        distance[nx][ny] = distance[curX][curY] + 1;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
        
        // 도착 위치의 거리 값 반환
        return distance[N-1][M-1]; 
    }
}
