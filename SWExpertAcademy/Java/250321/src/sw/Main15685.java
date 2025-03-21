package sw;
import java.io.*;
import java.util.*;

// 15685 드래곤 커브 
public class Main15685 {
	// 드래곤 커브가 있는 좌표 표시
	static boolean[][] grid = new boolean[101][101]; 
	// 오른쪽, 위쪽, 왼쪽, 아래쪽 방향
	static int[] dx = {1, 0, -1, 0}; 
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            drawDragonCurve(x, y, d, g);
        }

        System.out.println(countSquares());
    }

    // 드래곤 커브를 그리는 함수
    static void drawDragonCurve(int x, int y, int d, int g) {
        List<Integer> directions = new ArrayList<>();
        directions.add(d);
        // 시작점 표시
        grid[y][x] = true; 

        // 세대별 방향 리스트 생성
        for (int i = 0; i < g; i++) {
            for (int j = directions.size() - 1; j >= 0; j--) {
            	// 90도 회전
                directions.add((directions.get(j) + 1) % 4); 
            }
        }

        // 방향에 따라 이동
        for (int dir : directions) {
            x += dx[dir];
            y += dy[dir];
            if (x >= 0 && x <= 100 && y >= 0 && y <= 100) {
                grid[y][x] = true;
            }
        }
    }

    // 정사각형 개수 세기
    static int countSquares() {
        int count = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (grid[i][j] && grid[i+1][j] && grid[i][j+1] && grid[i+1][j+1]) {
                    count++;
                }
            }
        }
        
        return count;
    }
}
