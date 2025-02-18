package data_structure;
import java.io.*;
import java.util.*;

// 10845 큐 
public class Main10845 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); 
        // 큐 선언
        Queue<Integer> queue = new LinkedList<>(); 
        // 마지막으로 추가된 원소 저장 = back 연산을 위해
        int last = -1; 

        // 명령의 개수 입력 
        int N = Integer.parseInt(br.readLine()); 

        // 명령을 하나씩 처리
        for (int i = 0; i < N; i++) {
            String command = br.readLine(); 
            
            // push 연산 
            if (command.startsWith("push")) {
            	// push X에서 X값 추출
                int num = Integer.parseInt(command.split(" ")[1]); 
                // 큐에 추가
                queue.offer(num); 
                // 마지막 원소 업데이트
                last = num; 
            } 
            // pop 연산
            else if (command.equals("pop")) {
                sb.append(queue.isEmpty() ? -1 : queue.poll()).append("\n");
            } 
            // size 연산
            else if (command.equals("size")) {
                sb.append(queue.size()).append("\n");
            } 
            // empty 연산
            else if (command.equals("empty")) {
                sb.append(queue.isEmpty() ? 1 : 0).append("\n");
            } 
            // front 연산
            else if (command.equals("front")) {
                sb.append(queue.isEmpty() ? -1 : queue.peek()).append("\n");
            } 
            // back 연산
            else if (command.equals("back")) {
                sb.append(queue.isEmpty() ? -1 : last).append("\n");
            }
        }

        System.out.print(sb);
    }
}
