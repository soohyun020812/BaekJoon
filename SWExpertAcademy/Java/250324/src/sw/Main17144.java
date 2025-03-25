package sw;
import java.util.*;

// 17144 미세먼지 안녕!
public class Main17144 {
	// 방 크기 (R x C) 및 실행 시간 T
	static int R, C, T; 
	// 현재 미세먼지 상태를 저장할 배열
	static int[][] map; 
	// 확산 후 미세먼지 상태를 저장할 배열
	static int[][] temp; 
	// 공기청정기의 위치 (행 번호 저장)
	static int[] airCleaner; 

    // 상, 하, 좌, 우 방향 이동을 위한 배열
    static int[] dx = {-1, 1, 0, 0}; 
    static int[] dy = {0, 0, -1, 1}; 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 행 개수
        R = sc.nextInt(); 
        // 열 개수
        C = sc.nextInt(); 
        // 작동 시간
        T = sc.nextInt(); 
        map = new int[R][C];
        // 공기청정기 위치 저장
        airCleaner = new int[2]; 
        
        // 공기청정기 위치 저장을 위한 인덱스
        int acIndex = 0; 
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
            	// 방 정보 입력
                map[i][j] = sc.nextInt(); 
                // 공기청정기 위치 저장
                if (map[i][j] == -1) { 
                    airCleaner[acIndex++] = i;
                }
            }
        }

        // T초 동안 미세먼지 확산 및 공기청정기 작동 반복
        while (T-- > 0) {
        	// 미세먼지 확산
            spreadDust(); 
            // 공기청정기 작동
            operateAirCleaner(); 
        }
        
        // 최종 남아있는 미세먼지 총합 출력
        System.out.println(getTotalDust()); 
        
        sc.close();
    }

    // 미세먼지 확산을 담당하는 메서드
    static void spreadDust() {
    	// 확산된 먼지를 저장할 임시 배열
    	temp = new int[R][C]; 

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
            	// 미세먼지가 있는 경우
            	if (map[i][j] > 0) { 
            		// 확산되는 먼지 양
            		int spreadAmount = map[i][j] / 5; 
            		// 확산된 방향 개수
            		int spreadCount = 0; 
            		
            		// 네 방향으로 확산 시도            		
                    for (int d = 0; d < 4; d++) { 
                        int nx = i + dx[d];
                        int ny = j + dy[d];

                        // 범위를 벗어나지 않고, 공기청정기가 없는 경우 확산
                        if (nx >= 0 && nx < R && ny >= 0 && ny < C && map[nx][ny] != -1) {
                            temp[nx][ny] += spreadAmount;
                            spreadCount++;
                        }
                    }
                    
                    // 남은 먼지 양 추가
                    temp[i][j] += map[i][j] - (spreadAmount * spreadCount); 
                }
            }
        }

        // 확산된 결과를 기존 맵에 반영
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
            	// 공기청정기 위치는 유지
            	if (map[i][j] != -1) { 
                    map[i][j] = temp[i][j];
                }
            }
        }
    }

    // 공기청정기 작동을 담당하는 메서드
    static void operateAirCleaner() {
    	// 위쪽 공기청정기
    	int upper = airCleaner[0]; 
    	// 아래쪽 공기청정기
    	int lower = airCleaner[1]; 

        // 위쪽 공기청정기 (반시계 방향 순환)
        for (int i = upper - 1; i > 0; i--) map[i][0] = map[i - 1][0];
        for (int i = 0; i < C - 1; i++) map[0][i] = map[0][i + 1];
        for (int i = 0; i < upper; i++) map[i][C - 1] = map[i + 1][C - 1];
        for (int i = C - 1; i > 1; i--) map[upper][i] = map[upper][i - 1];
        // 공기청정기에서 나온 바람은 먼지를 제거함
        map[upper][1] = 0; 

        // 아래쪽 공기청정기 (시계 방향 순환)
        for (int i = lower + 1; i < R - 1; i++) map[i][0] = map[i + 1][0];
        for (int i = 0; i < C - 1; i++) map[R - 1][i] = map[R - 1][i + 1];
        for (int i = R - 1; i > lower; i--) map[i][C - 1] = map[i - 1][C - 1];
        for (int i = C - 1; i > 1; i--) map[lower][i] = map[lower][i - 1];
        // 공기청정기에서 나온 바람은 먼지를 제거함
        map[lower][1] = 0; 
    }

    // 방 안에 남아있는 미세먼지의 총합을 계산하는 메서드
    static int getTotalDust() {
        int total = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
            	// 미세먼지만 더함
                if (map[i][j] > 0) total += map[i][j]; 
            }
        }
        
        return total;
    }
}
