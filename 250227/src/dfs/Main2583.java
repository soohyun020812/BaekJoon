package dfs;
import java.io.*;
import java.util.*;

// 2583 영역 구하기 
public class Main2583 {
	// M : 세로 크기, N : 가로 크기, K : 직사각형 개수
	static int M, N, K; 
	// 모눈종이 (0 : 빈 공간, 1 : 직사각형 영역)
	static int[][] map; 
	// 방문 여부를 체크하는 배열
	static boolean[][] visited; 
	// 좌우 이동
	static int[] dx = {0, 0, -1, 1}; 
	// 상하 이동
	static int[] dy = {-1, 1, 0, 0}; 
	// 각 영역의 크기를 저장할 리스트
	static List<Integer> areaList = new ArrayList<>(); 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 세로 길이
        M = Integer.parseInt(st.nextToken()); 
        // 가로 길이
        N = Integer.parseInt(st.nextToken()); 
        // 직사각형 개수
        K = Integer.parseInt(st.nextToken()); 

        // M * N 크기의 모눈종이 배열 생성
        map = new int[M][N]; 
        // 방문 여부 배열 생성
        visited = new boolean[M][N]; 

        // 직사각형 입력 받아서 채우기
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            // 왼쪽 아래 x 좌표
            int x1 = Integer.parseInt(st.nextToken()); 
            // 왼쪽 아래 y 좌표
            int y1 = Integer.parseInt(st.nextToken()); 
            // 오른쪽 위 x 좌표
            int x2 = Integer.parseInt(st.nextToken()); 
            // 오른쪽 위 y 좌표
            int y2 = Integer.parseInt(st.nextToken()); 
            // 직사각형을 1로 채우는 함수 호출
            fillRectangle(x1, y1, x2, y2); 
        }

        // 빈 영역 탐색, DFS 실행
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                // 방문하지 않았고, 직사각형이 아닌 부분(0)이라면 DFS 실행
                if (map[i][j] == 0 && !visited[i][j]) {
                	// DFS 실행 후 결과를 리스트에 저장
                	areaList.add(dfs(i, j)); 
                }
            }
        }

        // 오름차순 정렬 후 결과 출력
        Collections.sort(areaList);
        // 영역 개수 출력
        System.out.println(areaList.size()); 
        for (int area : areaList) {
        	// 영역 크기 출력
            System.out.print(area + " "); 
        }
    }

    // 직사각형을 1로 채우는 함수
    private static void fillRectangle(int x1, int y1, int x2, int y2) {
    	// 세로 범위 (y1 ~ y2-1)
    	for (int i = y1; i < y2; i++) { 
    		// 가로 범위 (x1 ~ x2-1)
            for (int j = x1; j < x2; j++) { 
            	// 직사각형 내부를 1로 설정
            	map[i][j] = 1; 
            }
        }
    }

    // DFS를 사용한 영역 탐색 함수
    private static int dfs(int x, int y) {
    	// 현재 위치 방문 처리
    	visited[x][y] = true; 
    	// 현재 칸 포함하여 넓이 초기화
    	int area = 1; 

        // 4방향 탐색 (상, 하, 좌, 우)
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 모눈종이 범위를 벗어나지 않고, 방문하지 않은 빈 영역(0)이라면 탐색 진행
            if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                if (!visited[nx][ny] && map[nx][ny] == 0) {
                	// 재귀적으로 DFS 수행하여 영역 크기 증가
                	area += dfs(nx, ny); 
                }
            }
        }

        // 탐색한 영역의 크기 반환
        return area; 
    }
}
