package five;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 11720 숫자의 합
public class Main11720 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String numbers = br.readLine();

        int sum = 0;
        for (int i = 0; i < N; i++) {
        	// 각 문자를 숫자로 변환 후 더하기
            sum += numbers.charAt(i) - '0'; 
        }

        System.out.println(sum);
    }
}
