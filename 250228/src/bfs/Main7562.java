package bfs;
import java.io.*;
import java.util.*;

// 7562 나이트의 이동 
public class Main7562 {
	// 체스판 크기
	static int l; 
    static int[][] board;
    static boolean[][] visited;
    // 나이트 이동 방향
    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2}; 
    static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine()); 

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
        	// 체스판 크기
            l = Integer.parseInt(br.readLine()); 
            board = new int[l][l];
            visited = new boolean[l][l];

            // 시작 위치
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            // 목표 위치
            st = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            // BFS 실행
            sb.append(bfs(startX, startY, endX, endY)).append("\n");
        }
        
        System.out.print(sb);
    }

    static int bfs(int startX, int startY, int endX, int endY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY, 0});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int x = pos[0];
            int y = pos[1];
            int moveCount = pos[2];

            // 목표 위치 도착 시 이동 횟수 반환
            if (x == endX && y == endY) return moveCount;

            // 8가지 방향으로 이동
            for (int d = 0; d < 8; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                // 체스판 범위 내, 방문하지 않은 곳만 이동
                if (nx >= 0 && ny >= 0 && nx < l && ny < l && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, moveCount + 1});
                }
            }
        }
        
        // 도달 불가능한 경우, 허나 문제 조건상 발생하지 않음
        return -1; 
    }
}
