package seven;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

// 2563 색종이
public class Main2563 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 도화지 크기 : 100x100
        boolean[][] paper = new boolean[100][100];
        // 검은 영역 넓이
        int totalArea = 0; 

        // 색종이 수 입력
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 색종이의 왼쪽 변 위치
            int x = Integer.parseInt(st.nextToken()); 
            // 색종이의 아래쪽 변 위치
            int y = Integer.parseInt(st.nextToken()); 

            // 색종이 붙이기
            // 가로
            for (int r = x; r < x + 10; r++) { 
            	// 세로
                for (int c = y; c < y + 10; c++) { 
                	// 아직 색종이가 안 붙은 영역이면
                	if (!paper[r][c]) { 
                        paper[r][c] = true;
                        // 검은 영역 넓이를 증가
                        totalArea++; 
                    }
                }
            }
        }

        System.out.println(totalArea);
    }
}
