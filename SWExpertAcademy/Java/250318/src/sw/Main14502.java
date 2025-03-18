package sw;
import java.io.*;
import java.util.*;

// 14502 연구소 
public class Main14502 {
	static int N, M;
    static int[][] lab;
    static int maxSafeArea = 0;

    static List<int[]> emptySpaces = new ArrayList<>();
    static List<int[]> virusPositions = new ArrayList<>();

    // 이동 방향 - 상, 하, 좌, 우 
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lab = new int[N][M];

        // 연구소 데이터 입력 및 빈 칸 / 바이러스 위치 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
                if (lab[i][j] == 0) {
                	// 빈 칸 저장
                    emptySpaces.add(new int[]{i, j});  
                } else if (lab[i][j] == 2) {
                	// 바이러스 저장
                	virusPositions.add(new int[]{i, j});  
                }
            }
        }

        // 벽 세우기 = 백트래킹 방식
        buildWall(0, 0);

        System.out.println(maxSafeArea);
    }

    // 벽을 3개 세우는 모든 경우의 수 탐색 (백트래킹)
    static void buildWall(int wallCount, int start) {
    	// 벽을 3개 세운 경우
    	if (wallCount == 3) { 
            maxSafeArea = Math.max(maxSafeArea, simulateVirusSpread());
        
            return;
        }

        // 빈 공간 중 3개를 선택하여 벽을 세우기
        for (int i = start; i < emptySpaces.size(); i++) {
            int[] pos = emptySpaces.get(i);
            // 벽 세우기
            lab[pos[0]][pos[1]] = 1;  
            // 다음 벽 세우기
            buildWall(wallCount + 1, i + 1);  
            // 백트래킹 (원상복구)
            lab[pos[0]][pos[1]] = 0;  
        }
    }

    // 바이러스 퍼뜨리기 (BFS)
    static int simulateVirusSpread() {
        int[][] tempLab = new int[N][M];
        for (int i = 0; i < N; i++)
        	// 연구소 상태 복사
            tempLab[i] = lab[i].clone(); 

        // 초기 바이러스 위치 삽입
        Queue<int[]> queue = new LinkedList<>(virusPositions); 

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nx = pos[0] + dx[d];
                int ny = pos[1] + dy[d];

                // 범위를 벗어나지 않으면서 빈 칸(0)인 경우에만 바이러스 확산
                if (nx >= 0 && ny >= 0 && nx < N && ny < M && tempLab[nx][ny] == 0) {
                    tempLab[nx][ny] = 2;
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        // 안전 영역 계산 (0의 개수 세기)
        int safeArea = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tempLab[i][j] == 0) safeArea++;
            }
        }

        return safeArea;
    }
}
