package sw;
import java.io.*;
import java.util.*;

// 14503 로봇 청소기 
public class Main14503 {
	static int N, M;
    static int[][] room;
    static boolean[][] cleaned;
    static int r, c, d;
    static int count = 0;

    // 북, 동, 남, 서 방향 - 반시계 방향으로 회전
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 방 크기 입력
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        room = new int[N][M];
        cleaned = new boolean[N][M];

        // 로봇 청소기 초기 위치 및 방향
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        // 방의 상태 입력 
        // 0 : 빈칸, 1 : 벽
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 청소 시작
        clean();

        System.out.println(count);
    }

    static void clean() {
        while (true) {
            // 1. 현재 위치 청소
            if (!cleaned[r][c]) {
                cleaned[r][c] = true;
                count++;
            }

            // 2. 청소할 공간 있는지 확인을 위해 4방향 탐색
            boolean hasCleaned = false;
            for (int i = 0; i < 4; i++) {
            	// 반시계 방향 회전
            	d = (d + 3) % 4; 
                int nx = r + dx[d];
                int ny = c + dy[d];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M && room[nx][ny] == 0 && !cleaned[nx][ny]) {
                    // 청소할 공간이 있으면 이동 후 청소 진행
                    r = nx;
                    c = ny;
                    hasCleaned = true;
                    break;
                }
            }

            // 3. 네 방향 모두 청소가 되어있거나 벽이라면 후진
            if (!hasCleaned) {
                int backDir = (d + 2) % 4;
                int bx = r + dx[backDir];
                int by = c + dy[backDir];

                // 후진 가능하면 이동, 불가능하면 종료
                if (room[bx][by] == 0) {
                    r = bx;
                    c = by;
                } else {
                    break;
                }
            }
        }
    }
}
