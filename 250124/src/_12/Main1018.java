package _12;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// 1018 체스판 다시 칠하기
public class Main1018 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 입력받기
        String[] dimensions = br.readLine().split(" ");
        // 보드의 행 개수
        int N = Integer.parseInt(dimensions[0]); 
        // 보드의 열 개수
        int M = Integer.parseInt(dimensions[1]); 

        // 보드를 저장할 배열
        char[][] board = new char[N][M]; 
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        // 2. 다시 칠해야 하는 정사각형의 최소 개수를 구하기 위한 초기값 설정
        // 결과값: 최소 다시 칠해야 하는 개수
        int minPaint = Integer.MAX_VALUE; 

        // 3. 8×8 크기로 보드를 자르기
        // 시작 행
        for (int i = 0; i <= N - 8; i++) { 
        	// 시작 열
            for (int j = 0; j <= M - 8; j++) { 
                minPaint = Math.min(minPaint, calculatePaint(board, i, j));
            }
        }

        // 4. 결과 출력
        System.out.println(minPaint);
    }

    // 특정 시작점에서 8×8 체스판으로 변환하기 위해 다시 칠해야 하는 개수를 계산하는 함수
    private static int calculatePaint(char[][] board, int startRow, int startCol) {
    	// 왼쪽 위가 'W'로 시작하는 경우
    	int paintCount1 = 0; 
    	// 왼쪽 위가 'B'로 시작하는 경우
        int paintCount2 = 0; 

        // 8×8 체스판을 순회하면서 칠해야 하는 개수 계산
        // 8행
        for (int i = 0; i < 8; i++) { 
        	// 8열
            for (int j = 0; j < 8; j++) { 
                // 현재 칸의 색을 예상하는 기준을 설정
            	// 'W'로 시작
                char expectedColor1 = ((i + j) % 2 == 0) ? 'W' : 'B'; 
                // 'B'로 시작
                char expectedColor2 = ((i + j) % 2 == 0) ? 'B' : 'W'; 

                // 현재 칸이 기준과 다른 경우 다시 칠해야 함
                if (board[startRow + i][startCol + j] != expectedColor1) {
                	// 'W'로 시작하는 체스판 기준
                	paintCount1++; 
                }
                if (board[startRow + i][startCol + j] != expectedColor2) {
                	// 'B'로 시작하는 체스판 기준
                	paintCount2++; 
                }
            }
        }

        // 두 경우 중 더 적게 칠하는 경우를 반환
        return Math.min(paintCount1, paintCount2);
    }
}
