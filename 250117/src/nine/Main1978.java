package nine;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// 1978 소수 찾기
public class Main1978 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫 번째 줄 : 수의 개수 N
        int N = Integer.parseInt(br.readLine());
        
        // 두 번째 줄 : N개의 수
        String[] input = br.readLine().split(" ");
        // 소수의 개수
        int count = 0; 
        
        // 각 숫자를 검사
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(input[i]);
            if (isPrime(num)) {
            	 // 소수라면 개수 증가
            	count++;
            }
        }
        
        System.out.println(count);
    }
    
    // 소수 판별 함수
    private static boolean isPrime(int num) {
    	// 1은 소수가 아님
        if (num < 2) return false; 
        for (int i = 2; i <= Math.sqrt(num); i++) {
        	// 나누어떨어지면 소수가 아님
            if (num % i == 0) return false; 
        }
        return true; // 소수임
    }
}
