package dfs;
import java.io.*;
import java.util.*;

// 2667 단지번호붙이기 
public class Main2667 {
	static int N;
    static int[][] map;
    static boolean[][] visited;
    // 상하좌우
    static int[] dx = {-1, 1, 0, 0}; 
    static int[] dy = {0, 0, -1, 1};
    // 단지 내 집 개수
    static int houseCount; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 지도 크기
        N = Integer.parseInt(br.readLine()); 
        map = new int[N][N];
        visited = new boolean[N][N];

        // 지도 입력 받기
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
            	// 문자에서 숫자 변환
                map[i][j] = line.charAt(j) - '0'; 
            }
        }

        List<Integer> complexSizes = new ArrayList<>();
        // 총 단지 개수
        int complexCount = 0; 

        // 모든 위치 탐색하여 단지 찾기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                	// 단지 크기 초기화
                	houseCount = 0; 
                    dfs(i, j);
                    complexSizes.add(houseCount);
                    complexCount++;
                }
            }
        }

        // 오름차순 정렬
        Collections.sort(complexSizes); 
        System.out.println(complexCount);
        for (int size : complexSizes) {
            System.out.println(size);
        }
    }

    // DFS 탐색, 상하좌우
    private static void dfs(int x, int y) {
        visited[x][y] = true;
        // 현재 단지 내 집 개수 증가
        houseCount++; 

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (map[nx][ny] == 1 && !visited[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }
}
