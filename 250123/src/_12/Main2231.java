package _12;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// 2231 분해합
public class Main2231 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 자연수 N 입력받기
        int N = Integer.parseInt(br.readLine());

        // 가장 작은 생성자를 저장할 변수
        int result = 0;

        // 생성자 탐색 : 1부터 N까지 순회
        for (int i = 1; i < N; i++) {
        	// 분해합의 초기값은 자기 자신
        	int sum = i; 
            int temp = i;

            // 각 자리수 더하기
            while (temp > 0) {
            	// 마지막 자리수 더하기
                sum += temp % 10; 
                // 다음 자리로 이동
                temp /= 10; 
            }

            // 분해합이 N과 같으면, 해당 숫자가 생성자
            if (sum == N) {
                result = i;
                // 가장 작은 생성자를 찾았으므로 종료
                break; 
            }
        }

        // 생성자가 없으면 result는 0
        System.out.println(result);
    }
}
