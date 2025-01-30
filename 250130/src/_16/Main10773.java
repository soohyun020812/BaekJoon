package _16;
import java.io.*;
import java.util.*;

// 10773 제로 
public class Main10773 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력받을 정수의 개수
        int K = Integer.parseInt(br.readLine());  
        
        // 숫자를 저장할 스택
        Stack<Integer> stack = new Stack<>();  

        for (int i = 0; i < K; i++) {
        	// 정수 입력
            int num = Integer.parseInt(br.readLine());  
            
            if (num == 0) {
            	// 최근에 추가한 숫자 제거
                stack.pop();  
            } else {
            	// 스택에 숫자 추가
                stack.push(num);  
            }
        }

        // 스택에 남아 있는 숫자의 합 계산
        int sum = 0;
        for (int num : stack) {
            sum += num;
        }

        System.out.println(sum);  
    }
}
