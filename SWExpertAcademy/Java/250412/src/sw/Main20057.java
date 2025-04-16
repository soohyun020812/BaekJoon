package sw;
import java.io.*;
import java.util.*;

// 20057 마법사 상어와 토네이도 
public class Main20057 {
	static int N, answer;
    static int[][] map;

    // 좌, 하, 우, 상
    static int[] dx = {0, 1, 0, -1}; 
    static int[] dy = {-1, 0, 1, 0};

    static int[][][] sandSpreads = {
        {   // 왼쪽
        	// dx
        	{-1, 1, -1, 1, -2, 2, -1, 1, 0}, 
        	// dy
        	{1, 1, 0, 0, 0, 0, -1, -1, -2},   
        	// 퍼센트
        	{1, 1, 7, 7, 2, 2, 10, 10, 5}    
        },
        {   // 아래
            {-1, -1, 0, 0, 0, 0, 1, 1, 2},
            {-1, 1, -1, 1, -2, 2, -1, 1, 0},
            {1, 1, 7, 7, 2, 2, 10, 10, 5}
        },
        {   // 오른쪽
            {-1, 1, -1, 1, -2, 2, -1, 1, 0},
            {-1, -1, 0, 0, 0, 0, 1, 1, 2},
            {1, 1, 7, 7, 2, 2, 10, 10, 5}
        },
        {   // 위
            {1, 1, 0, 0, 0, 0, -1, -1, -2},
            {-1, 1, -1, 1, -2, 2, -1, 1, 0},
            {1, 1, 7, 7, 2, 2, 10, 10, 5}
        }
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        simulate();
        System.out.println(answer);
    }

    static void simulate() {
        int x = N / 2;
        int y = N / 2;

        int len = 1;
        int dir = 0;

        while (true) {
            for (int d = 0; d < 2; d++) {
                for (int i = 0; i < len; i++) {
                    x += dx[dir];
                    y += dy[dir];

                    spreadSand(x, y, dir);
                    if (x == 0 && y == 0) return;
                }
                dir = (dir + 1) % 4;
            }
            len++;
        }
    }

    static void spreadSand(int x, int y, int dir) {
        int[][] info = sandSpreads[dir];
        int total = map[x][y];
        int spreadSum = 0;

        for (int i = 0; i < 9; i++) {
            int nx = x + info[0][i];
            int ny = y + info[1][i];
            int percent = info[2][i];

            int spread = (total * percent) / 100;
            spreadSum += spread;

            if (isInside(nx, ny)) {
                map[nx][ny] += spread;
            } else {
                answer += spread;
            }
        }

        // α 자리
        int ax = x + dx[dir];
        int ay = y + dy[dir];
        int remaining = total - spreadSum;

        if (isInside(ax, ay)) {
            map[ax][ay] += remaining;
        } else {
            answer += remaining;
        }

        map[x][y] = 0;
    }

    static boolean isInside(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }
}
