package _14;
import java.io.*;
import java.util.*;

// 10816 숫자 카드 2
public class Main10816 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 숫자 카드 개수 N 입력
        int N = Integer.parseInt(br.readLine());

        // 숫자 카드 배열 입력 및 카운팅
        Map<Integer, Integer> cardCount = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            cardCount.put(num, cardCount.getOrDefault(num, 0) + 1);
        }

        // 질문 개수 M 입력
        int M = Integer.parseInt(br.readLine());

        // 질문 배열 입력 및 결과 처리
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int query = Integer.parseInt(st.nextToken());
            sb.append(cardCount.getOrDefault(query, 0)).append(" ");
        }

        System.out.print(sb.toString().trim());
    }
}
