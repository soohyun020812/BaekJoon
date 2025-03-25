package sw;
import java.io.*;
import java.util.*;

// 17142 연구소 3
public class Main17142 {
	// 연구소 크기(N)와 활성 바이러스 개수(M), 빈 공간 개수
	static int N, M, emptySpaces = 0; 
	// 연구소 상태 저장 배열
	static int[][] lab; 
	// 비활성 바이러스 위치 리스트
	static List<int[]> viruses = new ArrayList<>(); 
	// 최소 시간 저장 변수
	static int minTime = Integer.MAX_VALUE; 
	// 상하좌우 이동을 위한 배열    
	static int[] dx = {-1, 1, 0, 0}; 
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 연구소의 크기 N과 놓을 수 있는 바이러스의 개수 M을 입력
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);
        
        lab = new int[N][N];
        
        // 연구소 상태 입력 받기
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                lab[i][j] = Integer.parseInt(line[j]);
                // 바이러스 위치를 viruses 리스트에 추가
                if (lab[i][j] == 2) viruses.add(new int[]{i, j});
                // 빈 칸의 개수 카운트
                else if (lab[i][j] == 0) emptySpaces++;
            }
        }
        
        // 빈 칸이 없으면 0초 출력
        if (emptySpaces == 0) {
            System.out.println(0);
            
            return;
        }
        
        // 바이러스 조합을 선택하여 퍼뜨리는 최소 시간을 구하는 함수 호출
        selectViruses(0, 0, new int[M]);
        
        // 모든 칸을 채울 수 없으면 -1, 그렇지 않으면 최소 시간 출력
        System.out.println(minTime == Integer.MAX_VALUE ? -1 : minTime);
    }
    
    // 바이러스 M개를 선택하는 함수
    static void selectViruses(int depth, int start, int[] selected) {
        if (depth == M) {
            // 바이러스를 퍼뜨려서 최소 시간을 계산
            spreadVirus(selected);

            return;
        }
        // 바이러스의 가능한 모든 조합을 선택
        for (int i = start; i < viruses.size(); i++) {
            selected[depth] = i;
            selectViruses(depth + 1, i + 1, selected);
        }
    }
    
    // 선택된 바이러스를 퍼뜨리는 함수
    static void spreadVirus(int[] selected) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        int[][] time = new int[N][N];
        int filled = 0, maxTime = 0;
        
        // 선택된 바이러스의 위치를 큐에 넣고, visited 배열을 초기화
        for (int index : selected) {
            int[] v = viruses.get(index);
            queue.offer(v);
            visited[v[0]][v[1]] = true;
        }
        
        // BFS로 바이러스를 퍼뜨림
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0], y = curr[1];
            
            // 상하좌우로 바이러스를 퍼뜨림
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d], ny = y + dy[d];
                // 연구소 밖으로 나가거나 벽이거나 이미 방문한 곳은 건너뜀
                if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny] || lab[nx][ny] == 1) continue;
                
                queue.offer(new int[]{nx, ny});
                visited[nx][ny] = true;
                time[nx][ny] = time[x][y] + 1;
                // 빈 칸을 채우면 filled 증가, 최대 시간을 갱신
                if (lab[nx][ny] == 0) {
                    filled++;

                    maxTime = Math.max(maxTime, time[nx][ny]);
                }
            }
        }
        
        // 모든 빈 칸을 채운 경우, 최소 시간을 갱신
        if (filled == emptySpaces) minTime = Math.min(minTime, maxTime);
    }
}
