package implementation;
import java.io.*;
import java.util.*;

// 16926 배열 돌리기 1
public class Main16926 {
	static int N, M, R;
    static int[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N : 행, M : 열, R : 회전 횟수
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        // 배열 입력
        matrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 회전 실행
        rotateMatrix();

        StringBuilder sb = new StringBuilder();
        for (int[] row : matrix) {
            for (int num : row) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static void rotateMatrix() {
    	// 레이어 개수
        int layers = Math.min(N, M) / 2;  

        for (int layer = 0; layer < layers; layer++) {
            // 현재 레이어의 행, 열 범위
            int startRow = layer, endRow = N - layer - 1;
            int startCol = layer, endCol = M - layer - 1;

            // 현재 레이어의 길이
            int layerSize = 2 * (endRow - startRow + endCol - startCol);

            // 1차원 리스트에 저장
            List<Integer> list = new ArrayList<>();
            // 위쪽
            for (int j = startCol; j <= endCol; j++) list.add(matrix[startRow][j]);  
            // 오른쪽
            for (int i = startRow + 1; i <= endRow; i++) list.add(matrix[i][endCol]);  
            // 아래쪽
            for (int j = endCol - 1; j >= startCol; j--) list.add(matrix[endRow][j]);  
            // 왼쪽
            for (int i = endRow - 1; i > startRow; i--) list.add(matrix[i][startCol]);  

            // 회전 (R % layerSize만큼 이동)
            int shift = R % layerSize;
            Collections.rotate(list, -shift);

            // 다시 배열에 채우기
            int idx = 0;
            // 위쪽
            for (int j = startCol; j <= endCol; j++) matrix[startRow][j] = list.get(idx++);  
            // 오른쪽
            for (int i = startRow + 1; i <= endRow; i++) matrix[i][endCol] = list.get(idx++);  
            // 아래쪽
            for (int j = endCol - 1; j >= startCol; j--) matrix[endRow][j] = list.get(idx++);  
            // 왼쪽
            for (int i = endRow - 1; i > startRow; i--) matrix[i][startCol] = list.get(idx++);  
        }
    }
}
