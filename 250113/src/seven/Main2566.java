package seven;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

// 2566 최댓값
public class Main2566 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 9×9 격자판
        int[][] grid = new int[9][9]; 
        // 최댓값 초기화
        int maxValue = Integer.MIN_VALUE; 
        // 최댓값의 행
        int maxRow = 0;
        // 최댓값의 열
        int maxCol = 0; 

        // 입력 및 최댓값 탐색
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] > maxValue) {
                	// 최댓값 갱신
                    maxValue = grid[i][j]; 
                    // 1부터 시작하는 행 번호
                    maxRow = i + 1; 
                    // 1부터 시작하는 열 번호
                    maxCol = j + 1; 
                }
            }
        }

        System.out.println(maxValue);
        System.out.println(maxRow + " " + maxCol);
    }
}
