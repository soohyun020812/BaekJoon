package _16;
import java.io.*;
import java.util.*;

// 11866 요세푸스 문제 0 
public class Main11866 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 전체 사람 수 (1번부터 N번까지)
        int N = Integer.parseInt(st.nextToken()); 
        // 제거할 순서 K
        int K = Integer.parseInt(st.nextToken()); 

        // 큐(Deque)를 사용하여 순차적인 삭제 처리
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        // 출력 형식 맞추기 
        sb.append("<");

        // 1부터 N까지 숫자를 큐에 삽입
        for (int i = 1; i <= N; i++) {
        	// 큐의 끝에 추가
            queue.offer(i);
        }

        // 요세푸스 순열 생성
        while (!queue.isEmpty()) {
            // K-1번 앞에서 꺼내서 다시 뒤로 보냄 (K번째 사람을 제거하기 위해)
            for (int i = 0; i < K - 1; i++) {
            	// 맨 앞 원소를 꺼내서 다시 뒤로 삽입
                queue.offer(queue.poll());
            }
            // K번째 사람 제거 후 결과에 추가
            sb.append(queue.poll());
            
            // 남은 요소가 있다면 쉼표 추가 (출력 형식 맞추기)
            if (!queue.isEmpty()) {
                sb.append(", ");
            }
        }

        // 출력 형식 마무리 
        sb.append(">");
        System.out.println(sb);
    }
}
