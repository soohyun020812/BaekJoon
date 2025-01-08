package four;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

// 10811 바구니 뒤집기
public class Main10811 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄 입력 : N(바구니 개수) M(역순 작업 횟수)
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] baskets = new int[N];
        for (int i = 0; i < N; i++) {
            baskets[i] = i + 1;
        }

        // M번의 역순 작업 처리
        for (int t = 0; t < M; t++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken()) - 1; 
            int j = Integer.parseInt(st.nextToken()) - 1; 

            // while 사용하여 양 끝부터 교환하며 역순 처리
            while (i < j) {
                int temp = baskets[i];
                baskets[i] = baskets[j];
                baskets[j] = temp;
                i++;
                j--;
            }
        }

        // 배열의 모든 값을 공백으로 구분하여 출력
        StringBuilder sb = new StringBuilder();
        for (int basket : baskets) {
            sb.append(basket).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
