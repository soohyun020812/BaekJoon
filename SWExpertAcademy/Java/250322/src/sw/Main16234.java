package sw;
import java.io.*;
import java.util.*;

// 16234 인구 이동 
public class Main16234 {
	// 땅의 크기(N)와 인구 이동 조건 (L, R)
	static int N, L, R;
	// 각 나라의 인구 수를 저장하는 배열
	static int[][] map; 
	// 방문 여부를 확인하는 배열
	static boolean[][] visited; 
	// 이동 방향 (좌, 우, 상, 하)
	static int[] dx = {0, 0, -1, 1}; 
    static int[] dy = {-1, 1, 0, 0}; 
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 입력 값 초기화
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 인구 이동이 발생한 날짜 수
        int days = 0; 
        while (true) {
        	// 방문 여부 초기화
        	visited = new boolean[N][N]; 
        	// 인구 이동이 발생했는지 여부
        	boolean moved = false; 
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        // BFS를 통해 연합을 찾고 인구 이동을 수행
                        if (bfs(i, j)) {
                            moved = true;
                        }
                    }
                }
            }
            
            // 더 이상 인구 이동이 없으면 종료
            if (!moved) break; 
            // 하루 증가
            days++; 
        }
        
        System.out.println(days); 
    }
    
    static boolean bfs(int x, int y) {
    	// BFS 탐색을 위한 큐
        Queue<int[]> queue = new LinkedList<>(); 
        // 연합을 이루는 국가 리스트
        List<int[]> union = new ArrayList<>(); 
        
        queue.add(new int[]{x, y});
        union.add(new int[]{x, y});
        visited[x][y] = true;
        
        // 연합의 총 인구 수
        int sum = map[x][y]; 
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0], cy = cur[1];
            
            // 네 방향 탐색
            for (int i = 0; i < 4; i++) { 
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
                	// 인구 차이 계산
                	int diff = Math.abs(map[cx][cy] - map[nx][ny]); 
                	// 국경선을 열 조건 확인
                	if (diff >= L && diff <= R) { 
                        queue.add(new int[]{nx, ny});
                        union.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        // 연합 인구 수 갱신
                        sum += map[nx][ny]; 
                    }
                }
            }
        }
        
        // 연합이 형성되지 않으면 종료
        if (union.size() == 1) return false; 
        
        // 새로운 인구 계산 (소수점 버림)
        int newPopulation = sum / union.size(); 
        for (int[] pos : union) {
        	// 인구 이동 반영
            map[pos[0]][pos[1]] = newPopulation; 
        }
        
        // 인구 이동 발생
        return true; 
    }
}
