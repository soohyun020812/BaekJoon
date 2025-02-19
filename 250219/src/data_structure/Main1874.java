package data_structure;
import java.io.*;
import java.util.*;

// 1874 스택 수열 
public class Main1874 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // 수열의 크기
        int n = Integer.parseInt(br.readLine()); 
        Stack<Integer> stack = new Stack<>();
        // push할 숫자, 1부터 시작
        int num = 1; 
        
        for (int i = 0; i < n; i++) {
        	// 만들고 싶은 숫자
            int target = Integer.parseInt(br.readLine()); 
            
            // target까지 push, 오름차순 유지
            while (num <= target) {
                stack.push(num++);
                sb.append("+\n");
            }

            // pop해야 하는 경우
            if (stack.peek() == target) {
                stack.pop();
                sb.append("-\n");
            } else {
                // 스택의 top이 target과 다르면 불가능한 수열
                System.out.println("NO");
                return;
            }
        }

        System.out.print(sb);
    }
}
