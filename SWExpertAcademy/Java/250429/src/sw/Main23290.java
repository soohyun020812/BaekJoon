package sw;
import java.io.*;
import java.util.*;

public class Main23290 {
	static int M, S;
	// 각 칸에 방향별 물고기 수
    static int[][][] fishMap = new int[4][4][8]; 
    // 냄새 정보 저장
    static int[][] smell = new int[4][4]; 
    // 상어 위치
    static int sharkX, sharkY; 

    // 물고기 8방향 (←, ↖, ↑, ↗, →, ↘, ↓, ↙)
    static int[] dxFish = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dyFish = {-1, -1, 0, 1, 1, 1, 0, -1};

    // 상어 4방향 (↑, ←, ↓, →)
    static int[] dxShark = {-1, 0, 1, 0};
    static int[] dyShark = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        // 초기 물고기 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int fx = Integer.parseInt(st.nextToken()) - 1;
            int fy = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken()) - 1;
            fishMap[fx][fy][d]++;
        }

        // 상어 위치 입력
        st = new StringTokenizer(br.readLine());
        sharkX = Integer.parseInt(st.nextToken()) - 1;
        sharkY = Integer.parseInt(st.nextToken()) - 1;

        // S번의 반복 실행
        for (int i = 0; i < S; i++) {
        	// 1. 복제 마법 시전 전 상태 저장
            int[][][] clone = cloneFish(); 
            // 2. 모든 물고기 이동
            moveFish(); 
            // 3. 상어 이동 후 물고기 제거 및 냄새 남김
            moveShark(); 
            // 4. 냄새 감소
            reduceSmell(); 
            // 5. 복제 마법 적용
            applyClone(clone); 
        }

        System.out.println(countFish()); 
    }

    // 현재 물고기 상태 복사
    static int[][][] cloneFish() {
        int[][][] clone = new int[4][4][8];
        for (int x = 0; x < 4; x++)
            for (int y = 0; y < 4; y++)
                for (int d = 0; d < 8; d++)
                    clone[x][y][d] = fishMap[x][y][d];
        return clone;
    }

    // 물고기 이동
    static void moveFish() {
        int[][][] newMap = new int[4][4][8];
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                for (int d = 0; d < 8; d++) {
                    int cnt = fishMap[x][y][d];
                    if (cnt == 0) continue;
                    boolean moved = false;
                    // 8방향 탐색 (반시계 방향으로 45도씩 회전)
                    for (int i = 0; i < 8; i++) {
                        int nd = (d - i + 8) % 8;
                        int nx = x + dxFish[nd];
                        int ny = y + dyFish[nd];
                        if (inRange(nx, ny) && smell[nx][ny] == 0 && (nx != sharkX || ny != sharkY)) {
                            newMap[nx][ny][nd] += cnt;
                            moved = true;
                            break;
                        }
                    }
                    // 이동 불가 시 제자리 유지
                    if (!moved) newMap[x][y][d] += cnt; 
                }
            }
        }
        fishMap = newMap;
    }

    // 상어 이동 및 물고기 제거
    static void moveShark() {
        int maxEat = -1;
        int[] bestRoute = new int[3];

        // 3칸 이동 조합을 모두 탐색
        for (int d1 = 0; d1 < 4; d1++) {
            for (int d2 = 0; d2 < 4; d2++) {
                for (int d3 = 0; d3 < 4; d3++) {
                    int x = sharkX;
                    int y = sharkY;
                    int eat = 0;
                    boolean[][] visited = new boolean[4][4];
                    boolean valid = true;
                    int[][] route = {{d1}, {d2}, {d3}};

                    // 상어 이동 경로 시뮬레이션
                    for (int[] dir : route) {
                        x += dxShark[dir[0]];
                        y += dyShark[dir[0]];
                        if (!inRange(x, y)) {
                            valid = false;
                            break;
                        }
                        if (!visited[x][y]) {
                            for (int i = 0; i < 8; i++) eat += fishMap[x][y][i];
                            visited[x][y] = true;
                        }
                    }

                    // 최적 경로 업데이트
                    if (valid && (eat > maxEat || (eat == maxEat && isLexSmaller(bestRoute, new int[]{d1, d2, d3})))) {
                        maxEat = eat;
                        bestRoute = new int[]{d1, d2, d3};
                    }
                }
            }
        }

        // 상어 실제 이동 및 물고기 제거 + 냄새 남김
        for (int d : bestRoute) {
            sharkX += dxShark[d];
            sharkY += dyShark[d];
            if (hasFish(sharkX, sharkY)) {
                Arrays.fill(fishMap[sharkX][sharkY], 0);
                smell[sharkX][sharkY] = 3;
            }
        }
    }

    // 사전순 비교
    static boolean isLexSmaller(int[] current, int[] candidate) {
        for (int i = 0; i < 3; i++) {
            if (candidate[i] < current[i]) return true;
            if (candidate[i] > current[i]) return false;
        }
        return false;
    }

    // 냄새 한 칸씩 줄이기
    static void reduceSmell() {
        for (int x = 0; x < 4; x++)
            for (int y = 0; y < 4; y++)
                if (smell[x][y] > 0) smell[x][y]--;
    }

    // 복제된 물고기 적용
    static void applyClone(int[][][] clone) {
        for (int x = 0; x < 4; x++)
            for (int y = 0; y < 4; y++)
                for (int d = 0; d < 8; d++)
                    fishMap[x][y][d] += clone[x][y][d];
    }

    // 좌표 유효성 검사
    static boolean inRange(int x, int y) {
        return x >= 0 && x < 4 && y >= 0 && y < 4;
    }

    // 해당 위치에 물고기가 있는지 확인
    static boolean hasFish(int x, int y) {
        for (int i = 0; i < 8; i++)
            if (fishMap[x][y][i] > 0) return true;
        return false;
    }

    // 전체 물고기 수 계산
    static int countFish() {
        int sum = 0;
        for (int x = 0; x < 4; x++)
            for (int y = 0; y < 4; y++)
                for (int d = 0; d < 8; d++)
                    sum += fishMap[x][y][d];
        
        return sum;
    }
}
