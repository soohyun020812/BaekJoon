package four;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

// 10813 공 바꾸기
public class Main10813 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄 입력 : N(바구니 개수) M(교환 횟수)
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 초기 바구니 : 각 바구니에 해당하는 번호의 공이 들어있음
        int[] baskets = new int[N];
        for (int i = 0; i < N; i++) {
            baskets[i] = i + 1;
        }

        // M번의 교환 작업 처리
        for (int t = 0; t < M; t++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken()) - 1; 
            int j = Integer.parseInt(st.nextToken()) - 1; 

            // i번 바구니와 j번 바구니의 공 교환
            // temp : 임시 저장 공간 변수를 칭함
            int temp = baskets[i];
            baskets[i] = baskets[j];
            baskets[j] = temp;
        }

        StringBuilder sb = new StringBuilder();
        for (int ball : baskets) {
            sb.append(ball).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
