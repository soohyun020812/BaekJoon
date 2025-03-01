package bfs;
import java.io.*;
import java.util.*;

// 7576 토마토 
public class Main7576 {
	static int N, M;
    static int[][] box;
    static boolean[][] visited;
    // 상하좌우 이동
    static int[] dx = {-1, 1, 0, 0}; 
    static int[] dy = {0, 0, -1, 1};
    
    static class Point {
        int x, y, day;
        Point(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        box = new int[N][M];
        visited = new boolean[N][M];
        Queue<Point> queue = new LinkedList<>();

        // 입력 처리 & BFS 시작점 찾기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                // 익은 토마토는 BFS 시작점
                if (box[i][j] == 1) { 
                    queue.add(new Point(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }

        int maxDay = 0;
        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            maxDay = Math.max(maxDay, cur.day);

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                	// 익지 않은 토마토 익히기
                	if (box[nx][ny] == 0 && !visited[nx][ny]) { 
                        queue.add(new Point(nx, ny, cur.day + 1));
                        // 익은 토마토로 변경
                        box[nx][ny] = 1; 
                        visited[nx][ny] = true;
                    }
                }
            }
        }

        // 안 익은 토마토(0)가 남아있는지 확인
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0) {
                	
                    System.out.println(-1);

                    return;
                }
            }
        }

        System.out.println(maxDay);
    }
}
