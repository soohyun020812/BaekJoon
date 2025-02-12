package implementation;
import java.io.*;

// 1913 달팽이 
public class Main1913 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // N 홀수 자연수
        int N = Integer.parseInt(br.readLine()); 
        // 찾을 숫자 입력
        int target = Integer.parseInt(br.readLine()); 

        // 달팽이 배열
        int[][] matrix = new int[N][N]; 
        // 시작 위치 (좌상단)
        int x = 0, y = 0; 
        // 채울 숫자 (최대값부터 시작)
        int num = N * N; 
        // 찾을 숫자의 좌표
        int targetX = 0, targetY = 0; 

        // 하, 우, 상, 좌 이동
        int[] dx = {1, 0, -1, 0}; 
        int[] dy = {0, 1, 0, -1};
        // 현재 방향 (하)
        int dir = 0; 
        
        while (num > 0) {
            matrix[x][y] = num;
            // 찾고자 하는 숫자의 위치 저장
            if (num == target) { 
                targetX = x + 1;
                targetY = y + 1;
            }
            num--;
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            if (nx < 0 || nx >= N || ny < 0 || ny >= N || matrix[nx][ny] != 0) {
            	// 방향 전환
            	dir = (dir + 1) % 4; 
                nx = x + dx[dir];
                ny = y + dy[dir];
            }
            x = nx;
            y = ny;
        }
        
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(matrix[i][j]).append(" ");
            }
            sb.append("\n");
        }
        // 찾은 좌표 출력
        sb.append(targetX).append(" ").append(targetY); 

        System.out.println(sb);
    }
}
