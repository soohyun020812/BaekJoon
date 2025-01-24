package _12;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main2839 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 설탕의 무게 N (3 ≤ N ≤ 5000)
        int N = Integer.parseInt(br.readLine()); 
        // 봉지의 개수를 저장할 변수
        int count = 0; 

        // 봉지 개수를 최소화하는 로직
        while (true) {
            // N이 5로 나누어떨어질 경우, 최대한 많은 5kg 봉지를 사용
            if (N % 5 == 0) {
            	// 5kg 봉지 개수를 추가
                count += N / 5; 
                System.out.println(count);
                break;
            }
            // N이 5로 나누어떨어지지 않으면 3kg 봉지를 하나 사용
            N -= 3;
            count++;

            // N이 0보다 작아지면 정확히 나눌 수 없는 경우
            if (N < 0) {
                System.out.println(-1);
                break;
            }
        }
    }
}
