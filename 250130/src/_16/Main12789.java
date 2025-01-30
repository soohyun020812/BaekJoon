package _16;
import java.io.*;
import java.util.*;

// 12789 도키도키 간식드리미 
public class Main12789 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 학생 수 입력
        int N = Integer.parseInt(br.readLine()); 
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 대기열 (FIFO : First In, First Out)
        Queue<Integer> queue = new LinkedList<>(); 
        // 임시 공간 (LIFO : Last In, First Out)
        Stack<Integer> stack = new Stack<>(); 

        // 대기열을 입력 받음
        for (int i = 0; i < N; i++) {
            queue.offer(Integer.parseInt(st.nextToken()));
        }

        // 받을 번호표 (1부터 시작)
        int expected = 1; 

        while (!queue.isEmpty() || !stack.isEmpty()) {
            // 대기열의 맨 앞 사람이 번호표 순서에 맞다면 간식 받음
            if (!queue.isEmpty() && queue.peek() == expected) {
            	// 순서가 맞다면 queue.poll()로 제거
                queue.poll();
                expected++;
            }
            // 스택의 맨 위 사람이 번호표 순서에 맞다면 간식 받음
            else if (!stack.isEmpty() && stack.peek() == expected) {
            	// 스택에서도 맞다면 stack.pop()으로 제거
                stack.pop();
                expected++;
            }
            // 위 두 가지 경우가 아니라면, 대기열의 맨 앞 사람을 스택에 넣음
            else if (!queue.isEmpty()) {
            	// queue.poll()을 stack.push()로 이동
                stack.push(queue.poll());
            }
            // 더 이상 진행할 수 없다면 "Sad" 출력 후 종료
            else {
                System.out.println("Sad");
                return;
            }
        }

        // 모든 학생이 순서대로 간식을 받았으면 "Nice" 출력
        System.out.println("Nice");
    }
}
