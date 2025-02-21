package data_structure;
import java.io.*;
import java.util.*;

// 3190 뱀 
public class Main3190 {
	// 보드 크기, 사과 개수, 방향 전환 횟수
	static int N, K, L; 
	// 보드 정보를 저장할 배열
    static int[][] board; 
 // 방향 전환 정보를 저장할 맵
    static Map<Integer, Character> directions; 
    // 이동 방향 (우, 하, 좌, 상)
    static int[] dx = {0, 1, 0, -1}; 
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 보드 크기 입력
        N = Integer.parseInt(br.readLine());
        // 1-based index 
        board = new int[N + 1][N + 1]; 

        // 사과 개수 입력
        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            // 사과가 있는 위치를 1로 표시
            board[r][c] = 1; 
        }

        // 방향 변환 정보 저장
        L = Integer.parseInt(br.readLine());
        directions = new HashMap<>();
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            // 방향 변환 시점
            int X = Integer.parseInt(st.nextToken()); 
            // 'L' 또는 'D'
            char C = st.nextToken().charAt(0); 
            directions.put(X, C);
        }

        System.out.println(startGame());
    }

    /*
     * 뱀의 이동을 처리하는 함수
     * BFS와 Deque를 활용하여 뱀의 움직임을 관리
     * 매초마다 머리를 이동시키고, 충돌 여부를 검사
     */
    
    public static int startGame() {
    	// 뱀의 위치를 저장할 큐
        Deque<int[]> snake = new ArrayDeque<>(); 
        // 뱀의 시작 위치 (1,1)
        snake.offer(new int[]{1, 1}); 
        // 뱀의 몸이 위치한 곳을 저장
        boolean[][] visited = new boolean[N + 1][N + 1]; 
        // 시작 위치 방문 표시
        visited[1][1] = true; 

        // 게임 진행 시간
        int time = 0; 
        // 현재 방향 (0 : 우측)
        int direction = 0; 

        // 뱀의 머리 위치
        int x = 1, y = 1; 

        while (true) {
        	// 1초 증가
        	time++; 
        	// 다음 이동할 위치 (x)
            int nx = x + dx[direction]; 
            // 다음 이동할 위치 (y)
            int ny = y + dy[direction]; 

            // 1 벽 또는 자기 몸과 충돌하면 게임 종료
            if (nx <= 0 || nx > N || ny <= 0 || ny > N || visited[nx][ny]) {
                break;
            }

            // 2 이동한 위치를 뱀의 몸에 추가
            snake.offer(new int[]{nx, ny});
            visited[nx][ny] = true;

            // 3 사과가 없으면 꼬리를 줄임
            if (board[nx][ny] == 1) {
            	// 사과를 먹고 없앰
            	board[nx][ny] = 0; 
            } else {
            	// 꼬리 제거
                int[] tail = snake.poll(); 
                // 꼬리 위치 비우기
                visited[tail[0]][tail[1]] = false; 
            }

            // 4 방향 전환 여부 확인
            if (directions.containsKey(time)) {
                char turn = directions.get(time);
                direction = (turn == 'D') ? (direction + 1) % 4 : (direction + 3) % 4;
                // 'D'는 오른쪽(시계방향), 'L'은 왼쪽(반시계방향) 회전
            }

            // 5 머리 위치 업데이트
            x = nx;
            y = ny;
        }

        return time; 
    }
}
