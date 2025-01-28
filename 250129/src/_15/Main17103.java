package _15;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// 17103 골드바흐 파티션 
public class Main17103 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 최대 N 값은 1,000,000으로 주어짐
        int MAX = 1000000;
        
        // 소수 여부를 체크하기 위한 배열 (에라토스테네스의 체)
        boolean[] isPrime = new boolean[MAX + 1];
        
        // 0과 1은 소수가 아니므로 false로 설정
        isPrime[0] = isPrime[1] = false;
        
        // 나머지는 소수로 설정
        for (int i = 2; i <= MAX; i++) {
            isPrime[i] = true;
        }
        
        // 에라토스테네스의 체 알고리즘을 이용하여 소수 판별
        for (int i = 2; i * i <= MAX; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= MAX; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        // 테스트 케이스 수
        int T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        // 각 테스트 케이스 처리
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            
            int count = 0;
            
            // 골드바흐 파티션을 찾기 위해 두 소수 p와 N-p를 검사
            for (int i = 2; i <= N / 2; i++) {
                if (isPrime[i] && isPrime[N - i]) {
                    count++;
                }
            }
            
            sb.append(count).append("\n");
        }
        
        System.out.print(sb.toString());
    }
}
