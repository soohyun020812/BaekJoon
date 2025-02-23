package foundations_of_mathematics;
import java.io.*;
import java.util.*;

// 2960 에라토스테네스의 체 
public class Main2960 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        // N까지 저장
        boolean[] isPrime = new boolean[N + 1]; 
        // 처음에는 모든 숫자가 지워지지 않은 상태
        Arrays.fill(isPrime, true); 
        // 지운 숫자의 개수
        int count = 0; 
        
        for (int i = 2; i <= N; i++) {
        	// i가 소수인 경우
        	if (isPrime[i]) { 
        		// i의 배수들을 지움
        		for (int j = i; j <= N; j += i) { 
        			// 아직 지워지지 않은 경우만 처리
        			if (isPrime[j]) { 
        				// 숫자 j를 지움
        				isPrime[j] = false; 
        				// 지운 개수 증가
        				count++; 
        				// K번째 지운 수라면 출력 후 종료
        				if (count == K) { 
                            
        					System.out.println(j);

        					return;
                        }
                    }
                }
            }
        }
    }
}
