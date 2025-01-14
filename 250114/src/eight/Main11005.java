package eight;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// 11005 진법 변환 2
public class Main11005 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        // 10진법 수
        int N = Integer.parseInt(input[0]); 
        // 진법
        int B = Integer.parseInt(input[1]); 

        // 10진법에서 B진법 변환
        StringBuilder sb = new StringBuilder();

        while (N > 0) {
        	// 나머지 계산
            int remainder = N % B; 
            if (remainder < 10) {
            	// 숫자 그대로 추가
                sb.append(remainder); 
            } else {
            	// 알파벳으로 변환
                sb.append((char) ('A' + (remainder - 10))); 
            }
            // 몫으로 업데이트
            N /= B; 
        }

        // 결과 출력 시 뒤집기 필요
        System.out.println(sb.reverse().toString());
    }
}
