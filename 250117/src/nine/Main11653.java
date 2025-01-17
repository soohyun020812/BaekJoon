package nine;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// 11653 소인수분해
public class Main11653 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        // 소인수분해 결과 출력
        for (int i = 2; i <= Math.sqrt(N); i++) {
        	// i가 N의 약수인 동안
        	while (N % i == 0) {
        		// 소인수 출력
                System.out.println(i); 
                // N을 i로 나누기
                N /= i; 
            }
        }
        
        // 남은 수가 소수일 경우 출력
        if (N > 1) {
            System.out.println(N);
        }
    }
}
