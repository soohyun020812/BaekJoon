package _16;
import java.io.*;
import java.util.*;

// 28278 스택 2
public class Main28278 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // 명령 개수 N 입력 받기
        int N = Integer.parseInt(br.readLine());
        
        // 스택 생성
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i < N; i++) {
            // 명령어 입력 받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());

            switch (command) {
            	// 1 : 정수 X를 스택에 넣는다.
            	case 1: 
                    int X = Integer.parseInt(st.nextToken());
                    stack.push(X);
                    break;
                // 2 : 스택의 맨 위 정수를 빼고 출력, 없으면 -1 출력
                case 2: 
                    sb.append(stack.isEmpty() ? -1 : stack.pop()).append("\n");
                    break;
                // 3 : 스택에 들어있는 정수의 개수 출력
                case 3: 
                    sb.append(stack.size()).append("\n");
                    break;
                // 4 : 스택이 비어있으면 1, 아니면 0 출력
                case 4: 
                    sb.append(stack.isEmpty() ? 1 : 0).append("\n");
                    break;
                // 5 : 스택의 맨 위 정수를 출력, 없으면 -1 출력
                case 5: 
                    sb.append(stack.isEmpty() ? -1 : stack.peek()).append("\n");
                    break;
            }
        }
        
        System.out.print(sb);
    }
}
