package five;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// 2675 문자열 반복
public class Main2675 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 테스트 케이스의 개수 입력
        int T = Integer.parseInt(br.readLine());

        StringBuilder result = new StringBuilder();

        for (int t = 0; t < T; t++) {
            // 각 테스트 케이스 처리
            String[] input = br.readLine().split(" ");
            // 반복 횟수
            int R = Integer.parseInt(input[0]); 
            String S = input[1]; 

            StringBuilder P = new StringBuilder();
            for (char c : S.toCharArray()) {
                for (int i = 0; i < R; i++) {
                	// 문자를 R번 반복하여 추가
                    P.append(c); 
                }
            }

            // 결과 저장
            result.append(P).append("\n"); 
        }

        System.out.print(result);
    }
}
