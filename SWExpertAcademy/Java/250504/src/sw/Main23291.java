package sw;
import java.io.*;

// 23291 어항 정리 
public class Main23291 {
	static int n, k;
    static int[][] aquarium;
    // 상, 우, 하, 좌 방향 이동
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
 
    public static void main(String[] args) throws IOException {
    	// 입력값 초기화
        initialize();
 
        int count = 0;
        
        // 물고기 수 차이가 k 이하가 될 때까지 반복
        while (maxDifferenceExceeds(k)) {
            count++;
            // 1. 가장 적은 어항에 물고기 1마리 추가
            increaseFish();
            // 2. 어항을 공중 부양 및 회전시켜 쌓기
            firstFold();
            // 3. 인접 어항끼리 물고기 수 조절
            spreadAlgae();
            // 4. 어항을 다시 일렬로 펼치기
            unfold();
            // 5. 어항을 두 번 접기
            secondFold();
            // 6. 다시 인접 어항끼리 물고기 수 조절
            spreadAlgae();
            // 7. 마지막으로 일렬로 펼치기
            unfold();
        }
 
        System.out.println(count);
    }
 
    // 현재 어항에서 물고기 수의 최대, 최소 차이가 k를 초과하는지 확인
    public static boolean maxDifferenceExceeds(int k) {
        int minFish = Integer.MAX_VALUE;
        int maxFish = Integer.MIN_VALUE;
 
        for (int i = 0; i < n; i++) {
            minFish = Math.min(minFish, aquarium[i][0]);
            maxFish = Math.max(maxFish, aquarium[i][0]);
        }
 
        return maxFish - minFish > k;
    }
 
    // 물고기 수가 가장 적은 어항들에 물고기 1마리씩 추가
    public static void increaseFish() {
        int minFish = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++)
            minFish = Math.min(minFish, aquarium[i][0]);
 
        for (int i = 0; i < n; i++) {
            if (aquarium[i][0] == minFish)
                aquarium[i][0]++;
        }
    }
 
    // 어항을 시계방향으로 90도 회전하여 쌓기 (공중 부양)
    public static void firstFold() {
        int startX = 0;
        int vertical = 1;
        int horizontal = 1;

        // 왼쪽부터 가능한 만큼 반복해서 회전 쌓기 
        while (startX + vertical + horizontal <= n) {
            for (int i = vertical - 1; i >= 0; i--) {
                for (int j = 0; j < horizontal; j++) {
                    int newX = startX + vertical + j;
                    int newY = vertical - i;
                    aquarium[newX][newY] = aquarium[startX + i][j];
                    aquarium[startX + i][j] = 0;
                }
            }
            
            startX += vertical;
            
            // 회전할 형태를 교대로 바꿈
            // (정사각에서 세로로 늘림, 다시 정사각 등)
            if (vertical == horizontal) horizontal++;
            else vertical++;
        }
    }
 
    // 인접한 어항들 간의 물고기 수 차이에 따라 분배 
    public static void spreadAlgae() {
        int[][] save = new int[n][25];
        boolean[][] visited = new boolean[n][25];
 
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < 25; y++) {
                visited[x][y] = true;
                if (aquarium[x][y] == 0) continue;
 
                for (int dir = 0; dir < 4; dir++) {
                    int newX = x + dx[dir];
                    int newY = y + dy[dir];
                    
                    // 인접 어항이 존재하고 아직 방문하지 않았으며, 값이 0이 아닌 경우
                    if (isValid(newX, newY) && !visited[newX][newY] && aquarium[newX][newY] != 0) {
                        int diff = (aquarium[x][y] - aquarium[newX][newY]) / 5;
                        if (Math.abs(diff) >= 1) {
                            save[x][y] -= diff;
                            save[newX][newY] += diff;
                        }
                    }
                }
            }
        }
 
        // 임시 배열을 이용해 일괄 적용
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < 25; y++) {
                aquarium[x][y] += save[x][y];
            }
        }
    }
 
    // 어항을 다시 1열로 펼치기 
    public static void unfold() {
        int x = 0;
        while (aquarium[x][0] == 0) x++;
 
        int index = 0;
        int[] save = new int[n];
        for (int i = x; i < n; i++) {
            for (int j = 0; j < 25; j++) {
                if (aquarium[i][j] == 0) break;
                save[index++] = aquarium[i][j];
                aquarium[i][j] = 0;
            }
        }
        for (int i = 0; i < n; i++) {
            aquarium[i][0] = save[i];
        }
    }
 
    // 어항을 2번 접어 총 4층 구조 만들기
    public static void secondFold() {
    	// 왼쪽 절반 접어 2층 만들기
        for (int i = 0; i < n / 2; i++) {
            aquarium[n - 1 - i][1] = aquarium[i][0];
            aquarium[i][0] = 0;
        }
 
        // 위의 두 줄을 다시 반 접어 4층 만들기 
        for (int i = 0; i < n / 4; i++) {
            for (int j = 0; j < 2; j++) {
                aquarium[n - 1 - i][3 - j] = aquarium[n / 2 + i][j];
                aquarium[n / 2 + i][j] = 0;
            }
        }
    }
 
    // 입력 초기화 : n, k 초기 어항 상태 
    static void initialize() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        k = Integer.parseInt(line[1]);
        aquarium = new int[n][25];
 
        line = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            aquarium[i][0] = Integer.parseInt(line[i]);
        }
    }
 
    // 유효한 좌표인지 확인
    public static boolean isValid(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < 25;
    }
}

// 코드 출처 : https://lold2424.tistory.com/102
