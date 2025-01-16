package nine;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
// ArrayList : 한번 생성하면 크기가 고정되는 배열과 다르게 부족한 공간을 자동으로 조정해주는 선형리스트
import java.util.ArrayList;
// Collections : 다수의 데이터를 쉽고 효과적으로 처리할 수 있는 표준화된 방법을 제공하는 클래스의 집합을 의미
import java.util.Collections;

// 2501 약수 구하기
public class Main2501 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        // N은 약수를 구할 숫자
        int N = Integer.parseInt(input[0]);  
        // K는 K번째로 작은 약수를 출력하기 위한 숫자
        int K = Integer.parseInt(input[1]);  
        
        // 약수를 저장할 리스트 생성
        ArrayList<Integer> divisors = new ArrayList<>();
        
        // 1부터 N까지 반복하며 N의 약수를 구함
        // 약수는 N을 나누어 나머지가 0인 숫자들
        for (int i = 1; i <= Math.sqrt(N); i++) {
        	// i가 N의 약수라면
            if (N % i == 0) {  
            	 // i를 약수 리스트에 추가
                divisors.add(i); 
                
                // i와 N / i가 다르면 N / i도 약수이므로 추가
                if (i != N / i) {
                    divisors.add(N / i);
                }
            }
        }
        
        // 구한 약수들을 오름차순으로 정렬
        Collections.sort(divisors);
        
        // K번째 약수를 출력하려면 K-1번째 인덱스를 접근해야 하므로
        // 만약 K가 약수의 개수보다 작거나 같으면 K번째 약수를 출력
        if (K <= divisors.size()) {
        	// K번째 약수를 출력 (K는 1-based index)
            System.out.println(divisors.get(K - 1));  
        } else {
            // 약수의 개수가 K개보다 적으면 0을 출력
            System.out.println(0);
        }
    }
}
