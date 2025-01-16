package nine;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

// 9506 약수들의 합
public class Main9506 {
    public static ArrayList<Integer> getDivisors(int n) {
        ArrayList<Integer> divisors = new ArrayList<>();
        
        // 1부터 sqrt(n)까지 반복하면서 약수 찾기
        for (int i = 1; i <= Math.sqrt(n); i++) {
        	// i가 n의 약수라면
            if (n % i == 0) {  
            	// i를 약수 리스트에 추가
                divisors.add(i); 
                // i와 n / i가 다르면 n / i도 약수
                if (i != n / i && i != 1) { 
                    divisors.add(n / i);
                }
            }
        }
        
        return divisors;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 여러 테스트 케이스 처리
        while (true) {
            int n = Integer.parseInt(br.readLine()); 
            
            // 입력이 -1이면 종료
            if (n == -1) break; 
            
            // n의 약수들을 구함
            ArrayList<Integer> divisors = getDivisors(n);
            
            // 약수들의 합을 계산
            int sum = 0;
            for (int divisor : divisors) {
                sum += divisor;
            }
            
            // n이 완전수인 경우
            if (sum == n) {
                // 약수들을 오름차순으로 정렬
                Collections.sort(divisors);
                
                // 완전수 출력
                System.out.print(n + " = ");
                for (int i = 0; i < divisors.size(); i++) {
                    if (i == divisors.size() - 1) {
                        System.out.println(divisors.get(i));
                    } else {
                        System.out.print(divisors.get(i) + " + ");
                    }
                }
            } else {
                // 완전수가 아니면 해당 메시지 출력
                System.out.println(n + " is NOT perfect.");
            }
        }
        
        br.close();
    }
}
