package nine;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// 2581 소수
public class Main2581 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        // 소수 판별을 위한 배열 생성 (에라토스테네스의 체)
        // 소수가 아니면 true
        boolean[] isNotPrime = new boolean[N + 1]; 
        // 0과 1은 소수가 아님
        isNotPrime[0] = true; 
        isNotPrime[1] = true; 

        // 2부터 √N까지의 숫자로 배수 제거
        for (int i = 2; i <= Math.sqrt(N); i++) {
        	// i가 소수라면
            if (!isNotPrime[i]) { 
                for (int j = i * i; j <= N; j += i) {
                	// i의 배수는 소수가 아님
                    isNotPrime[j] = true; 
                }
            }
        }

        // 소수의 합
        int sum = 0; 
        // 소수 중 최솟값
        int min = Integer.MAX_VALUE; 

        // M부터 N까지 소수 찾기
        for (int i = M; i <= N; i++) {
        	// i가 소수라면
            if (!isNotPrime[i]) { 
            	// 합계에 추가
            	sum += i; 
                if (min == Integer.MAX_VALUE) {
                	// 첫 번째 소수를 최솟값으로 설정
                	min = i; 
                }
            }
        }

        // 소수가 없는 경우
        if (sum == 0) { 
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}
