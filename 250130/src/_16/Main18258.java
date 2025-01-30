package _16;
import java.io.*;
import java.util.*;

// 18258 큐 2
public class Main18258 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // ArrayDeque(Array Double Ended Queue) : 큐의 양 끝에 데이터를 용이하게 추가하고 제거할 수 있음
        // ArrayDeque를 사용하여 큐를 구현
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        
        // 명령의 개수 N을 입력 받기
        int N = Integer.parseInt(br.readLine());

        // N개의 명령을 하나씩 처리
        for (int i = 0; i < N; i++) {
            // 각 명령어를 읽어오기
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 첫 번째 토큰은 명령어
            String command = st.nextToken();

            switch (command) {
                // "push X" : 큐에 정수 X를 넣는 명령
                case "push":
                    // 큐의 뒤에 정수 X를 추가
                    queue.offer(Integer.parseInt(st.nextToken()));
                    break;
                    
                // "pop" : 큐에서 가장 앞의 정수를 빼고 출력
                case "pop":
                    // 큐가 비어있으면 -1 출력, 아니면 pop하고 그 값을 출력
                    sb.append(queue.isEmpty() ? -1 : queue.poll()).append("\n");
                    break;
                    
                // "size" : 큐에 들어있는 정수의 개수를 출력
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                    
                // "empty" : 큐가 비어있으면 1, 아니면 0 출력
                case "empty":
                    sb.append(queue.isEmpty() ? 1 : 0).append("\n");
                    break;
                    
                // "front" : 큐의 가장 앞에 있는 정수를 출력
                case "front":
                    // 큐가 비어있으면 -1 출력, 아니면 front 값을 출력
                    sb.append(queue.isEmpty() ? -1 : queue.peek()).append("\n");
                    break;
                    
                // "back" : 큐의 가장 뒤에 있는 정수를 출력
                case "back":
                    // 큐가 비어있으면 -1 출력, 아니면 back 값을 출력
                    sb.append(queue.isEmpty() ? -1 : queue.peekLast()).append("\n");
                    break;
            }
        }
        
        System.out.println(sb);
    }
}
