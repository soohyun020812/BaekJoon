package data_structure;
import java.io.*;

// 3986 좋은 단어 
public class Main3986 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); 
        // 좋은 단어의 개수
        int count = 0; 

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            // 좋은 단어이면 개수 증가
            if (isGoodWord(word)) count++; 
        }

        System.out.println(count); 
    }

    // 좋은 단어인지 판별 (스택 사용)
    private static boolean isGoodWord(String word) {
        java.util.Stack<Character> stack = new java.util.Stack<>();

        for (char ch : word.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == ch) {
            	// 같은 문자면 짝을 지어 제거
            	stack.pop(); 
            } else {
            	// 다른 문자면 스택에 추가
                stack.push(ch); 
            }
        }

        // 스택이 비어있으면 좋은 단어
        return stack.isEmpty(); 
    }
}
