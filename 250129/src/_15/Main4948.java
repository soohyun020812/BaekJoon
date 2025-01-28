package _15;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// 4948 베르트랑 공준 
public class Main4948 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 문제에서 주어진 최대값 (n의 최대값 123,456의 2배)
        int limit = 246912; 
        // 소수를 판별하기 위한 배열
        boolean[] isPrime = new boolean[limit + 1];
        
        // 에라토스테네스의 체 초기화
        // 배열의 모든 값을 true로 초기화 (0과 1 제외)
        for (int i = 2; i <= limit; i++) {
            isPrime[i] = true;
        }
        // 소수 판별 : 2부터 시작하여 배수들을 false로 설정
        for (int i = 2; i * i <= limit; i++) {
        	// i가 소수라면
            if (isPrime[i]) {
                for (int j = i * i; j <= limit; j += i) {
                	// i의 배수는 소수가 아님
                    isPrime[j] = false;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            
            // n보다 크고 2n 이하인 소수의 개수를 저장
            int count = 0;
            // n < x <= 2n 범위의 소수를 카운트
            for (int i = n + 1; i <= 2 * n; i++) {
                if (isPrime[i]) {
                    count++;
                }
            }
            sb.append(count).append("\n");
        }
        
        System.out.print(sb.toString());
    }
}
