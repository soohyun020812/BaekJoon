package sw;
import java.io.*;
import java.util.*;

// 17779 게리맨더링 2
public class Main17779 {
	static int N;
    static int[][] population;
    static int totalPopulation = 0;
    static int minDifference = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        population = new int[N + 1][N + 1];

        // 인구수 입력 받기
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                population[i][j] = Integer.parseInt(st.nextToken());
                // 전체 인구 합산
                totalPopulation += population[i][j]; 
            }
        }

        // 가능한 모든 (x, y, d1, d2) 조합을 탐색
        for (int x = 1; x <= N; x++) {
            for (int y = 1; y <= N; y++) {
                for (int d1 = 1; d1 <= N; d1++) {
                    for (int d2 = 1; d2 <= N; d2++) {
                        if (x + d1 + d2 > N || y - d1 < 1 || y + d2 > N) continue;
                        calculateMinPopulationDifference(x, y, d1, d2);
                    }
                }
            }
        }

        // 최소 인구 차이 출력
        System.out.println(minDifference);
    }

    static void calculateMinPopulationDifference(int x, int y, int d1, int d2) {
        int[][] area = new int[N + 1][N + 1];

        // 5번 선거구 경계선 설정
        for (int i = 0; i <= d1; i++) {
            area[x + i][y - i] = 5;
            area[x + d2 + i][y + d2 - i] = 5;
        }
        for (int i = 0; i <= d2; i++) {
            area[x + i][y + i] = 5;
            area[x + d1 + i][y - d1 + i] = 5;
        }

        // 5번 선거구 내부 채우기
        for (int r = x + 1; r < x + d1 + d2; r++) {
            boolean inside = false;
            for (int c = 1; c <= N; c++) {
                if (area[r][c] == 5) inside = !inside;
                if (inside) area[r][c] = 5;
            }
        }

        int[] populationCount = new int[6];

        // 1번 선거구 (1 ≤ r < x + d1, 1 ≤ c ≤ y)
        for (int r = 1; r < x + d1; r++) {
            for (int c = 1; c <= y; c++) {
                if (area[r][c] == 5) break;
                populationCount[1] += population[r][c];
            }
        }

        // 2번 선거구 (1 ≤ r ≤ x + d2, y < c ≤ N)
        for (int r = 1; r <= x + d2; r++) {
            for (int c = N; c > y; c--) {
                if (area[r][c] == 5) break;
                populationCount[2] += population[r][c];
            }
        }

        // 3번 선거구 (x + d1 ≤ r ≤ N, 1 ≤ c < y - d1 + d2)
        for (int r = x + d1; r <= N; r++) {
            for (int c = 1; c < y - d1 + d2; c++) {
                if (area[r][c] == 5) break;
                populationCount[3] += population[r][c];
            }
        }

        // 4번 선거구 (x + d2 < r ≤ N, y - d1 + d2 ≤ c ≤ N)
        for (int r = x + d2 + 1; r <= N; r++) {
            for (int c = N; c >= y - d1 + d2; c--) {
                if (area[r][c] == 5) break;
                populationCount[4] += population[r][c];
            }
        }

        // 5번 선거구 인구 계산
        populationCount[5] = totalPopulation - (populationCount[1] + populationCount[2] + populationCount[3] + populationCount[4]);

        // 최대 인구와 최소 인구 차이 갱신
        int maxPop = Arrays.stream(populationCount, 1, 6).max().getAsInt();
        int minPop = Arrays.stream(populationCount, 1, 6).min().getAsInt();
        
        minDifference = Math.min(minDifference, maxPop - minPop);
    }
}
