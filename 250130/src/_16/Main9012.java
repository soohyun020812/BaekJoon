package _16;
import java.io.*;

public class Main9012 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); 
        // 테스트 케이스 개수
        int T = Integer.parseInt(br.readLine());  

        for (int i = 0; i < T; i++) {
        	// 한 줄 입력받기
            String input = br.readLine();  
            // VPS 여부 확인
            sb.append(isVPS(input) ? "YES\n" : "NO\n");  
        }
        
        // 결과 한 번에 출력
        System.out.print(sb);  
    }

    // VPS 여부를 판단하는 함수
    public static boolean isVPS(String str) {
    	// 열린 괄호 개수 카운트
    	int count = 0;  

        for (char ch : str.toCharArray()) {
            if (ch == '(') {
            	// 여는 괄호면 증가
                count++;  
            } else {
            	// 닫는 괄호가 더 많으면 NO
                if (count == 0) return false;  
                // 닫는 괄호면 열린 괄호 감소
                count--;  
            }
        }

        // 열린 괄호가 남아있지 않아야 YES
        return count == 0;  
    }
}
