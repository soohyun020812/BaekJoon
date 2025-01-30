package _16;
import java.io.*;
import java.util.*;

// 28279 덱 2 
public class Main28279 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); 
        // ArrayDeque를 사용하여 덱 구현
        Deque<Integer> deque = new ArrayDeque<>(); 

        // 명령 개수 입력
        int N = Integer.parseInt(br.readLine()); 

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 명령어 숫자 입력
            int command = Integer.parseInt(st.nextToken()); 

            switch (command) {
            	// 정수 X를 덱의 앞에 넣기
                case 1: 
                    int x1 = Integer.parseInt(st.nextToken());
                    deque.addFirst(x1);
                    break;
                // 정수 X를 덱의 뒤에 넣기
                case 2: 
                    int x2 = Integer.parseInt(st.nextToken());
                    deque.addLast(x2);
                    break;
                // 덱 맨 앞의 정수를 빼고 출력
                case 3: 
                    sb.append(deque.isEmpty() ? -1 : deque.pollFirst()).append("\n");
                    break;
                // 덱 맨 뒤의 정수를 빼고 출력
                case 4: 
                    sb.append(deque.isEmpty() ? -1 : deque.pollLast()).append("\n");
                    break;
                // 덱에 들어있는 정수 개수 출력
                case 5: 
                    sb.append(deque.size()).append("\n");
                    break;
                // 덱이 비어있으면 1, 아니면 0 출력
                case 6: 
                    sb.append(deque.isEmpty() ? 1 : 0).append("\n");
                    break;
                // 덱 맨 앞의 정수 출력
                case 7: 
                    sb.append(deque.isEmpty() ? -1 : deque.peekFirst()).append("\n");
                    break;
                // 덱 맨 뒤의 정수 출력
                case 8: 
                    sb.append(deque.isEmpty() ? -1 : deque.peekLast()).append("\n");
                    break;
            }
        }

        System.out.print(sb);
    }
}
