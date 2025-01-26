package _13;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

// 11650 좌표 정렬하기
public class Main11650 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄에서 점의 개수 N 입력
        int N = Integer.parseInt(br.readLine());

        // 점들을 저장할 2차원 배열
        int[][] points = new int[N][2];

        // 점의 좌표 입력
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // x좌표
            points[i][0] = Integer.parseInt(st.nextToken()); 
            // y좌표
            points[i][1] = Integer.parseInt(st.nextToken()); 
        }

        // 정렬 : x좌표를 기준으로 오름차순, x좌표가 같으면 y좌표를 기준으로 오름차순
        Arrays.sort(points, (a, b) -> {
            if (a[0] == b[0]) {
            	// x가 같으면 y를 비교
                return Integer.compare(a[1], b[1]); 
            }
            // x를 비교
            return Integer.compare(a[0], b[0]); 
        });

        StringBuilder sb = new StringBuilder();
        for (int[] point : points) {
            sb.append(point[0]).append(" ").append(point[1]).append("\n");
        }
        System.out.print(sb);
    }
}
