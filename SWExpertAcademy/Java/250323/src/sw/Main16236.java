package sw;
import java.io.*;
import java.util.*;

// 16236 아기 상어 
public class Main16236 {
	static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    static int sharkX, sharkY, sharkSize = 2, eatCount = 0, time = 0;

    static class Fish implements Comparable<Fish> {
        int x, y, dist;

        public Fish(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(Fish o) {
            if (this.dist == o.dist) {
                if (this.x == o.x) return this.y - o.y;
                return this.x - o.x;
            }
            
            return this.dist - o.dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    sharkX = i;
                    sharkY = j;
                    map[i][j] = 0;
                }
            }
        }

        while (true) {
            Fish fish = bfs();
            if (fish == null) break;
            
            sharkX = fish.x;
            sharkY = fish.y;
            time += fish.dist;
            map[fish.x][fish.y] = 0;
            eatCount++;
            
            if (eatCount == sharkSize) {
                sharkSize++;
                eatCount = 0;
            }
        }
        
        System.out.println(time);
    }

    static Fish bfs() {
        PriorityQueue<Fish> pq = new PriorityQueue<>();
        Queue<int[]> queue = new LinkedList<>();
        visited = new boolean[N][N];

        queue.offer(new int[]{sharkX, sharkY, 0});
        visited[sharkX][sharkY] = true;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1], dist = cur[2];
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny] || map[nx][ny] > sharkSize) continue;
                
                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny, dist + 1});
                
                if (map[nx][ny] > 0 && map[nx][ny] < sharkSize) {
                    pq.offer(new Fish(nx, ny, dist + 1));
                }
            }
        }
        
        return pq.isEmpty() ? null : pq.poll();
    }
}
