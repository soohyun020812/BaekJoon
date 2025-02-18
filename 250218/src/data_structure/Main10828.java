package data_structure;
import java.io.*;
import java.util.*;

// 10828 스택 
public class Main10828 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); 
        Stack<Integer> stack = new Stack<>(); 

        // 명령의 개수 입력
        int N = Integer.parseInt(br.readLine()); 

        // 명령을 하나씩 처리
        for (int i = 0; i < N; i++) {
            String command = br.readLine(); 
            
            // push 연산 
            if (command.startsWith("push")) {
                int num = Integer.parseInt(command.split(" ")[1]); // push X에서 X값 추출
                stack.push(num);
            } 
            // pop 연산
            else if (command.equals("pop")) {
                sb.append(stack.isEmpty() ? -1 : stack.pop()).append("\n");
            } 
            // size 연산
            else if (command.equals("size")) {
                sb.append(stack.size()).append("\n");
            } 
            // empty 연산
            else if (command.equals("empty")) {
                sb.append(stack.isEmpty() ? 1 : 0).append("\n");
            } 
            // top 연산
            else if (command.equals("top")) {
                sb.append(stack.isEmpty() ? -1 : stack.peek()).append("\n");
            }
        }

        System.out.print(sb);
    }
}
