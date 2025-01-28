package _15;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// 4134 다음 소수 
public class Main4134 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 테스트 케이스 개수 입력
        int T = Integer.parseInt(br.readLine());
        
        // 결과 저장
        StringBuilder sb = new StringBuilder();
        
        // 각 테스트 케이스 처리
        while (T-- > 0) {
            long n = Long.parseLong(br.readLine());
            sb.append(findNextPrime(n)).append("\n");
        }
        
        System.out.println(sb.toString());
    }

    // 소수 판별 함수
    private static boolean isPrime(long num) {
    	// 1은 소수가 아님
    	if (num < 2) return false; 
    	// 2와 3은 소수
        if (num == 2 || num == 3) return true; 
        // 2와 3의 배수는 소수가 아님
        if (num % 2 == 0 || num % 3 == 0) return false; 
        
        // 6k ± 1 규칙을 사용하여 검사
        for (long i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) return false;
        }
        return true;
    }

    // n보다 크거나 같은 가장 작은 소수 찾기
    private static long findNextPrime(long n) {
        while (!isPrime(n)) {
            n++;
        }
        return n;
    }
}
