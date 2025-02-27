package dfs;
import java.io.*;

// 10026 적록색약 
public class Main10026 {
	static int N;
	// 원본 그림
    static char[][] map; 
    static boolean[][] visited;
    // 상하좌우 이동
    static int[] dx = {0, 0, -1, 1}; 
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        // 그림 입력
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        // 적록색약이 아닌 사람이 볼 때의 영역 개수
        visited = new boolean[N][N];
        int normalCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, map[i][j]);
                    normalCount++;
                }
            }
        }

        // 적록색약이 보는 그림을 위해 R을 G로 변환
        // 방문 배열 초기화
        visited = new boolean[N][N]; 
        int colorBlindCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'R') {
                	// R을 G로 변경
                	map[i][j] = 'G'; 
                }
            }
        }

        // 적록색약이 볼 때의 영역 개수 계산
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, map[i][j]);
                    colorBlindCount++;
                }
            }
        }

        System.out.println(normalCount + " " + colorBlindCount);
    }

    // DFS 탐색
    private static void dfs(int x, int y, char color) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (!visited[nx][ny] && map[nx][ny] == color) {
                    dfs(nx, ny, color);
                }
            }
        }
    }
}
