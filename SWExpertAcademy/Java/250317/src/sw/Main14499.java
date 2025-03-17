package sw;
import java.io.*;
import java.util.*;

// 14499 주사위 굴리기 
public class Main14499 {
	static int N, M, x, y, K;
    static int[][] map;
    // 주사위 
    // 윗면 : dice[0], 아랫면 : dice[5]
    static int[] dice = new int[6]; 
    
    // 동서남북 이동
    // 1 :동, 2 :서, 3 :북, 4 :남
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 지도 세로 크기
        N = Integer.parseInt(st.nextToken()); 
        // 지도 가로 크기
        M = Integer.parseInt(st.nextToken()); 
        // 주사위 초기 위치 x
        x = Integer.parseInt(st.nextToken()); 
        // 주사위 초기 위치 y
        y = Integer.parseInt(st.nextToken()); 
        // 명령 개수
        K = Integer.parseInt(st.nextToken()); 

        // 지도 초기화
        map = new int[N][M]; 

        // 지도 정보 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 명령어 입력 및 실행
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < K; i++) {
        	// 1~4에서 0~3으로 변환
            int dir = Integer.parseInt(st.nextToken()) - 1; 
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            // 지도 밖으로 나가는 경우 무시
            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

            // 주사위 위치 갱신
            x = nx;
            y = ny;
            
            // 주사위 회전
            rollDice(dir);

            // 주사위 바닥면과 지도 동기화
            if (map[x][y] == 0) {
            	// 주사위 바닥면 값이 지도에 복사
                map[x][y] = dice[5]; 
            } else {
            	// 지도 값이 주사위 바닥면으로 복사
            	dice[5] = map[x][y]; 
                map[x][y] = 0;
            }
            
            // 윗면 출력
            sb.append(dice[0]).append("\n"); 
        }

        System.out.print(sb);
    }

    // 주사위 굴리기
    static void rollDice(int dir) {
        int[] temp = dice.clone();

        // 동쪽 (→)
        if (dir == 0) { 
            dice[0] = temp[3];
            dice[2] = temp[0];
            dice[3] = temp[5];
            dice[5] = temp[2];
        // 서쪽 (←)
        } else if (dir == 1) { 
            dice[0] = temp[2];
            dice[2] = temp[5];
            dice[3] = temp[0];
            dice[5] = temp[3];
        // 북쪽 (↑)
        } else if (dir == 2) { 
            dice[0] = temp[4];
            dice[1] = temp[0];
            dice[4] = temp[5];
            dice[5] = temp[1];
        // 남쪽 (↓)
        } else if (dir == 3) { 
            dice[0] = temp[1];
            dice[1] = temp[5];
            dice[4] = temp[0];
            dice[5] = temp[4];
        }
    }
}
