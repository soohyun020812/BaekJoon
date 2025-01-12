package seven;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
// StringTokenizer : 한 줄의 숫자를 공백으로 구분하여 처리
import java.util.StringTokenizer;

// 2738 행렬 덧셈
public class Main2738 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 행렬 크기 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 행의 개수
        int N = Integer.parseInt(st.nextToken()); 
        // 열의 개수
        int M = Integer.parseInt(st.nextToken()); 

        // 행렬 A와 B 입력
        int[][] A = new int[N][M];
        int[][] B = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 행렬 덧셈
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(A[i][j] + B[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
