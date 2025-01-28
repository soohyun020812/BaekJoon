package _15;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

// 1929 소수 구하기 
public class Main1929 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력값 읽기
        String[] input = br.readLine().split(" ");
        int M = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);
        
        // 소수 구하기
        boolean[] isPrime = new boolean[N + 1];
        // 모든 수를 소수로 초기화
        Arrays.fill(isPrime, true); 
        // 0과 1은 소수가 아님
        isPrime[0] = isPrime[1] = false; 
        
        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                	// i의 배수는 소수가 아님
                	isPrime[j] = false; 
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = M; i <= N; i++) {
            if (isPrime[i]) {
                sb.append(i).append("\n");
            }
        }
        
        System.out.print(sb.toString());
    }
}
