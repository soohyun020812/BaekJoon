package sw;
import java.io.*;
import java.util.*;

// 마법사 상어와 비바라기 
public class Main21610 {
	static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static List<int[]> clouds;

    // 방향 배열 (←, ↖, ↑, ↗, →, ↘, ↓, ↙)
    static int[] dr = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dc = {-1, -1, 0, 1, 1, 1, 0, -1};

    // 대각선 방향 (↖, ↗, ↘, ↙)
    static int[] diagR = {-1, -1, 1, 1};
    static int[] diagC = {-1, 1, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 격자 크기 N, 이동 명령 수 M
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 바구니의 물 양을 저장하는 2차원 배열
        map = new int[N][N];

        // 바구니 초기 상태 입력 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 초기 구름 위치 설정
        clouds = new ArrayList<>();
        clouds.add(new int[]{N - 1, 0});
        clouds.add(new int[]{N - 1, 1});
        clouds.add(new int[]{N - 2, 0});
        clouds.add(new int[]{N - 2, 1});

        // M번의 이동 명령 처리
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            // 방향
            int d = Integer.parseInt(st.nextToken()) - 1;
            // 거리
            int s = Integer.parseInt(st.nextToken());

            moveClouds(d, s);
            rain();
            waterCopy();
            makeNewClouds();
        }

        // 모든 이동이 끝난 후, 물의 총합 계산
        int answer = 0;
        for (int[] row : map) {
            for (int water : row) {
                answer += water;
            }
        }

        System.out.println(answer);
    }

    private static void rain() {
		// TODO Auto-generated method stub
		
	}

	// 구름 이동 처리
    static void moveClouds(int d, int s) {
        List<int[]> newClouds = new ArrayList<>();
        visited = new boolean[N][N];

        for (int[] cloud : clouds) {
            int r = (cloud[0] + dr[d] * s % N + N) % N;
            int c = (cloud[1] + dc[d] * s % N + N) % N;

            // 비를 내리고, 해당 칸을 방문 처리
            map[r][c]++;
            visited[r][c] = true;
            newClouds.add(new int[]{r, c});
        }

        // 새 구름 리스트 업데이트
        clouds = newClouds;
    }

    // 물복사 버그 처리
    static void waterCopy() {
        for (int[] cloud : clouds) {
            int count = 0;
            for (int d = 0; d < 4; d++) {
                int nr = cloud[0] + diagR[d];
                int nc = cloud[1] + diagC[d];
                if (isInBounds(nr, nc) && map[nr][nc] > 0) {
                    count++;
                }
            }
            map[cloud[0]][cloud[1]] += count;
        }
    }

    // 새로운 구름 만들기
    static void makeNewClouds() {
        List<int[]> newClouds = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 이전에 구름이 없었고, 물의 양이 2 이상일 때만 구름 생성
                if (!visited[i][j] && map[i][j] >= 2) {
                    map[i][j] -= 2;
                    newClouds.add(new int[]{i, j});
                }
            }
        }
        clouds = newClouds;
    }

    // 범위 체크 함수
    static boolean isInBounds(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }
}
