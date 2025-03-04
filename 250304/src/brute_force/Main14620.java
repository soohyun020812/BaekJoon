package brute_force;
import java.io.*;
import java.util.*;

// 14620 꽃길 
public class Main14620 {
	static int N, minCost = Integer.MAX_VALUE;
    static int[][] garden;
    static boolean[][] visited;

    // 방향 : 중심 + 4방향 (상, 하, 좌, 우)
    static int[] dx = {0, 1, -1, 0, 0};
    static int[] dy = {0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        garden = new int[N][N];
        visited = new boolean[N][N];

        // 화단 비용 입력
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                garden[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 백트래킹 탐색 시작
        findMinCost(0, 0);
        System.out.println(minCost);
    }

    // 백트래킹을 이용하여 꽃 3개를 선택하는 함수
    static void findMinCost(int count, int cost) {
    	// 꽃 3개를 심었으면 최소 비용 갱신
    	if (count == 3) {  
            minCost = Math.min(minCost, cost);
        
            return;
        }

        // 꽃을 심을 수 있는 위치 탐색 (1~N-2 범위에서만 선택)
        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < N - 1; j++) {
                if (canPlant(i, j)) {
                    int flowerCost = plant(i, j, true);
                    findMinCost(count + 1, cost + flowerCost);
                    // 원상 복구
                    plant(i, j, false);  
                }
            }
        }
    }

    // 해당 위치에 꽃을 심을 수 있는지 검사
    static boolean canPlant(int x, int y) {
        for (int d = 0; d < 5; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            // 이미 꽃이 있으면 불가능
            if (visited[nx][ny]) return false;  
        }
        
        return true;
    }

    // 꽃을 심거나 제거하는 함수
    static int plant(int x, int y, boolean flag) {
        int cost = 0;
        for (int d = 0; d < 5; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            visited[nx][ny] = flag;
            // 꽃 심을 때 비용 누적
            cost += garden[nx][ny];  
        }
        
        return cost;
    }
}
