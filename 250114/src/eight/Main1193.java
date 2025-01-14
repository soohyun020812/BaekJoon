package eight;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// 1193 분수찾기
public class Main1193 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 X
        int X = Integer.parseInt(br.readLine());

        // 대각선 번호 N 찾기
        int N = 1;
        // 대각선 이전까지의 총합
        int sum = 0; 

        while (sum + N < X) {
            sum += N;
            N++;
        }

        // 대각선 내에서의 위치
        int k = X - sum;

        // 분수 계산
        int numerator, denominator;
        if (N % 2 == 0) {
        	// 아래에서 위
            numerator = k; 
            denominator = N - k + 1;
        } else {
        	// 위에서 아래
            numerator = N - k + 1; 
            denominator = k;
        }

        System.out.println(numerator + "/" + denominator);
    }
}
