package four;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
// StringTokenizer : 클래스는 문자열을 구분자를 이용하여 분리할 때 사용할 수 있음
import java.util.StringTokenizer;

// 10810 공 넣기
public class Main10810 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄 입력 : N(바구니 개수) M(공을 넣는 횟수)
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // N개의 바구니를 0으로 초기화 (공이 없는 상태)
        int[] baskets = new int[N];

        // M번의 작업 처리
        for (int t = 0; t < M; t++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken()) - 1; 
            int j = Integer.parseInt(st.nextToken()) - 1; 
            int k = Integer.parseInt(st.nextToken()); 

            // i번 바구니부터 j번 바구니까지 공 번호 k를 넣음
            for (int b = i; b <= j; b++) {
                baskets[b] = k;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int ball : baskets) {
            sb.append(ball).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
