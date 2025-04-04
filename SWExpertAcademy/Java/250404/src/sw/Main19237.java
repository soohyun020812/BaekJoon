package sw;
import java.io.*;
import java.util.*;

// 19237 어른 상어 
public class Main19237 {
	// 격자 크기 (N x N), 상어 수 (M)
	static int N, M; 
	// 현재 시간 (t), 냄새 지속 시간 (k)
	static int t, k; 
	// 격자 내 상어 정보
	static int[][] water; 
	// 상어별 이동 우선순위
	static int[][][] dir; 
	// 냄새 정보 (상어 번호, 남은 시간)    
	static int[][][] smell; 
	// 각 상어의 현재 방향
	static int[] D; 
	// 방향 이동 배열 (상하좌우)
	static int[] dx = {0, -1, 1, 0, 0}; 
    static int[] dy = {0, 0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        water = new int[N][N];
        // 냄새 정보 초기화
        smell = new int[N][N][2]; 
        
        // 격자 정보 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            for (int j = 0; j < N; j++) {
                water[i][j] = Integer.parseInt(st.nextToken());
                // 상어가 있는 경우 냄새 설정
                if (water[i][j] > 0) { 
                    smell[i][j][0] = water[i][j];
                    smell[i][j][1] = k;
                }
            }
        }
        
        // 상어들의 초기 방향 입력
        D = new int[M + 1];
        st = new StringTokenizer(bf.readLine(), " ");
        for (int i = 1; i <= M; i++) {
            D[i] = Integer.parseInt(st.nextToken());
        }
        
        // 각 상어의 방향 우선순위 입력
        dir = new int[M + 1][5][5];
        for (int i = 1; i <= M; i++) {
            for (int d = 1; d <= 4; d++) {
                st = new StringTokenizer(bf.readLine(), " ");
                for (int u = 1; u <= 4; u++) {
                    dir[i][d][u] = Integer.parseInt(st.nextToken());
                }
            }
        }
        
        // 시뮬레이션 실행
        for (t = 1; t <= 1001; t++) {
            if (t == 1001) break;
            // 상어 이동
            move(); 
            // 상어가 한 마리 남으면 종료
            if (M == 1) break; 
        }
        
        // 1000초 초과 시 -1 출력
        if (t == 1001) t = -1; 
        System.out.println(t);
    }

    static void move() {
    	// 새로운 격자 정보 저장 배열
    	int[][] tmp = new int[N][N]; 
    	// 새로운 냄새 저장
    	ArrayDeque<int[]> newsmell = new ArrayDeque<>(); 
        
        // 모든 상어 이동
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
            	// 상어가 없는 칸은 무시
                if (water[i][j] == 0) continue; 
                
                // 현재 상어 번호
                int s = water[i][j]; 
                // 이동할 위치와 방향
                int mx = N, my = N, md = 0; 
                
                // 상어의 이동 우선순위 탐색
                for (int d = 1; d <= 4; d++) {
                    int ni = i + dx[dir[s][D[s]][d]];
                    int nj = j + dy[dir[s][D[s]][d]];
                    
                    // 이동 가능한 범위 확인
                    if (ni < 0 || nj < 0 || ni >= N || nj >= N) continue;
                    if (smell[ni][nj][0] != s && smell[ni][nj][1] >= t) continue;
                    
                    // 빈 공간 발견 시 바로 이동 결정
                    if (smell[ni][nj][1] < t) {
                        mx = ni; my = nj; md = dir[s][D[s]][d];
                        break;
                    }
                    // 자신의 냄새가 있는 곳이면 후보로 저장, 최초 발견된 방향 유지
                    else if (smell[ni][nj][0] == s && mx == N) {
                        mx = ni; my = nj; md = dir[s][D[s]][d];
                    }
                }
                
                // 이동 후 해당 위치에 상어 배치 및 충돌 처리
                if (tmp[mx][my] == 0) {
                    tmp[mx][my] = water[i][j];
                    newsmell.offer(new int[]{mx, my, s, t + k});
                // 작은 번호의 상어만 남음
                } else if (tmp[mx][my] > water[i][j]) { 
                    tmp[mx][my] = water[i][j];
                    M--;
                    newsmell.offer(new int[]{mx, my, s, t + k});
                } else {
                	// 큰 번호의 상어는 제거됨
                    M--; 
                }
                
                // 상어의 새로운 방향 저장
                D[s] = md; 
            }
        }
        
        // 새로운 냄새 정보를 격자에 반영
        while (!newsmell.isEmpty()) {
            int[] n = newsmell.poll();
            // 상어 번호
            smell[n[0]][n[1]][0] = n[2]; 
            // 냄새 지속 시간
            smell[n[0]][n[1]][1] = n[3]; 
        }
        
        // 격자 정보 업데이트
        water = tmp; 
    }
}
