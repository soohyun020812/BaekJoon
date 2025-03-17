package sw;
import java.io.*;
import java.util.*;

// 14500 테트로미노
public class Main14500 {
	static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int maxSum = 0;

    // 상하좌우 이동 
    // 북, 남, 서, 동
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        // 지도 입력 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 모든 좌표에서 DFS 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                // DFS로 탐색할 수 있는 테트로미노
                dfs(i, j, 1, map[i][j]); 
                visited[i][j] = false;
                // ㅗ, ㅜ, ㅏ, ㅓ 모양 확인
                checkExtraShapes(i, j);   
            }
        }

        System.out.println(maxSum);
    }

    // DFS로 4칸 탐색
    static void dfs(int x, int y, int depth, int sum) {
        if (depth == 4) {
            maxSum = Math.max(maxSum, sum);
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny]) continue;

            visited[nx][ny] = true;
            dfs(nx, ny, depth + 1, sum + map[nx][ny]);
            visited[nx][ny] = false;
        }
    }

    // ㅗ, ㅜ, ㅏ, ㅓ 모양 처리 
    // DFS로 탐색 불가
    static void checkExtraShapes(int x, int y) {
        // 4방향의 값을 저장
        int sum = map[x][y];
        int[] values = new int[4];
        int count = 0;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                values[count++] = map[nx][ny];
            }
        }

        // + 모양을 만들기 위해 3개만 선택 
        // 4개일 경우 하나 빼야 함
        if (count == 4) {
            for (int i = 0; i < 4; i++) {
                int tempSum = sum;
                for (int j = 0; j < 4; j++) {
                    if (i != j) tempSum += values[j];
                }
                maxSum = Math.max(maxSum, tempSum);
            }
        } else if (count == 3) {
            maxSum = Math.max(maxSum, sum + values[0] + values[1] + values[2]);
        }
    }
}
