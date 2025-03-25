package sw;
import java.util.*;

// 17144 미세먼지 안녕!
public class Main17143 {
	// 상어 정보를 저장
    static class Shark {
    	// 행, 열, 속력, 이동 방향, 크기
    	int r, c, s, d, z; 
        public Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }

    // 격자 크기(R, C), 상어 수(M), 잡은 상어 크기의 총합(totalSize)
    static int R, C, M, totalSize = 0;
    static Shark[][] map;
    // 이동 방향 배열
    // 1 : 위, 2 : 아래, 3 : 오른쪽, 4 : 왼쪽
    static int[] dx = {0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        M = sc.nextInt();
        map = new Shark[R + 1][C + 1];

        // 상어 정보를 입력받아 배열에 저장
        for (int i = 0; i < M; i++) {
            int r = sc.nextInt(), c = sc.nextInt(), s = sc.nextInt(), d = sc.nextInt(), z = sc.nextInt();
            // 상하 이동 속도 조정
            if (d == 1 || d == 2) s %= (R - 1) * 2; 
            // 좌우 이동 속도 조정
            else s %= (C - 1) * 2; 
            map[r][c] = new Shark(r, c, s, d, z);
        }

        // 낚시왕이 왼쪽에서 오른쪽으로 이동하며 상어를 잡고 이동
        for (int col = 1; col <= C; col++) {
            catchShark(col); // 상어 잡기
            moveSharks(); // 상어 이동
        }

        System.out.println(totalSize); // 잡은 상어 크기의 총합 출력
        sc.close();
    }

    // 낚시왕이 현재 열에서 가장 가까운 상어를 잡는 메서드
    static void catchShark(int col) {
        for (int row = 1; row <= R; row++) {
        	// 상어가 존재하면 잡기
        	if (map[row][col] != null) { 
        		// 잡은 상어 크기 누적
        		totalSize += map[row][col].z; 
        		// 해당 위치에서 상어 제거
        		map[row][col] = null; 
                
        		return;
            }
        }
    }

    // 상어 이동 메서드
    static void moveSharks() {
        Shark[][] newMap = new Shark[R + 1][C + 1];
        
        for (int r = 1; r <= R; r++) {
            for (int c = 1; c <= C; c++) {
            	// 상어가 존재하면 이동
            	if (map[r][c] != null) { 
                    Shark shark = map[r][c];
                    int nr = r, nc = c, speed = shark.s, dir = shark.d;
                    
                    // 주어진 속력만큼 이동
                    for (int i = 0; i < speed; i++) {
                        // 경계를 벗어나면 방향 전환
                        if (nr + dx[dir] < 1 || nr + dx[dir] > R || nc + dy[dir] < 1 || nc + dy[dir] > C) {
                            dir = (dir % 2 == 0) ? dir - 1 : dir + 1;
                        }
                        nr += dx[dir];
                        nc += dy[dir];
                    }

                    // 이동한 위치에 상어가 없거나 더 큰 상어가 있으면 갱신
                    if (newMap[nr][nc] == null || newMap[nr][nc].z < shark.z) {
                        newMap[nr][nc] = new Shark(nr, nc, shark.s, dir, shark.z);
                    }
                }
            }
        }

        // 새로운 맵을 기존 맵으로 업데이트
        map = newMap; 
    }
}
