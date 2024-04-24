package sw;
import java.io.*;
import java.util.*;

// 19236 청소년 상어 
public class Main19236 {
	// 물고기 클래스 정의
    static class Fish {
        int x, y, dir;
        boolean alive;
        public Fish(int x, int y, int dir, boolean alive) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.alive = alive;
        }
    }

    // 공간의 상태를 저장하는 배열
    static int[][] grid = new int[4][4]; 
    // 물고기 정보를 저장하는 배열, 1~16번 물고기
    static Fish[] fishes = new Fish[17]; 
    // 8방향 (↑, ↖, ←, ↙, ↓, ↘, →, ↗)
    static int[] dx = {-1,-1,0,1,1,1,0,-1}; 
    static int[] dy = {0,-1,-1,-1,0,1,1,1};
    // 상어가 먹을 수 있는 최대 점수
    static int maxScore = 0; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 입력 데이터 처리
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                int num = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken()) - 1;
                fishes[num] = new Fish(i, j, dir, true);
                grid[i][j] = num;
            }
        }
        
        // 상어가 (0,0) 위치의 물고기를 먹고 시작
        int startFish = grid[0][0];
        int startDir = fishes[startFish].dir;
        fishes[startFish].alive = false;
        // 상어의 위치 표시
        grid[0][0] = -1; 
        
        dfs(0, 0, startDir, startFish);
        System.out.println(maxScore);
    }
    
    // DFS - 상어 이동 및 최댓값 갱신
    static void dfs(int sx, int sy, int sDir, int score) {
        maxScore = Math.max(maxScore, score);
        
        // 상태 백업을 위한 배열
        int[][] backupGrid = new int[4][4]; 
        // 물고기 상태 백업
        Fish[] backupFishes = new Fish[17]; 
        copyState(backupGrid, backupFishes);
        
        // 물고기 이동
        moveFishes(); 
        
        // 상어 이동 시도
        for (int step = 1; step < 4; step++) {
            int nx = sx + dx[sDir] * step;
            int ny = sy + dy[sDir] * step;
            
            if (!isValid(nx, ny) || grid[nx][ny] <= 0) continue;
            
            int fishNum = grid[nx][ny];
            int nextDir = fishes[fishNum].dir;
            
            // 현재 위치를 비우고 상어 이동
            grid[sx][sy] = 0;
            grid[nx][ny] = -1;
            fishes[fishNum].alive = false;
            
            dfs(nx, ny, nextDir, score + fishNum);
            
            // 원래 상태로 복구
            grid[sx][sy] = -1;
            grid[nx][ny] = fishNum;
            fishes[fishNum].alive = true;
        }
        
        // 상태 복원
        restoreState(backupGrid, backupFishes); 
    }
    
    // 물고기 이동 처리
    static void moveFishes() {
        for (int i = 1; i <= 16; i++) {
            if (!fishes[i].alive) continue;
            int x = fishes[i].x, y = fishes[i].y, d = fishes[i].dir;
            
            // 8방향 회전하며 이동 가능 위치 탐색
            for (int j = 0; j < 8; j++) {
                int nd = (d + j) % 8;
                int nx = x + dx[nd], ny = y + dy[nd];
                
                if (!isValid(nx, ny) || grid[nx][ny] == -1) continue;
                
                swapFish(i, x, y, nx, ny, nd);
                break;
            }
        }
    }
    
    // 물고기 위치 변경
    static void swapFish(int num, int x, int y, int nx, int ny, int nd) {
        if (grid[nx][ny] > 0) {
            int otherNum = grid[nx][ny];
            fishes[otherNum].x = x;
            fishes[otherNum].y = y;
            grid[x][y] = otherNum;
        } else {
            grid[x][y] = 0;
        }
        
        fishes[num].x = nx;
        fishes[num].y = ny;
        fishes[num].dir = nd;
        grid[nx][ny] = num;
    }
    
    // 좌표 유효성 검사
    static boolean isValid(int x, int y) {
        return x >= 0 && x < 4 && y >= 0 && y < 4;
    }
    
    // 현재 상태 복사
    static void copyState(int[][] backupGrid, Fish[] backupFishes) {
        for (int i = 0; i < 4; i++) {
            backupGrid[i] = grid[i].clone();
        }
        for (int i = 1; i <= 16; i++) {
            backupFishes[i] = new Fish(fishes[i].x, fishes[i].y, fishes[i].dir, fishes[i].alive);
        }
    }
    
    // 백업된 상태 복원
    static void restoreState(int[][] backupGrid, Fish[] backupFishes) {
        for (int i = 0; i < 4; i++) {
            grid[i] = backupGrid[i].clone();
        }
        for (int i = 1; i <= 16; i++) {
            fishes[i] = backupFishes[i];
        }
    }
}
