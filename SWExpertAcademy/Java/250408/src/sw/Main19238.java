package sw;
import java.io.*;
import java.util.*;

// 19238 스타트 택시 
public class Main19238 {
	static int N, M, fuel;
    static int[][] map;
    static boolean[][] visited;
    static int taxiX, taxiY;
    static final int[] dx = {-1, 0, 0, 1};
    static final int[] dy = {0, -1, 1, 0};

    static class Passenger {
        int startX, startY, endX, endY;

        Passenger(int startX, int startY, int endX, int endY) {
            this.startX = startX;
            this.startY = startY;
            this.endX = endX;
            this.endY = endY;
        }
    }

    static List<Passenger> passengers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // N, M, 초기 연료
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        fuel = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        // 지도 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 택시 시작 위치
        st = new StringTokenizer(br.readLine());
        taxiX = Integer.parseInt(st.nextToken()) - 1;
        taxiY = Integer.parseInt(st.nextToken()) - 1;

        // 승객 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken()) - 1;
            int sy = Integer.parseInt(st.nextToken()) - 1;
            int ex = Integer.parseInt(st.nextToken()) - 1;
            int ey = Integer.parseInt(st.nextToken()) - 1;
            passengers.add(new Passenger(sx, sy, ex, ey));
        }

        for (int i = 0; i < M; i++) {
            int[] result = findNearestPassenger();
            int px = result[0], py = result[1], distToPassenger = result[2], idx = result[3];
            if (idx == -1 || fuel < distToPassenger) {
                System.out.println(-1);
                return;
            }

            fuel -= distToPassenger;
            taxiX = px;
            taxiY = py;

            Passenger p = passengers.get(idx);
            int distToDestination = moveToDestination(p.endX, p.endY);

            if (distToDestination == -1 || fuel < distToDestination) {
                System.out.println(-1);
                return;
            }

            fuel += distToDestination;
            taxiX = p.endX;
            taxiY = p.endY;

            passengers.remove(idx);
        }

        System.out.println(fuel);
    }

    // 승객까지 최단거리 탐색
    static int[] findNearestPassenger() {
        visited = new boolean[N][N];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{taxiX, taxiY, 0});
        visited[taxiX][taxiY] = true;

        List<int[]> candidates = new ArrayList<>();
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], dist = cur[2];

            for (int i = 0; i < passengers.size(); i++) {
                Passenger p = passengers.get(i);
                if (p.startX == x && p.startY == y) {
                    candidates.add(new int[]{x, y, dist, i});
                }
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (inRange(nx, ny) && !visited[nx][ny] && map[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny, dist + 1});
                }
            }
        }

        if (candidates.isEmpty()) return new int[]{-1, -1, -1, -1};

        candidates.sort((a, b) -> {
        	// 거리 우선
            if (a[2] != b[2]) return a[2] - b[2]; 
            // 행 우선
            if (a[0] != b[0]) return a[0] - b[0]; 
            // 열 우선
            return a[1] - b[1]; 
        });

        return candidates.get(0);
    }

    // 목적지까지 이동
    static int moveToDestination(int destX, int destY) {
        visited = new boolean[N][N];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{taxiX, taxiY, 0});
        visited[taxiX][taxiY] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], dist = cur[2];
            if (x == destX && y == destY) return dist;

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (inRange(nx, ny) && !visited[nx][ny] && map[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny, dist + 1});
                }
            }
        }

        // 도달 불가능
        return -1; 
    }

    static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}
