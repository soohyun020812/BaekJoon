package _16;
import java.io.*;
import java.util.*;

// 4949 균형잡힌 세상 
public class Main4949 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); 

        while (true) {
        	// 한 줄씩 입력 받기
            String str = br.readLine(); 
            // 입력이 "."이면 종료
            if (str.equals(".")) break; 

            // isBalanced : 트리의 균형을 판단하는 함수
            // 어떤 노드의 두 개의 서브트리의 높이가 1 이상 차이가 나지 않으면 균형이 잡힌 트리
            // isBalanced 함수로 균형 판단 후 결과 저장
            sb.append(isBalanced(str) ? "yes\n" : "no\n");
        }

        System.out.print(sb); 
    }

    /*
     * 괄호의 균형 여부를 확인하는 함수
     * @param str 입력 문자열
     * @return 균형이 맞으면 true, 아니면 false
    */
	
    public static boolean isBalanced(String str) {
    	// 괄호를 저장할 스택
        Stack<Character> stack = new Stack<>(); 

        // 문자열을 한 글자씩 확인
        for (char ch : str.toCharArray()) { 
            if (ch == '(' || ch == '[') {
            	// 여는 괄호는 스택에 저장
            	stack.push(ch); 
            } else if (ch == ')') {
                // 닫는 소괄호가 나왔을 때, 짝이 맞는 여는 괄호가 있는지 확인
                if (stack.isEmpty() || stack.pop() != '(') {
                	// 스택이 비었거나 짝이 맞지 않으면 "no"
                	return false; 
                }
            } else if (ch == ']') {
                // 닫는 대괄호가 나왔을 때, 짝이 맞는 여는 괄호가 있는지 확인
                if (stack.isEmpty() || stack.pop() != '[') {
                	// 스택이 비었거나 짝이 맞지 않으면 "no"
                	return false; 
                }
            }
        }

        // 모든 문자를 확인한 후 스택이 비어있어야 균형이 맞음
        return stack.isEmpty();
    }
}
