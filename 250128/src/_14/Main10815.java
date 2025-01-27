package _14;
import java.io.*;
import java.util.*;

// 10815 숫자 카드
public class Main10815 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 상근이가 가진 숫자 카드의 개수 N
        int N = Integer.parseInt(br.readLine());

        // 상근이가 가진 숫자 카드 입력받아 Set에 저장
        Set<Integer> cardSet = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cardSet.add(Integer.parseInt(st.nextToken()));
        }

        // 확인할 숫자 카드의 개수 M
        int M = Integer.parseInt(br.readLine());

        // 확인할 숫자 카드 입력받기
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int number = Integer.parseInt(st.nextToken());
            // 카드가 존재하면 1, 없으면 0 추가
            if (cardSet.contains(number)) {
                sb.append(1).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }

        System.out.println(sb.toString().trim());
    }
}
