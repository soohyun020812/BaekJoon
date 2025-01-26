package _13;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

// 11651 좌표 정렬하기 2
public class Main11651 {
	public static void main(String[] args) throws IOException {
        // 입력을 빠르게 처리하기 위해 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 줄에서 점의 개수 N 입력 받기
        int N = Integer.parseInt(br.readLine());

        // 점을 저장할 2차원 배열 생성
        int[][] points = new int[N][2];

        // 점 데이터 입력
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // x좌표
            points[i][0] = Integer.parseInt(st.nextToken()); 
            // y좌표
            points[i][1] = Integer.parseInt(st.nextToken()); 
        }

        // 정렬 : y좌표를 기준으로 오름차순, y가 같으면 x좌표를 기준으로 오름차순
        Arrays.sort(points, (a, b) -> {
            if (a[1] == b[1]) {
            	// y좌표가 같으면 x좌표 비교
                return Integer.compare(a[0], b[0]); 
            }
            // y좌표 우선 비교
            return Integer.compare(a[1], b[1]); 
        });

        // 출력 결과를 저장할 StringBuilder
        StringBuilder sb = new StringBuilder();

        for (int[] point : points) {
            sb.append(point[0]).append(" ").append(point[1]).append("\n");
        }

        System.out.print(sb);
    }
}
